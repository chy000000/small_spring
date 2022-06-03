package com.chy.springframework.test;

import com.chy.springframework.beans.BeansException;
import com.chy.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.chy.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.chy.springframework.context.support.ClassPathXmlApplicationContext;
import com.chy.springframework.test.bean.UserDao;
import com.chy.springframework.test.bean.UserService;
import com.chy.springframework.test.common.MyBeanFactoryPostProcessor;
import com.chy.springframework.test.common.MyBeanPostProcessor;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor() throws BeansException {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);


        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);

    }

    @Test
    public void test_xml() throws BeansException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果："+result);
    }
}
