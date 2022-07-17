package com.chy.springframework.context;

import java.util.EventObject;

/**
 * @Author: chy
 * @Date: 2022/6/11 14:59
 * @Description:
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
