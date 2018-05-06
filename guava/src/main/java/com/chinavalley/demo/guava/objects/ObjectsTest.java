package com.chinavalley.demo.guava.objects;


import com.google.common.base.Objects;

public class ObjectsTest {

    public static void main(String ...args){
        Demo demo1 = new Demo();
        Demo demo2 = new Demo();

        boolean equal = Objects.equal(demo1,demo2);
        boolean equals = java.util.Objects.equals(demo1, demo2);
        Objects.equal("a", "a"); // returns true
        Objects.equal(null, "a"); // returns false
        Objects.equal("a", null); // returns false
        Objects.equal(null, null); // returns true

        int hashcode = Objects.hashCode(demo1,demo2);
        int hashcodes = Objects.hashCode(demo1,demo2);

    }
}
