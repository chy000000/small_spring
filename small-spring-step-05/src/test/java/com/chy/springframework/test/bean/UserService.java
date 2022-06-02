package com.chy.springframework.test.bean;

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


    public String queryUserInfo() {
        return userDao.queryUserName(uId);
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
