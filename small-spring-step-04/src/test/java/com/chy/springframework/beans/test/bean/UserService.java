package com.chy.springframework.beans.test.bean;

/**
 * @Author: chy
 * @Date: 2022/5/4 16:40
 * @Description:
 */
public class UserService {
    private String uId;

    private UserDao userDao;

    public UserService() {
    }


    public void queryUserInfo() {
        System.out.println("查询用户信息：" + userDao.queryUserName(uId));
    }
}
