package com.chy.springframework.beans.factory.support;

import com.chy.springframework.beans.BeansException;
import com.chy.springframework.core.io.Resource;
import com.chy.springframework.core.io.ResourceLoader;

/**
 * @Author: chy
 * @Date: 2022/5/7 12:09
 * @Description:
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;
}
