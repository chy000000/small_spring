package com.chy.springframework.context;

import com.chy.springframework.beans.BeansException;

public interface ConfigurableApplicationContext extends ApplicationContext {
    void refresh() throws BeansException;

    void registerShutdownHook();

    void close() throws BeansException;
}
