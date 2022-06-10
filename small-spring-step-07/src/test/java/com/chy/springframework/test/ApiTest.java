package com.chy.springframework.test;

import com.chy.springframework.test.bean.UserService;
import com.chy.springframework.beans.BeansException;
import com.chy.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @Author: com.chy
 * @Date: 2022/6/9 16:51
 * @Description:
 */
public class ApiTest {

    @Test
    public void test_xml() throws BeansException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_hook() {
        Runtime.getRuntime().addShutdownHook(new Thread(()-> System.out.println("close!")));
    }
}
