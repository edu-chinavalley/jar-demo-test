package com.chinavalley.demo.guava.stringutils;

import com.google.common.base.Joiner;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: polfdark
 */
public class JoinerTest {

    public static void main(String ...args) throws IOException {
        System.out.println(Joiner.on(",").join(new String[]{"1","2","44","6556"}));

        System.out.println(Joiner.on(",").join(new String[]{"1","","44","6556"}));

        Joiner joiner1 = Joiner.on(";").skipNulls();
        Joiner joiner2 = Joiner.on(";").useForNull("Hello");
        System.out.println(joiner1.join("A", null, "B", "C"));
        System.out.println(joiner2.join("A", null, "B", "C","D","EW"));


        StringBuilder builder = new StringBuilder();
        Joiner joiner = Joiner.on(",").skipNulls();
        joiner.appendTo(builder, "Hello", "Guava");
        System.out.println(builder); //Hello,Guava

        //append到输出流
        FileWriter writer = new FileWriter("joinerAppend.txt");
        joiner.appendTo(writer, "Hello", "Guava");
        writer.close();

        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        Joiner.MapJoiner mapJoiner = Joiner.on(",").withKeyValueSeparator("=");
        System.out.println(mapJoiner.join(map)); //key3=value3,key2=value2,key1=value1
    }
}
