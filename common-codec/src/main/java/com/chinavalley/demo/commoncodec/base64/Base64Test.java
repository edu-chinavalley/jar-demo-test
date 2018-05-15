package com.chinavalley.demo.commoncodec.base64;

import org.apache.commons.codec.binary.Base64;

public class Base64Test {

    public static void main(String ...args){
        byte[] data = "poldark".getBytes();
        Base64 base64 = new Base64();
        String encode = base64.encodeAsString(data);
        System.out.println(encode);
        System.out.println(new String(base64.decode(encode)));
    }
}
