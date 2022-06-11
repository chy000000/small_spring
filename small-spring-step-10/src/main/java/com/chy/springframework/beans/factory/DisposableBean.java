package com.chy.springframework.beans.factory;

import com.chy.springframework.beans.BeansException;

/**
 * @Author: com.chy
 * @Date: 2022/6/9 14:56
 * @Description:
 */
public interface DisposableBean {
    void destroy() throws Exception, BeansException;
}
