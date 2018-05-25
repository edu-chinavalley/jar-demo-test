package com.chinavalley.demo.guava.stringutils;

import com.google.common.base.Splitter;

import java.lang.Iterable;


/**
 * @author: polfdark
 */
public class SplitterTest {

    public static void main(String ...args){
        Iterable<String> ss = Splitter
                /**
                 * 按照给定的单字符给予分离
                 */
                .on('|')
                /**
                 * 去掉空格
                 */
                .trimResults()
                /**
                 * 去掉空字符串元素
                 */
                .omitEmptyStrings()
                /**
                 * 按照长度进行分割
                 */
                //.fixedLength(3)
                /**
                 *
                 */
                .limit(3)
                .split("the ,quick, , brown         , fox,              jumps, over, the, lazy, little dog.");
        System.out.println(ss);
    }
}
