package com.chy.springframework.beans.factory;

/**
 * @Author: chy
 * @Date: 2022/5/6 20:01
 * @Description:
 */
public class PropertyValue {
    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
