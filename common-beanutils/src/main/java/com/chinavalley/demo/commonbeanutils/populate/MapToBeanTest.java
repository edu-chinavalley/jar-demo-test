package com.chinavalley.demo.commonbeanutils.populate;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class MapToBeanTest {

    public static void main(String ...args){
        Map<String,Object> param = new HashMap<>();
        param.put("name","poldark");
        param.put("age",29);
        param.put("job","it");
        RequestBean rb = new RequestBean();
        try {
            BeanUtils.populate(rb,param);

            Map map = PropertyUtils.describe(rb);
            System.out.println(map);
        } catch (IllegalAccessException e) {
            //参数异常
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            //反射异常
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(rb);
    }
}
