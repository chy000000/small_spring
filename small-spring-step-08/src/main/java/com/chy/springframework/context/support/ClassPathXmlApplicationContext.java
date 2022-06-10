package com.chy.springframework.context.support;

import com.chy.springframework.beans.BeansException;

public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLoactions;

    public ClassPathXmlApplicationContext() {
    }

    public ClassPathXmlApplicationContext(String[] configLoactions) throws BeansException {
        this.configLoactions = configLoactions;
        refresh();
    }

    public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
        this(new String[]{configLocations});
    }

    @Override
    protected String[] getConfigLocations() {
        return configLoactions;
    }
}
