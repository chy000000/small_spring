package com.chy.springframework.beans.factory;

/**
 * @Author: com.chy
 * @Date: 2022/6/9 14:55
 * @Description:
 */
public interface InitializingBean {
    void afterPropertiesSet() throws Exception;
}
