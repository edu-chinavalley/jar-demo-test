package com.chinavalley.demo.commonio.utility;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


//IOSUtils主要有两类方法 copy和copyLarge
public class IOUtilsTest {

    public static void main(String ...args) throws IOException {
        IOUtilsTest test = new IOUtilsTest();
        test.showInfoByIOUtils();
    }


    public void showInfoByIOUtils() throws IOException {
        URL url = new URL("https://www.baidu.com");
        InputStream in = url.openStream();
        System.out.println(in);
        try {
            System.out.println(IOUtils.toString(in,"utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
