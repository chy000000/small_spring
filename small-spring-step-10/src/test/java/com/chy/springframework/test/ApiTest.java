package com.chy.springframework.test;

import com.chy.springframework.beans.BeansException;
import com.chy.springframework.context.support.ClassPathXmlApplicationContext;
import com.chy.springframework.test.event.CustomEvent;
import org.junit.Test;

/**
 * @Author: chy
 * @Date: 2022/6/11 16:40
 * @Description:
 */
public class ApiTest {

    @Test
    public void test_event() throws BeansException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutdownHook();
    }
}
