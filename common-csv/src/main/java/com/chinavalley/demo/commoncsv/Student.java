package com.chinavalley.demo.commoncsv;


import lombok.Data;

/**
 * @author: polfdark
 */
@Data
public class Student {

    private String id;
    private String name;
    private String gender;
    private String major;

    public Student(String id, String name, String gender, String major) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.major = major;
    }
}
