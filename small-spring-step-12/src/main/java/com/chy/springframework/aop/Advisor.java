package com.chy.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * @Author: chy
 * @Date: 2022/7/15 15:56
 * @Description:
 */
public interface Advisor {

    Advice getAdvice();
}
