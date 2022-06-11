package com.chy.springframework.context.event;

import com.chy.springframework.beans.BeansException;
import com.chy.springframework.context.ApplicationEvent;
import com.chy.springframework.context.ApplicationListener;

/**
 * @Author: chy
 * @Date: 2022/6/11 15:49
 * @Description:
 */
public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event) throws BeansException;
}
