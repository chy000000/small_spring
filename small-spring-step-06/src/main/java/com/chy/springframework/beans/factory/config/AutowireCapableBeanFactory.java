package com.chy.springframework.beans.factory.config;

import com.chy.springframework.beans.BeansException;
import com.chy.springframework.beans.factory.BeanFactory;

/**
 * @Author: chy
 * @Date: 2022/5/7 15:37
 * @Description:
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
