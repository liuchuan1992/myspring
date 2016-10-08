package com.myhexin.tinyioc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lvcanfeng on 2016/10/8 22:33
 */
public class BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();


    public void registerBeanDefinition(String beanName,BeanDefinition bean){
        beanDefinitionMap.put(beanName,bean);
    }

    public Object getBean(String beanName){
        return beanDefinitionMap.get(beanName).getBean();
    }
}
