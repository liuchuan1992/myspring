package com.myhexin.tinyioc.beans;

import com.myhexin.tinyioc.BeanDefinition;

/**
 * Created by lvcanfeng on 2016/10/8 22:33
 * modify 将BeanFactory改成接口 使用AbstractBeanFactory和AutowireCapableBeanFactory作为实现
 */
public interface BeanFactory {


    public void registerBeanDefinition(String name, BeanDefinition beanDefinition);


    public Object getBean(String beanName);
}
