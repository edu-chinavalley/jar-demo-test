package com.chinavalley.demo.jedis.pubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

/**
 * 必须继承JedisPubSub
 */
public class SubTask extends JedisPubSub implements Runnable {


    public static void main(String ...args){
        Thread ss = new Thread(new SubTask());
        ss.start();
    }

    @Override
    public void run() {
        JedisPool jedisPool = new JedisPool("192.168.1.102",6379);
        Jedis jedis = jedisPool.getResource();
        SubTask subTask = new SubTask();
        Thread thread = new Thread(new SubTaskListen(subTask));
        thread.start();
        jedis.subscribe(subTask,"channel","war");

    }
    /**
     *  取得订阅的消息后的处理
     * @param channel
     * @param message
     */
    @Override
    public void onMessage(String channel, String message) {
        System.out.println(channel + "=" + message);
    }

    /**
     * 初始化订阅时候的处理
     * @param channel
     * @param subscribedChannels
     */
    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println(channel + "=" + subscribedChannels);
    }

    /**
     * 取消订阅时候的处理
     * @param channel
     * @param subscribedChannels
     */
    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println(channel + "=" + subscribedChannels);
    }

    /**
     * // 初始化按表达式的方式订阅时候的处理
     * @param pattern
     * @param subscribedChannels
     */
    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        System.out.println(pattern + "=" + subscribedChannels);
    }

    /**
     *  取消按表达式的方式订阅时候的处理
     * @param pattern
     * @param subscribedChannels
     */
    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        System.out.println(pattern + "=" + subscribedChannels);
    }

    /**
     * 取得按表达式的方式订阅的消息后的处理
     * @param pattern
     * @param channel
     * @param message
     */
    @Override
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println(pattern + "=" + channel + "=" + message);
    }


}
