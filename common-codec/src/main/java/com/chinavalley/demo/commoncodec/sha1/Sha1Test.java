package com.chinavalley.demo.commoncodec.sha1;

import org.apache.commons.codec.digest.DigestUtils;

public class Sha1Test {

    public static void main(String ...args){
        String data ="poldark";
        System.out.println(DigestUtils.sha1Hex(data));
    }
}
