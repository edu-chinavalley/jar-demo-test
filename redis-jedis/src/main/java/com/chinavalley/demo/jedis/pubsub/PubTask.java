package com.chinavalley.demo.jedis.pubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class PubTask implements Runnable {

    public static void main(String ...args){
        Thread thread = new Thread(new PubTask());
        thread.start();
    }
    @Override
    public void run() {
        JedisPool js = new JedisPool("192.168.1.102",6379);
        Jedis jedis = js.getResource();

        while(true) {
            jedis.publish("channel", "helklo");
            jedis.publish("war", "123");
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
