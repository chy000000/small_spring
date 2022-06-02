package com.chy.springframework.core.io;

/**
 * @Author: chy
 * @Date: 2022/5/7 10:44
 * @Description:
 */
public interface ResourceLoader {
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
