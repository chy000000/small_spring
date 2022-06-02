package com.chy.springframework.test;

import com.chy.springframework.beans.BeansException;
import com.chy.springframework.beans.factory.config.BeanDefinition;
import com.chy.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.chy.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @Author: chy
 * @Date: 2022/5/4 15:20
 * @Description:
 */
public class ApiTest {
    @Test
    public void test_BeanFactory() throws BeansException {
        // 初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 第一次获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        // 第二次获取bean
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();

    }
}
