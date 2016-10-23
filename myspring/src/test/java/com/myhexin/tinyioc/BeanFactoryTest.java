package com.myhexin.tinyioc;


import com.myhexin.tinyioc.beans.factory.AutowireCapableBeanFactory;
import com.myhexin.tinyioc.beans.factory.BeanFactory;
import com.myhexin.tinyioc.beans.io.ResourceLoader;
import com.myhexin.tinyioc.beans.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * Created by lvcanfeng on 2016/10/8 23:00
 */
public class BeanFactoryTest {

    @Test
    public void Test() throws Exception{

        //1.加载xml资源
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("ioc.xml");

        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        for(Map.Entry<String,BeanDefinition> entry: xmlBeanDefinitionReader.getMap().entrySet()){
            beanFactory.registerBeanDefinition(entry.getKey(),entry.getValue());
        }

        // 3.获取bean
        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

}
