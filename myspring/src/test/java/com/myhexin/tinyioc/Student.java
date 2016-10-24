package com.myhexin.tinyioc;

/**
 * @author : lvcf on 2016/10/24 19:42
 * @Description : 测试bean inject into bean
 */
public class Student {

    private HelloWorldService helloWorldService;
    private String name;
    private String age;

    public void sayHello(){
        System.out.println("my name is "+ name +",i am "+age +" years old,nice to meet you!");
    }
}
