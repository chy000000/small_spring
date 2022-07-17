package com.chy.springframework.aop;

import java.lang.reflect.Method;

/**
 * @Author: chy
 * @Date: 2022/7/13 15:37
 * @Description:
 */
public interface MethodMatcher {
    boolean matches(Method method, Class<?> targetClass);
}
