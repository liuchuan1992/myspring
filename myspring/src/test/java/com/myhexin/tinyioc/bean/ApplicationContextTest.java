package com.myhexin.tinyioc.bean;

import com.myhexin.tinyioc.HelloWorldService;
import com.myhexin.tinyioc.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author : lvcf on 2016/10/24 23:53
 * @Description : 测试classPathApplicationContext
 */
public class ApplicationContextTest {

    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc.xml");
        HelloWorldService helloWorldService = (HelloWorldService) context.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }

}
