package com.chinavalley.demo.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: polfdark
 */
public class Test {

    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String []args){
        logger.info("asd");
    }
}
