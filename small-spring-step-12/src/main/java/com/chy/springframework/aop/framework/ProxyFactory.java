package com.chy.springframework.aop.framework;

import com.chy.springframework.aop.AdvisedSupport;

/**
 * @Author: chy
 * @Date: 2022/7/15 16:14
 * @Description:
 */
public class ProxyFactory {
    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy() {
        if (advisedSupport.isProxyTargetClass()) {
            return new Cglib2AopProxy((advisedSupport));
        }
        return new JdkDynamicAopProxy(advisedSupport);
    }
}
