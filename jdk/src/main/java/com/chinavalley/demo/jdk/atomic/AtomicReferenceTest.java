package com.chinavalley.demo.jdk.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: polfdark
 */
public class AtomicReferenceTest {

    public static void main(String ...args){
        AtomicReference<String> aa = new AtomicReference<>("String");
        /**
         * compareAndSet函数
         * 如果expect对应，则更新update 并返回true
         * 如果expect不对应，则不更新，并返回false
         */
        System.out.println(aa.compareAndSet("String","int"));
        System.out.println(aa.get());


    }
}
