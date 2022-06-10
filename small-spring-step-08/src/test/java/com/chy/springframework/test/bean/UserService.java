package com.chy.springframework.test.bean;

import com.chy.springframework.beans.BeansException;
import com.chy.springframework.beans.factory.BeanClassLoaderAware;
import com.chy.springframework.beans.factory.BeanFactory;
import com.chy.springframework.beans.factory.BeanFactoryAware;
import com.chy.springframework.beans.factory.BeanNameAware;
import com.chy.springframework.context.ApplicationContext;
import com.chy.springframework.context.ApplicationContextAware;

/**
 * @Author: chy
 * @Date: 2022/6/10 15:32
 * @Description:
 */
public class UserService implements BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    private String uId;
    private String company;
    private String location;
    private UserDao userDao;

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + "," + company + "," + location;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader: " + classLoader);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name is: " + name);
    }
}
