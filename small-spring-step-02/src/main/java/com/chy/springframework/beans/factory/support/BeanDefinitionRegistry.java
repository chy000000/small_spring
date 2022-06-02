package com.chy.springframework.beans.factory.support;

import com.chy.springframework.beans.factory.config.BeanDefinition;

/**
 * @Author: chy
 * @Date: 2022/5/4 14:52
 * @Description:
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
