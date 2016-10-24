package com.myhexin.tinyioc.beans;

import com.myhexin.tinyioc.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : lvcf on 2016/10/23 14:19
 * @Description : 进一步规范了BeanDefinitonReader的实现
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    private Map<String, BeanDefinition> map; //用于存储加载到的BeanDefinition
    private ResourceLoader resourceLoader;//具体的资源加载器

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.map = new HashMap<String, BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getMap() {
        return map;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
