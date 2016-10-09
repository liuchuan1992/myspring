package com.myhexin.tinyioc.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lvcanfeng on 2016/10/9 22:45  Step 3
 * 包装一个对象所有的PropertyValue。
 * 对PropertyValue的一些封装 为什么不直接采用list 因为可以封装一些操作
 */
public class PropertyValues {

    private List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();

    public  List<PropertyValue> getPropertyValues(){
        return propertyValueList;
    }

    public  void addPropertyValue(PropertyValue pv){
        //TODO:这里可以对于重复propertyName进行判断，直接用list没法做到
        this.propertyValueList.add(pv);
    }
}
