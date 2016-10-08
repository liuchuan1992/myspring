package com.myhexin.tinyioc;


import org.junit.Test;

/**
 * Created by lvcanfeng on 2016/10/8 23:00
 */
public class BeanFactoryTest {

    @Test
    public void Test(){
        //1.初始化beanFactory
        BeanFactory beanFactory = new BeanFactory();
        //2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition(new HelloWorldService());
        beanFactory.registerBeanDefinition("helloWorldService",beanDefinition);
        //3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

}
