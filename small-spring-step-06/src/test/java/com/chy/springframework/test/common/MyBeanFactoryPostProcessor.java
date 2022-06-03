package com.chy.springframework.test.common;

import com.chy.springframework.beans.BeansException;
import com.chy.springframework.beans.ConfigurableListableBeanFactory;
import com.chy.springframework.beans.factory.PropertyValue;
import com.chy.springframework.beans.factory.PropertyValues;
import com.chy.springframework.beans.factory.config.BeanDefinition;
import com.chy.springframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }
}
