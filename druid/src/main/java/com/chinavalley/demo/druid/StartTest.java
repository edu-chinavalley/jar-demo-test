package com.chinavalley.demo.druid;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author: polfdark
 */
public class StartTest {

    public static void main(String ...args){
        DruidDataSource ds = new DruidDataSource();
        /**
         * 多数据源
         */
        ds.setName("test1");
        /**
         * 数据库地址
         */
        ds.setUrl("");
    }
}
