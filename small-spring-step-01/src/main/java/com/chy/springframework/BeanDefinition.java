package com.chy.springframework;

/**
 * @Author: chy
 * @Date: 2022/5/4 10:29
 * @Description:
 */
public class BeanDefinition {
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
