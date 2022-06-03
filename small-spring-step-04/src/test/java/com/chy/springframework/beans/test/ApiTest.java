package com.chy.springframework.beans.test;

import com.chy.springframework.beans.BeansException;
import com.chy.springframework.beans.factory.PropertyValue;
import com.chy.springframework.beans.factory.PropertyValues;
import com.chy.springframework.beans.factory.config.BeanDefinition;
import com.chy.springframework.beans.factory.config.BeanReference;
import com.chy.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.chy.springframework.beans.test.bean.UserDao;
import com.chy.springframework.beans.test.bean.UserService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @Author: chy
 * @Date: 2022/5/4 16:40
 * @Description:
 */
public class ApiTest {

    // bean属性注入
    @Test
    public void test_BeanFactory() throws BeansException {
        // 初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // UserDao注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // UserService设置属性uId，userDao
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        //UserService注入Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        //获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

    }
}
