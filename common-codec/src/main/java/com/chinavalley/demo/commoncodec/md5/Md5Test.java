package com.chinavalley.demo.commoncodec.md5;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Test {

    public static void main(String ...args){
        String result = DigestUtils.md5Hex("poldark");
        System.out.println(result);
    }
}
