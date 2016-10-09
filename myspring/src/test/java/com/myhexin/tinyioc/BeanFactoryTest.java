package com.myhexin.tinyioc;


import com.myhexin.tinyioc.beans.AutowireCapableBeanFactory;
import org.junit.Test;

/**
 * Created by lvcanfeng on 2016/10/8 23:00
 */
public class BeanFactoryTest {

    @Test
    public void Test(){
        //1.初始化autowireCapableBeanFactory
        AutowireCapableBeanFactory autowireCapableBeanFactory = new AutowireCapableBeanFactory();
        //2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition().setBeanClass("com.myhexin.tinyioc.HelloWorldService");
        autowireCapableBeanFactory.registerBeanDefinition("helloWorldService",beanDefinition);
        //3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) autowireCapableBeanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

}
