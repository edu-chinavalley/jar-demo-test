package com.chinavalley.demo.commoncodec.binarycodec;

import org.apache.commons.codec.binary.BinaryCodec;

public class BinaryCodecTest {

    public static void main(String ...args){
        String s ="00011111";
        String s1 ="00100001";
        BinaryCodec bc = new BinaryCodec();

        //不可显示字符
        byte[] b = bc.toByteArray(s);
        String t = new String(b);
        System.out.println(t);
        //可显示字符
        byte[] b1 = bc.toByteArray(s1);
        String t1 = new String(b1);
        System.out.println(t1);

        //转为ascii
        byte[] b2 = bc.toByteArray(s1);
        //转为二进制
        char[] d = bc.toAsciiChars(b2);
        //转为string
        String str = bc.toAsciiString(b2);
        //转为ascii
        byte[] e = bc.toAsciiBytes(b);
    }
}
