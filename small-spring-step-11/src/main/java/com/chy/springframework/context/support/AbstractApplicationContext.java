package com.chy.springframework.context.support;

import cn.hutool.core.bean.BeanException;
import com.chy.springframework.beans.BeansException;
import com.chy.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.chy.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.chy.springframework.beans.factory.config.BeanPostProcessor;
import com.chy.springframework.context.ApplicationEvent;
import com.chy.springframework.context.ApplicationListener;
import com.chy.springframework.context.ConfigurableApplicationContext;
import com.chy.springframework.context.event.ApplicationEventMulticaster;
import com.chy.springframework.context.event.ContextClosedEvent;
import com.chy.springframework.context.event.ContextRefreshedEvent;
import com.chy.springframework.context.event.SimpleApplicationEventMulticaster;
import com.chy.springframework.core.io.DefaultResourceLoader;

import java.util.Collection;
import java.util.Map;

public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    public static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME = "applicationEventMulticaster";

    private ApplicationEventMulticaster applicationEventMulticaster;

    @Override
    public void refresh() throws BeansException {
        // 1. 创建BeanFactory，并加载BeanDefinition
        refreshBeanFactory();
        
        // 2. 获取BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        
        // 3. 添加ApplicationAwareProcessor，让继承ApplicationContextAware的Bean对象都能感知所属的ApplicationContext
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));

        // 4. 在Bean实例化之前，执行BeanFactoryPostProcessor（Invoke factory processors registered as beans in the context.）
        invokeBeanFactoryPostProcessors(beanFactory);

        // 5. BeanPostProcessor需要提前于其他Bean对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);
        
        // 6. 初始化事件发布者
        initApplicationEventMulticaster();
        
        // 7. 注册事件监听器
        registerListeners();
        
        // 8. 提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();
        
        // 9. 发布容器刷新完成事件
        finishRefresh();
        
    }

    private void finishRefresh() throws BeansException {
        publishEvent(new ContextRefreshedEvent(this));
    }

    @Override
    public void publishEvent(ApplicationEvent event) throws BeansException {
        applicationEventMulticaster.multicastEvent(event);
    }

    private void registerListeners() {
        Collection<ApplicationListener> applicationListeners = getBeansOfType(ApplicationListener.class).values();
        for (ApplicationListener listener: applicationListeners) {
            applicationEventMulticaster.addApplicationListener(listener);
        }
    }

    private void initApplicationEventMulticaster() throws BeansException {
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
        beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, applicationEventMulticaster);
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor: beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor: beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }

    }

    protected abstract void refreshBeanFactory() throws BeanException, BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                close();
            } catch (BeansException e) {
                e.printStackTrace();
            }
        }));
    }

    @Override
    public void close() throws BeansException {
        publishEvent(new ContextClosedEvent(this));
        getBeanFactory().destroySingletons();
    }
}
