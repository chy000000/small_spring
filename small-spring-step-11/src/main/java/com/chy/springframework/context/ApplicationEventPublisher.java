package com.chy.springframework.context;

import com.chy.springframework.beans.BeansException;

/**
 * @Author: chy
 * @Date: 2022/6/11 16:09
 * @Description:
 */
public interface ApplicationEventPublisher {

    void publishEvent(ApplicationEvent event) throws BeansException;
}
