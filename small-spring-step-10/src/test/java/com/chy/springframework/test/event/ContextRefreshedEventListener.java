package com.chy.springframework.test.event;

import com.chy.springframework.context.ApplicationListener;
import com.chy.springframework.context.event.ContextRefreshedEvent;

/**
 * @Author: chy
 * @Date: 2022/6/11 16:42
 * @Description:
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件: " + this.getClass().getName());
    }
}
