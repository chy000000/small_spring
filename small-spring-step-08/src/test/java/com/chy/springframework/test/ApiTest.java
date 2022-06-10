package com.chy.springframework.test;

import com.chy.springframework.beans.BeansException;
import com.chy.springframework.context.support.ClassPathXmlApplicationContext;
import com.chy.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @Author: chy
 * @Date: 2022/6/10 15:32
 * @Description:
 */
public class ApiTest {

    @Test
    public void test_xml() throws BeansException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果: " + result);

        System.out.println("ApplicationContextAware: " + userService.getApplicationContext());
        System.out.println("BeanFactoryAware: " + userService.getBeanFactory());

    }
}
