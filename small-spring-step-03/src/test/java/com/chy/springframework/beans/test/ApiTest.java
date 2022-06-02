package com.chy.springframework.beans.test;

import com.chy.springframework.beans.BeansException;
import com.chy.springframework.beans.factory.config.BeanDefinition;
import com.chy.springframework.beans.factory.support.DefaultListableBeanFactory;
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
    @Test
    public void test_BeanFactory() throws BeansException {
        // 初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

    @Test
    public void test_cglib() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        UserService obj = (UserService) enhancer.create(new Class[]{String.class}, new Object[]{"chy"});
        System.out.println(obj);
        obj.queryUserInfo();
    }

    @Test
    public void test_constructor() throws Exception {
        Class<UserService> userServiceClass = UserService.class;
        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class);
        UserService userService = declaredConstructor.newInstance("chy");
        System.out.println(userService);
        userService.queryUserInfo();
    }

    @Test
    public void test_parameterTypes() throws Exception {
        Class<UserService> beanClass  = UserService.class;
        Constructor<?>[] declaredConstructors = beanClass .getDeclaredConstructors();
        Constructor<?> constructor = null;
        for (Constructor<?> ctor : declaredConstructors) {
            if (ctor.getParameterTypes().length == 1) {
                constructor = ctor;
                break;
            }
        }
        Constructor<UserService> declaredConstructor = beanClass.getDeclaredConstructor(constructor.getParameterTypes());
        UserService userService = declaredConstructor.newInstance("chy");
        System.out.println(userService);
        userService.queryUserInfo();
    }
}
