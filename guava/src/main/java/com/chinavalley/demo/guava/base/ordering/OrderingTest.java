package com.chinavalley.demo.guava.base.ordering;

import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderingTest {

    public static void main(String ...args){
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(new Integer(5));
        numbers.add(new Integer(2));
        numbers.add(new Integer(15));
        numbers.add(new Integer(51));
        numbers.add(new Integer(53));
        numbers.add(new Integer(35));
        numbers.add(new Integer(45));
        numbers.add(new Integer(32));
        numbers.add(new Integer(43));
        numbers.add(new Integer(16));

        System.out.println(numbers);


        //返回使用值的自然顺序排序序列化
        Ordering ordering = Ordering.natural();

        //排序 升序
        Collections.sort(numbers,ordering );
        System.out.println("升序 List: ");
        System.out.println(numbers);

        //排序 降序
        Collections.sort(numbers,ordering.reverse());
        System.out.println("降序Reverse: " + numbers);

        numbers = new ArrayList<Integer>();
        numbers.add(new Integer(5));
        numbers.add(new Integer(2));
        numbers.add(new Integer(15));
        numbers.add(new Integer(51));
        numbers.add(new Integer(53));
        numbers.add(new Integer(35));
        numbers.add(new Integer(45));
        numbers.add(new Integer(32));
        numbers.add(new Integer(43));
        numbers.add(new Integer(16));

        ordering= Ordering.allEqual();
        Collections.sort(numbers,ordering );
        System.out.println("不排序 List: ");
        System.out.println(numbers);


        numbers = new ArrayList<Integer>();
        numbers.add(new Integer(5));
        numbers.add(new Integer(2));
        numbers.add(new Integer(15));
        numbers.add(new Integer(51));
        numbers.add(new Integer(53));
        numbers.add(new Integer(35));
        numbers.add(new Integer(45));
        numbers.add(new Integer(32));
        numbers.add(new Integer(43));
        numbers.add(new Integer(16));

        ordering = Ordering.arbitrary();
        Collections.sort(numbers,ordering );
        System.out.println("乱序 List: ");
        System.out.println(numbers);

        //比较两个参数的顺序 
        // TODO: 2018/5/8 以后补充 ordering.compare
        int a = ordering.compare(123,123);
        System.out.println(a);


        //判断是否是有序list
        System.out.println("List is isOrdered sorted: " + ordering.isOrdered(numbers));
        //是否严格有序。请注意，Iterable不能少于两个元素。
        System.out.println("List is isStrictlyOrdered sorted: " + ordering.isStrictlyOrdered(numbers));

        //list里最小的
        System.out.println("Minimum: " + ordering.min(numbers));
        //list里最大的
        System.out.println("Maximum: " + ordering.max(numbers));

        //添加了null
        numbers.add(null);
        System.out.println("Null added to Sorted List: ");
        System.out.println(numbers);

        //默认升序 将null摆在最前
        Collections.sort(numbers,ordering.nullsFirst());
        System.out.println("Null first Sorted List: ");
        System.out.println(numbers);
        System.out.println("======================");

        // TODO: 2018/5/8 未完成待续Ordering
    }
}
