package com.chy.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: chy
 * @Date: 2022/6/10 15:32
 * @Description:
 */
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    public void initDataMethod() {
        System.out.println("执行：init-method");
        hashMap.put("10001", "chy");
        hashMap.put("10002", "dqh");
        hashMap.put("10003", "zh");
    }

    public void destroyDataMethod() {
        System.out.println("执行：destroy-method");
        hashMap.clear();
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
