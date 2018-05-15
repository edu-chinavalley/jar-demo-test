package com.chinavalley.demo.commonbeanutils.property;

import lombok.Data;

@Data
public class PropertyBean {

    private String id;

    private String name;

    private int year;


    public String hello(){
        return "hello world";
    }
    public String hello(String name){
        return name + " hello world";
    }

    public String hello(String name,Integer age){
        return name + " hello world im "+ age;
    }
}
