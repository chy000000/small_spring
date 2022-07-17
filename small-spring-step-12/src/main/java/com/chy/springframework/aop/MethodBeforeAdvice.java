package com.chy.springframework.aop;

import java.lang.reflect.Method;

/**
 * @Author: chy
 * @Date: 2022/7/15 15:55
 * @Description:
 */
public interface MethodBeforeAdvice extends BeforeAdvice {

    void before(Method method, Object[] args, Object target);
}
