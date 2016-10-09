package com.myhexin.tinyioc.beans;

/**
 * Created by lvcanfeng on 2016/10/9 22:35
 * 用于bean的属性注入
 */
public class PropertyValue {

    private String name ;

    private Object object;

    public PropertyValue(String name, Object object) {
        this.name = name;
        this.object = object;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
