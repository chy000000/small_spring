package com.chy.springframework.test.bean;

/**
 * @Author: chy
 * @Date: 2022/5/4 16:40
 * @Description:
 */
public class UserService {
    private String uId;
    private String company;
    private String location;

    private UserDao userDao;

    public UserService() {
    }


    public String queryUserInfo() {
//        System.out.println(company);
//        System.out.println(location);
        if (userDao==null) {
            System.out.println(1);
        }
        return userDao.queryUserName(uId) + "," + company + "," + location;
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
}
