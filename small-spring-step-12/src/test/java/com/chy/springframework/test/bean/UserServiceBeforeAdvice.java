package com.chy.springframework.test.bean;

import com.chy.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author: chy
 * @Date: 2022/7/15 17:02
 * @Description:
 */
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) {
        System.out.println("拦截方法：" + method.getName());
    }
}
