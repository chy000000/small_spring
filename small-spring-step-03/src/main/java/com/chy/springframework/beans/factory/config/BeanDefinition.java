package com.chy.springframework.beans.factory.config;

/**
 * @Author: chy
 * @Date: 2022/5/4 15:49
 * @Description:
 */
public class BeanDefinition {
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
