package com.myhexin.tinyioc.beans.factory;

import com.myhexin.tinyioc.BeanDefinition;
import com.myhexin.tinyioc.beans.BeanReference;
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
        beanDefinition.setBean(bean);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception{
        return beanDefinition.getBeanClass().newInstance();
    }

    /**
     * 判断propertyValue.getValue()的类型，如果是BeanReference 则需要注入实体类
     * @param bean
     * @param beanDefinition
     * @throws Exception
     */
    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        for (PropertyValue pv : beanDefinition.getPropertyValues().getPropertyValues()) {
            Field declaredField = bean.getClass().getDeclaredField(pv.getName());
            declaredField.setAccessible(true);
            Object obj = pv.getObject();
            if(obj instanceof BeanReference){
                BeanReference beanReference = (BeanReference) obj;
                obj = getBean(beanReference.getName());
            }
            declaredField.set(bean, obj);
        }
    }
}
