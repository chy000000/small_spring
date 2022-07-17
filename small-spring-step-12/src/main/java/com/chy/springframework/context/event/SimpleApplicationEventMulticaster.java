package com.chy.springframework.context.event;

import com.chy.springframework.beans.BeansException;
import com.chy.springframework.beans.factory.BeanFactory;
import com.chy.springframework.context.ApplicationEvent;
import com.chy.springframework.context.ApplicationListener;

/**
 * @Author: chy
 * @Date: 2022/6/11 16:22
 * @Description:
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) throws BeansException {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(ApplicationEvent event) throws BeansException {
        for (final ApplicationListener listener: getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
