package com.myhexin.tinyioc.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lvcanfeng on 2016/10/10 22:21
 * Resource是spring内部定位资源的接口。
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
