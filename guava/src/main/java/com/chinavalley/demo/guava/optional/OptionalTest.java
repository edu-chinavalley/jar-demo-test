package com.chinavalley.demo.guava.optional;


import com.google.common.base.Optional;

import java.util.ArrayList;
import java.util.Set;

/**
 *
 *
 *
 * @author: polfdark
 */
public class OptionalTest {

    public static void main(String ...args){

        /**
         * 静态方法
         */
        //如果参数为null 则会抛出NullPointException
        Optional<Integer> create1 = Optional.of(1);
        //如果参数为null 会创造出缺省对象 等同于Optional.absent()
        Optional create2 = Optional.fromNullable(3);
        //创造一个缺省的对象
        Optional<Integer> create3 = Optional.absent();


        /**
         * 实例方法
         */

        //java8将会增加Optional类，将java8的对象转变为Guava的Optional对象
        java.util.Optional javaOp = java.util.Optional.of("5");
        Optional guavaOp = Optional.fromJavaUtil(javaOp);
        java.util.Optional javaOp2 = Optional.toJavaUtil(guavaOp);

        //不会用
        //Optional.presentInstances

        //将Optional转为Set
        Set<Integer> integers = create1.asSet();

        boolean present = create2.isPresent();

        //返回实例 如果是null 报NullPointException
        Integer integer = create1.get();

        //返回实例，如果不存在则返回10
        Integer or = create1.or(10);

        //如果包含的实例存在，则返回它;否则为空。
        Integer integer1 = create3.orNull();
    }

}
