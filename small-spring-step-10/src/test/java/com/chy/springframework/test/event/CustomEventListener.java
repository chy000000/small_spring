package com.chy.springframework.test.event;

import com.chy.springframework.context.ApplicationListener;
import com.chy.springframework.context.event.ContextClosedEvent;

import java.util.Date;

/**
 * @Author: chy
 * @Date: 2022/6/11 16:43
 * @Description:
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到: " + event.getSource() + "消息；时间: " + new Date());
        System.out.println("消息: " + event.getId() + ": " + event.getMessage());
    }
}
