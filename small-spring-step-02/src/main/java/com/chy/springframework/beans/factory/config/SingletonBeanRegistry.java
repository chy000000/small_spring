package com.chy.springframework.beans.factory.config;

/**
 * @Author: chy
 * @Date: 2022/5/4 14:51
 * @Description:
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
