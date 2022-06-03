package com.chy.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanException;
import com.chy.springframework.beans.BeansException;
import com.chy.springframework.beans.ConfigurableListableBeanFactory;
import com.chy.springframework.beans.factory.config.BeanDefinition;
import com.chy.springframework.beans.factory.config.BeanPostProcessor;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: chy
 * @Date: 2022/5/4 15:49
 * @Description:
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) throw new BeansException("No bean named '" + beanName + "' is defined");
        return beanDefinition;
    }

    @Override
    public void preInstantiateSingletons() throws BeansException {
        for (String s : beanDefinitionMap.keySet()) {
            getBean(s);
        }
    }

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {

    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeanException {
        HashMap<String, T> result = new HashMap<>();
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            Class beanClass = beanDefinition.getBeanClass();
            if (type.isAssignableFrom(beanClass)) {
                try {
                    result.put(beanName, (T) getBean(beanName));
                } catch (BeansException e) {
                    e.printStackTrace();
                }
            }
        });
        return result;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }
}
