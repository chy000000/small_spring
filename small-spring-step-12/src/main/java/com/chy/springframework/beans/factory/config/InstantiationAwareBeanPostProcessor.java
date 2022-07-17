package com.chy.springframework.beans.factory.config;

/**
 * @Author: chy
 * @Date: 2022/7/15 16:46
 * @Description:
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName);
}
