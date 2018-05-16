package com.chinavalley.demo.commoncodec.base32;

import org.apache.commons.codec.binary.Base32;

public class Base32Test {

    public static void main(String ...args){
        Base32 base = new Base32();
        System.out.println(base.encodeAsString("test".getBytes()));
    }
}
