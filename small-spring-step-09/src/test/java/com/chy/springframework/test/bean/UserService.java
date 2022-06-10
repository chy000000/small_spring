package com.chy.springframework.test.bean;

/**
 * @Author: chy
 * @Date: 2022/6/10 20:58
 * @Description:
 */
public class UserService {

    private String uId;
    private String company;
    private String location;
    private IUserDao userDao;

    public String getuId() {
        return uId;
    }

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + "," + company + "," + location;
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

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}