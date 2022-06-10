package com.chy.springframework.context;

import com.chy.springframework.beans.BeansException;
import com.chy.springframework.beans.factory.Aware;

/**
 * @Author: chy
 * @Date: 2022/6/10 15:04
 * @Description:
 */
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
