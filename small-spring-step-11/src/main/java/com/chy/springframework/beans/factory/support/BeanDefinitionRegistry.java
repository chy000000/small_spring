package com.chy.springframework.beans.factory.support;

import com.chy.springframework.beans.factory.config.BeanDefinition;

/**
 * @Author: com.chy
 * @Date: 2022/5/4 15:49
 * @Description:
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);

}
