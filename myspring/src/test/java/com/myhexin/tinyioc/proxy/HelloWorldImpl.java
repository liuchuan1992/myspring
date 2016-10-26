package com.myhexin.tinyioc.proxy;

/**
 * @author : lvcf on 2016/10/25 10:03
 * @Description :
 */
public class HelloWorldImpl implements HelloWorld {


    @Override
    public void sayHelloWorld() {
        System.out.println("hello world !");
    }

    @Override
    public void test() {
        System.out.println("test !");
    }
}
