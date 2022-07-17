package com.chy.springframework.beans.factory;

import java.util.Map;

/**
 * @Author: com.chy
 * @Date: 2022/5/7 15:38
 * @Description:
 */
public interface ListableBeanFactory extends BeanFactory {
    <T> Map<String, T> getBeansOfType(Class<T> type);

    String[] getBeanDefinitionNames();
}
