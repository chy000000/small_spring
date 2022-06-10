package com.chy.springframework.beans.factory;

import com.chy.springframework.beans.BeansException;

/**
 * @Author: chy
 * @Date: 2022/6/10 14:54
 * @Description:
 */
public interface BeanFactoryAware extends Aware {
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
