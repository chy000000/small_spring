package com.chy.springframework.beans.factory;

/**
 * @Author: chy
 * @Date: 2022/6/10 15:03
 * @Description:
 */
public interface BeanNameAware extends Aware {
    void setBeanName(String name);
}
