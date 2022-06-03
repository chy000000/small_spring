package com.chy.springframework.beans.factory;

import com.chy.springframework.beans.BeansException;

/**
 * @Author: chy
 * @Date: 2022/5/4 15:42
 * @Description:
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
