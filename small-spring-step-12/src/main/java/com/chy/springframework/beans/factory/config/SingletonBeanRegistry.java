package com.chy.springframework.beans.factory.config;

/**
 * @Author: com.chy
 * @Date: 2022/5/4 15:49
 * @Description:
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);
}
