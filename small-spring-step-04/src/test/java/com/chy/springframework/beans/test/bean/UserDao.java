package com.chy.springframework.beans.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: chy
 * @Date: 2022/5/6 20:19
 * @Description:
 */
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();
    static {
        hashMap.put("10001", "chy");
        hashMap.put("10002", "cz");
        hashMap.put("10003", "dqh");
    }

    public String queryUserName(String uId) {
        return  hashMap.get(uId);
    }
}
