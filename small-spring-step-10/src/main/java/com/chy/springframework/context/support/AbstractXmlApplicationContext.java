package com.chy.springframework.context.support;

import com.chy.springframework.beans.BeansException;
import com.chy.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.chy.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLoactions = getConfigLocations();
        if (null!=configLoactions) {
            beanDefinitionReader.loadBeanDefinitions(configLoactions);
        }
    }

    protected abstract String[] getConfigLocations();
}
