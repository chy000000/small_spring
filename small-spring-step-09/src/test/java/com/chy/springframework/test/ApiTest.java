package com.chy.springframework.test;

import com.chy.springframework.beans.BeansException;
import com.chy.springframework.context.support.ClassPathXmlApplicationContext;
import com.chy.springframework.test.bean.IUserDao;
import com.chy.springframework.test.bean.ProxyBeanFactory;
import com.chy.springframework.test.bean.UserService;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * @Author: chy
 * @Date: 2022/6/10 20:58
 * @Description:
 */
public class ApiTest {

    @Test
    public void test_prototype() throws BeansException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService.class);

        System.out.println(userService01);
        System.out.println(userService02);

        System.out.println(userService01 + " 十六进制哈希: " + Integer.toHexString(userService01.hashCode()));
        System.out.println(ClassLayout.parseInstance(userService01).toPrintable());
    }

    @Test
    public void test_factory_bean() throws BeansException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println("测试结果: " + userService.queryUserInfo());

        IUserDao userDao = applicationContext.getBean("proxyUserDao", IUserDao.class);
        System.out.println(userDao.queryUserName("10001"));
    }
}
