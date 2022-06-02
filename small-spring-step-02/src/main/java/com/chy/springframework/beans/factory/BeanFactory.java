package com.chy.springframework.beans.factory;

import com.chy.springframework.beans.BeansException;

/**
 * @Author: chy
 * @Date: 2022/5/4 14:50
 * @Description:
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;
}
