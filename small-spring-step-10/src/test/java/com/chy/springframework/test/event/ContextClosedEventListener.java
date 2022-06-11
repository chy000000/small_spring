package com.chy.springframework.test.event;

import com.chy.springframework.context.ApplicationListener;
import com.chy.springframework.context.event.ContextClosedEvent;

/**
 * @Author: chy
 * @Date: 2022/6/11 16:42
 * @Description:
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件: " + this.getClass().getName());
    }
}
