package com.chinavalley.demo.guava.base.ordering;

import lombok.Data;

@Data
public class Student{

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
