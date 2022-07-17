package com.chy.springframework.aop;

/**
 * @Author: chy
 * @Date: 2022/7/15 15:57
 * @Description:
 */
public interface PointcutAdvisor extends Advisor {
    PointCut getPointcut();
}
