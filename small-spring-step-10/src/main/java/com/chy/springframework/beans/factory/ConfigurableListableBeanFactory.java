package com.chy.springframework.beans.factory;

import com.chy.springframework.beans.BeansException;
import com.chy.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.chy.springframework.beans.factory.config.BeanDefinition;
import com.chy.springframework.beans.factory.config.BeanPostProcessor;
import com.chy.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @Author: com.chy
 * @Date: 2022/5/7 15:44
 * @Description:
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
