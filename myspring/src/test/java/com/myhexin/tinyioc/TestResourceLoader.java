package com.myhexin.tinyioc;

import com.myhexin.tinyioc.beans.io.Resource;
import com.myhexin.tinyioc.beans.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

/**
 * Created by lvcanfeng on 2016/10/10 22:35
 */
public class TestResourceLoader {

    @Test
    public void testResourceLoader() throws Exception{
        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.gerResource("ioc.xml");
        InputStream inputStream = resource.getInputStream();
        Assert.assertNotNull(inputStream);
    }
}
