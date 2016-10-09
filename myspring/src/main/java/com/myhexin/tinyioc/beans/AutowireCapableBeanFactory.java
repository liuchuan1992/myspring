package com.myhexin.tinyioc.beans;

import com.myhexin.tinyioc.BeanDefinition;

/**
 * Created by lvcanfeng on 2016/10/9 22:17
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        Object object = null;
        try {
            object = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return object;
    }
}
