package com.myhexin.tinyioc;

import com.myhexin.tinyioc.beans.PropertyValues;

/**
 * Created by lvcanfeng on 2016/10/8 22:32
 * bean的内容及元数据，保存在BeanFactory中，包装bean的实体
 * modify step2: 增加成员变量 beanName和beanCLass
 * modify step3:增加成员变量propertyValues
 */
public class BeanDefinition {

    private Object bean;

    private String beanClassName;

    private Class beanClass;

    private PropertyValues propertyValues;

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

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
