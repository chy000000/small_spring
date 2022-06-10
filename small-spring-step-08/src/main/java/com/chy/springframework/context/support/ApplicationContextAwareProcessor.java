package com.chy.springframework.context.support;

import com.chy.springframework.beans.BeansException;
import com.chy.springframework.beans.factory.config.BeanPostProcessor;
import com.chy.springframework.context.ApplicationContext;
import com.chy.springframework.context.ApplicationContextAware;

/**
 * @Author: chy
 * @Date: 2022/6/10 15:17
 * @Description:
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {
    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
