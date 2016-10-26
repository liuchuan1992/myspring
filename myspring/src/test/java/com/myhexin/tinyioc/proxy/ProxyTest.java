package com.myhexin.tinyioc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author : lvcf on 2016/10/25 10:08
 * @Description : 动态代理测试
 */
public class ProxyTest {

    public static void main(String[] args) {
        HelloWorld helloWorld=new HelloWorldImpl();
        InvocationHandler handler=new HelloWorldHandler(helloWorld);

        //创建动态代理对象
        HelloWorld proxy=(HelloWorld) Proxy.newProxyInstance(
                helloWorld.getClass().getClassLoader(),
                helloWorld.getClass().getInterfaces(),
                handler);
        proxy.test();
        proxy.getClass();
    }
}
