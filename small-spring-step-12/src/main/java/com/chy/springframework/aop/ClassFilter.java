package com.chy.springframework.aop;


/**
 * @Author: chy
 * @Date: 2022/7/13 15:30
 * @Description:
 */
public interface ClassFilter {
    boolean matches(Class<?> clazz);
}
