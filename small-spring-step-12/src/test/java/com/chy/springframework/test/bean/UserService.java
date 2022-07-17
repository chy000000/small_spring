package com.chy.springframework.test.bean;

import java.util.Random;

/**
 * @Author: chy
 * @Date: 2022/7/13 16:05
 * @Description:
 */
public class UserService implements IUserService {
    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行queryUserInfo");
        return "chy, 100001, 上海";
    }

    @Override
    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户： " + userName + " success!";
    }
}
