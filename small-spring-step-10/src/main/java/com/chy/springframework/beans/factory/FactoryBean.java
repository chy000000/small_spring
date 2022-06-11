package com.chy.springframework.beans.factory;

/**
 * @Author: chy
 * @Date: 2022/6/10 20:41
 * @Description:
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
