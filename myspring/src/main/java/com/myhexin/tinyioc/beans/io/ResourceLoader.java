package com.myhexin.tinyioc.beans.io;

/**
 * Created by lvcanfeng on 2016/10/10 22:24
 * 获取资源的工具方法
 */
public class ResourceLoader {

    public Resource gerResource(String location){
        return new UrlResource(this.getClass().getClassLoader().getResource(location));
    }
}
