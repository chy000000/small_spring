package com.chy.springframework.aop;

/**
 * @Author: chy
 * @Date: 2022/7/13 16:23
 * @Description:
 */
public class TargetSource {
    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass() {
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return target;
    }
}
