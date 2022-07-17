package com.chy.springframework.context;

import java.util.EventListener;

/**
 * @Author: chy
 * @Date: 2022/6/11 15:50
 * @Description:
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    void onApplicationEvent(E event);
}
