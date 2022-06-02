package com.chy.springframework.beans.factory.config;

import com.chy.springframework.beans.HierarchicalBeanFactory;

/**
 * @Author: chy
 * @Date: 2022/5/7 15:37
 * @Description:
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";
}
