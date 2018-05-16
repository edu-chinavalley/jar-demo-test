package com.chinavalley.demo.commoncodec.urlcodec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;

import java.io.UnsupportedEncodingException;

public class UrlCodecTest {

    public static void main(String ...args) throws UnsupportedEncodingException, DecoderException, EncoderException {

        URLCodec codec = new URLCodec();
        String data = "啦啦啦";
        String encode = codec.encode(data, "UTF-8");
        System.out.println(encode);
        System.out.println(codec.decode(encode, "UTF-8"));
    }
}
