package com.chy.springframework.beans.factory;

/**
 * @Author: chy
 * @Date: 2022/6/10 14:54
 * @Description:
 */
public interface BeanClassLoaderAware extends Aware {
    void setBeanClassLoader(ClassLoader classLoader);
}
