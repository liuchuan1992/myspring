package com.myhexin.tinyioc;


import com.myhexin.tinyioc.beans.PropertyValue;
import com.myhexin.tinyioc.beans.PropertyValues;
import com.myhexin.tinyioc.beans.factory.AutowireCapableBeanFactory;
import com.myhexin.tinyioc.beans.factory.BeanFactory;
import org.junit.Test;

/**
 * Created by lvcanfeng on 2016/10/8 23:00
 */
public class BeanFactoryTest {

    @Test
    public void Test() throws Exception{
        // 1.初始化beanfactory
        BeanFactory beanFactory = new AutowireCapableBeanFactory();

        // 2.bean定义
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClass("com.myhexin.tinyioc.HelloWorldService");

        // 3.设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("txt", "Hello World11!"));
        beanDefinition.setPropertyValues(propertyValues);

        // 4.生成bean
        beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

        // 5.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

}
