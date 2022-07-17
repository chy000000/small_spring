package com.chy.springframework.aop;

/**
 * @Author: chy
 * @Date: 2022/7/13 15:29
 * @Description:
 */
public interface PointCut {
    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
