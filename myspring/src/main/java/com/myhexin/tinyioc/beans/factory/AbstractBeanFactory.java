package com.myhexin.tinyioc.beans.factory;

import com.myhexin.tinyioc.beans.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lvcanfeng on 2016/10/9 21:55
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private static Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

    /**
     * step5做了优化
     * step4之前是在getBean的时候直接从map中去取，registerBeanDefinition时去创建
     * step5 变成了getBean的时候去注册,registerBeanDefinition时去放
     * 这样在注入bean的时候，如果该属性对应的bean找不到，那么就先创建！因为总是先创建后注入，所以不会存在两个循环依赖的bean创建死锁的问题
     * @param beanName
     * @return
     * @throws Exception
     */
    @Override
    public Object getBean(String beanName) throws Exception{
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if(beanDefinition == null){
            throw new IllegalArgumentException("No bean named "+beanName+" is defined");
        }
        Object bean = beanDefinition.getBean();
        if(bean == null){
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception{
        beanDefinitionMap.put(name,beanDefinition);
    }

    /**
     * 初始化bean
     * @param beanDefinition
     * @return
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
