package com.chy.springframework.test.bean;

/**
 * @Author: chy
 * @Date: 2022/5/4 16:40
 * @Description:
 */
public class UserService {
    private String uId;
    private String company;
    private UserDao userDao;

    public UserService() {
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + company;
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
