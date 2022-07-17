package com.chy.springframework.context.event;

import com.chy.springframework.context.ApplicationContext;
import com.chy.springframework.context.ApplicationEvent;

/**
 * @Author: chy
 * @Date: 2022/6/11 15:00
 * @Description:
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
