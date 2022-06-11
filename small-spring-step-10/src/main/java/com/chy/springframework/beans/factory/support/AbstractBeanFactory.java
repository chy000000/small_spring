package com.chy.springframework.beans.factory.support;

import com.chy.springframework.beans.BeansException;
import com.chy.springframework.beans.factory.FactoryBean;
import com.chy.springframework.beans.factory.config.BeanDefinition;
import com.chy.springframework.beans.factory.config.BeanPostProcessor;
import com.chy.springframework.beans.factory.config.ConfigurableBeanFactory;
import com.chy.springframework.utils.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: com.chy
 * @Date: 2022/5/4 15:49
 * @Description:
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    protected <T> T doGetBean(final String name, final Object[] args) throws BeansException {
        Object sharedInstance  = getSingleton(name);
        if (sharedInstance  != null) {
            return (T) getObjectForBeanInstance(sharedInstance , name);
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = createBean(name, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, name);
    }

    private Object getObjectForBeanInstance(Object beanInstance , String name) throws BeansException {
        if (!(beanInstance  instanceof FactoryBean)) {
            return beanInstance;
        }

        Object object = getCachedObjectForFactoryBean(name);

        if (null==object) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance ;
            object = getObjectFromFactoryBean(factoryBean, name);
        }
        return object;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }


    public List<BeanPostProcessor> getBeanPostProcessors() {
        return beanPostProcessors;
    }

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }
}
