package com.chy.springframework.beans.factory.config;

/**
 * @Author: chy
 * @Date: 2022/5/6 20:00
 * @Description:
 */
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
