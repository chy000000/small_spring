package com.chy.springframework.beans;

/**
 * @Author: chy
 * @Date: 2022/5/4 14:50
 * @Description:
 */
public class BeansException extends Throwable {
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
