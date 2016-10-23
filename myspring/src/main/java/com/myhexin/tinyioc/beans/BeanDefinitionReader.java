package com.myhexin.tinyioc.beans;

/**
 * @author : lvcf on 2016/10/23 14:17
 * @Description :beanDefinition 读取器接口
 */
public interface BeanDefinitionReader {

    /**
     * 定义加载beanDefinition的抽象方法
     * @param location
     */
    void loadBeanDefinitions(String location) throws Exception;
}
