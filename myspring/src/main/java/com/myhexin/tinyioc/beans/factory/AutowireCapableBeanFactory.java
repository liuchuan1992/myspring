package com.myhexin.tinyioc.beans.factory;

import com.myhexin.tinyioc.BeanDefinition;
import com.myhexin.tinyioc.beans.PropertyValue;

import java.lang.reflect.Field;

/**
 * Created by lvcanfeng on 2016/10/9 22:17
 * 主要方法：doCreateBean(BeanDefinition beanDefinition) 将传入的beanDefinition组装成一个对象，并为他的field赋值
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception{
        Object bean = createBeanInstance(beanDefinition);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception{
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        for (PropertyValue pv : beanDefinition.getPropertyValues().getPropertyValues()) {
            Field declaredField = bean.getClass().getDeclaredField(pv.getName());
            declaredField.setAccessible(true);
            declaredField.set(bean, pv.getObject());
        }
    }
}
