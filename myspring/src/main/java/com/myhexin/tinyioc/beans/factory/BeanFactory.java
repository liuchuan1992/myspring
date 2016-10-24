package com.myhexin.tinyioc.beans.factory;

/**
 * Created by lvcanfeng on 2016/10/8 22:33
 * modify 将BeanFactory改成接口 使用AbstractBeanFactory和AutowireCapableBeanFactory作为实现
 */
public interface BeanFactory {



    public Object getBean(String beanName) throws Exception;
}
