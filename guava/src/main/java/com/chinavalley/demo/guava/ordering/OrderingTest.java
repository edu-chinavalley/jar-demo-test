package com.chinavalley.demo.guava.ordering;

import java.util.ArrayList;
import java.util.List;

public class OrderingTest {

    public static void main(String ...args){
        List<Student> list = new ArrayList<Student>(){
            {
                add(new Student("a",15));
                add(new Student("b",16));
                add(new Student("c",18));
            }
        };
    }
}
