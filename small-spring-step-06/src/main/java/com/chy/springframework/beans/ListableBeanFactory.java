package com.chy.springframework.beans;

import com.chy.springframework.beans.factory.BeanFactory;

import java.util.Map;

/**
 * @Author: chy
 * @Date: 2022/5/7 15:38
 * @Description:
 */
public interface ListableBeanFactory extends BeanFactory {
    <T> Map<String, T> getBeansOfType(Class<T> type);

    String[] getBeanDefinitionNames();
}
