package com.chinavalley.demo.commonio.endian;

import org.apache.commons.io.EndianUtils;

//Enddian是用来转换大小端问题
public class EndianUtilsTest {
    public static void main(String ...args){
        short srcShort = (short)0x0201;
        short destShort = EndianUtils.swapShort((short)0x0102);


        Integer srcInt = 0x0100000;
        Integer destInt = EndianUtils.swapInteger(0x00000001);




    }


}
