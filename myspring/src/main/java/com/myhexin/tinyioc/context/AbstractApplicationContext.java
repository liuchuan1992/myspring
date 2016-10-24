package com.myhexin.tinyioc.context;

import com.myhexin.tinyioc.beans.factory.AbstractBeanFactory;

/**
 * @author : lvcf on 2016/10/24 23:40
 * @Description :Applicaiton 的抽象实现类
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public Object getBean(String beanName) throws Exception {
        return beanFactory.getBean(beanName);
    }
}
