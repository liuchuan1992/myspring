package com.myhexin.tinyioc.beans.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by lvcanfeng on 2016/10/10 22:22
 * 资源定位的实现类
 */
public class UrlResource implements Resource {

    private final URL url;

    public UrlResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream()throws IOException{
        URLConnection urlConnection = url.openConnection();
        return urlConnection.getInputStream();

    }
}
