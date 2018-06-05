package com.chinavalley.demo.jedis.connect;

import redis.clients.jedis.Jedis;

public class JedisConnect {

    public static void main(String ...args){
        Jedis jedis = new Jedis("192.168.1.104",6379);
        jedis.set("aa","11");
        jedis.set("bb","22");
        jedis.close();
    }
}
