package com.myhexin.tinyioc;

/**
 * Created by lvcanfeng on 2016/10/8 22:32
 * 封装了bean 还可以包括一些bean的其他信息
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean){
        this.bean = bean;
    }

    public Object getBean(){
        return bean;
    }
}
