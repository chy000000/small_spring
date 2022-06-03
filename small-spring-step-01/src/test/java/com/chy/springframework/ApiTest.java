package com.chy.springframework;

import com.chy.springframework.bean.UserService;
import org.junit.Test;

/**
 * @Author: chy
 * @Date: 2022/5/4 10:29
 * @Description:
 */
public class ApiTest {

    // 简单spring容器
    @Test
    public void test_BeanFactory() {
        // 初始化BeanFactory
        BeanFactory beanFactory = new BeanFactory();
        // 注册bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        //获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserByInfo();

    }
}
