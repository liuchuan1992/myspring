package com.myhexin.tinyioc;

/**
 * Created by lvcanfeng on 2016/10/8 22:32
 * 封装了bean 还可以包括一些bean的其他信息
 * modify 增加成员变量 beanName和beanCLass
 */
public class BeanDefinition {

    private Object bean;

    private String beanClassName;

    private Class beanClass;

    public Class getBeanClass() {
        return beanClass;
    }

    public BeanDefinition setBeanClass(String beanClassName) {
        try {
            Class beanClass = Class.forName(beanClassName);
            this.beanClassName = beanClassName;
            this.beanClass = beanClass;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return this;
    }


    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
