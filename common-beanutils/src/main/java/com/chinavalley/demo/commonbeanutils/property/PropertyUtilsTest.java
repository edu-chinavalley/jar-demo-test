package com.chinavalley.demo.commonbeanutils.property;


import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class PropertyUtilsTest {
    public static void main(String ...args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        PropertyBean pb = new PropertyBean();

        PropertyUtils.setProperty(pb,"name","hahaha");
        PropertyUtils.setProperty(pb,"year",123);
        System.out.println(pb);
        int year = (int) PropertyUtils.getProperty(pb,"year");
        System.out.println(year);

        Map map = PropertyUtils.describe(pb);
        System.out.println(map);

        //执行对象方法
        System.out.println( MethodUtils.invokeMethod(pb, "hello", null) );
        //携带参数
        System.out.println(MethodUtils.invokeMethod(pb, "hello", "poldark"));

        Object[] params = new Object[]{"poldark",new Integer(29)};
        System.out.println(MethodUtils.invokeMethod(pb, "hello", params));
    }
}
