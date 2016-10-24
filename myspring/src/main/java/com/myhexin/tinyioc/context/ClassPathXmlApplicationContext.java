package com.myhexin.tinyioc.context;

import com.myhexin.tinyioc.beans.BeanDefinition;
import com.myhexin.tinyioc.beans.factory.AbstractBeanFactory;
import com.myhexin.tinyioc.beans.factory.AutowireCapableBeanFactory;
import com.myhexin.tinyioc.beans.io.ResourceLoader;
import com.myhexin.tinyioc.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author : lvcf on 2016/10/24 23:15
 * @Description :容器实现类
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) {
        this(configLocation, new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) {
        super(beanFactory);
        this.configLocation = configLocation;
        try {
            refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refresh() throws Exception {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        beanDefinitionReader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : beanDefinitionReader.getMap().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }

}
