package com.chy.springframework.beans;

import com.chy.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.chy.springframework.beans.factory.config.BeanDefinition;
import com.chy.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @Author: chy
 * @Date: 2022/5/7 15:44
 * @Description:
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
