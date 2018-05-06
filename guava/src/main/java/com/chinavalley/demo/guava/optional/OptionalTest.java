package com.chinavalley.demo.guava.optional;

import com.google.common.base.Optional;

/**
 * @author: polfdark
 */
public class OptionalTest {


    public static void main(String ...args){
        staticOptional(123);
    }

    /**
     * 用optional.of(T) 来判断参数是否为null
     *
     * null:NullPointerException
     * 非null:显示类型
     * @param t
     */
    public static void staticOptional(Object t){
        try {
            com.google.common.base.Optional.of(t);
            System.out.println("T为"+t.getClass());
        }catch(NullPointerException e){
            System.out.println("传入参数为null值");
        }
    }

    /**
     * 创建一个Optional对象，其引用是空
     * Optional.absent() 等同于 Optional.fromNullable(t)
     */
    public static void createOptional(Object t){
        Optional aa = Optional.absent();
        aa.of(t);

        Optional bb = Optional.fromNullable(t);

    }

    public static void query(Object t){

    }


}
