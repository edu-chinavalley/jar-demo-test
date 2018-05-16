package com.chinavalley.demo.commoncodec.hex;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.Hex;

public class HexTest {

    public static void main(String ...args) throws EncoderException {
        Hex hex = new Hex();
        String data = "poldark";
        System.out.println(new String(hex.encode(data.getBytes())));
    }
}
