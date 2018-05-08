package com.chinavalley.demo.guava.collections.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//不可变集合
public class ImmutableTest {

    public static void main(String ...args){

        //JDK提供得不可变集合
        List<String> list=new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println("list:"+ list);
        List<String> unmodifiableList=Collections.unmodifiableList(list);

        System.out.println("unmodifiableList:"+ unmodifiableList);

        List<String> unmodifiableList1=Collections.unmodifiableList(Arrays.asList("a","b","c"));
        System.out.println("unmodifiableList:"+ unmodifiableList1);

        String temp=unmodifiableList.get(1);
        System.out.println("unmodifiableList [0]："+temp);

        //在原始list上追加新元素，会导致不可变集合被污染
//        list.add("baby");
//        System.out.println("list add a item after list:"+list);
//        System.out.println("list add a item after unmodifiableList:"+unmodifiableList);
//
//        //直接在不可变集合上追加元素，会报UnsupportedOperationException异常
//        unmodifiableList1.add("bb");
//        System.out.println("unmodifiableList add a item after list:"+unmodifiableList1);
//
//        unmodifiableList.add("cc");
//        System.out.println("unmodifiableList add a item after list:"+unmodifiableList);




        //Guava提供得不可变集合

        List<String> animals = new ArrayList<String>();
        animals.add("cat");
        animals.add("dog");
        animals.add("monkey");
        animals.add("pig");
        animals.add("tiger");
        animals.add("horse");
        animals.add("rabbit");

        //生成ImmutableList对象
        ImmutableList<String> imm_animals = ImmutableList.copyOf(animals);

        System.out.println(animals);
        System.out.println(imm_animals);

        animals.add("sheep");

        System.out.println(animals);
        System.out.println(imm_animals);

        //imm_animals.add("fish");

        System.out.println(animals);
        System.out.println(imm_animals);

        //建造者模式生成
        ImmutableList<String> fruit = ImmutableList.<String>builder().add("apple","banana","peach","lemon","pear").build();

        //of生成
        ImmutableList<String> imOflist=ImmutableList.of("peida","jerry","harry");

        //as 视图
        ImmutableSortedMap map = ImmutableSortedMap.of("a","b","1","c","0","4");
        System.out.println(map.asMultimap().get("a"));
    }
}
