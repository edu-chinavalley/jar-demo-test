package com.chinavalley.demo.jedis.connect;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolConnect {

    public static void main(String ...args){
        JedisPool jedis = new JedisPool("192.168.1.104",6379);
        Jedis jedisCli = jedis.getResource();
        jedisCli.set("ccc","ddd");
        jedisCli.set("ddd","eee");
        jedisCli.close();
        jedis.close();


        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        /**
         * 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
         */
        jedisPoolConfig.setBlockWhenExhausted(true);
        /**
         * 设置的逐出策略类名, 默认DefaultEvictionPolicy(当连接超过最大空闲时间,或连接数超过最大空闲连接数)
         * 出自commons-pool
         */
        jedisPoolConfig.setEvictionPolicyClassName("org.apache.commons.pool2.impl.DefaultEvictionPolicy");

        //jedisPoolConfig.setFairness();
        /**
         * 是否启用pool的jmx管理功能, 默认true 监控
         */
        jedisPoolConfig.setJmxEnabled(true);

        //jedisPoolConfig.setJmxNameBase();
        /**
         * 不知道干嘛用的
         */
        jedisPoolConfig.setJmxNamePrefix("pool");
        /**
         * 是否启用后进先出, 默认true
         */
        jedisPoolConfig.setLifo(true);
        /**
         * 最大空闲连接数, 默认8个
         */
        jedisPoolConfig.setMaxIdle(8);
        /**
         * 最大连接数, 默认8个
         */
        jedisPoolConfig.setMaxTotal(8);
        /**
         * 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
         */
        jedisPoolConfig.setMaxWaitMillis(-1);
        /**
         * 逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
         */
        jedisPoolConfig.setMinEvictableIdleTimeMillis(1800000);
        /**
         * 最小空闲连接数, 默认0
         */
        jedisPoolConfig.setMinIdle(0);
        /**
         * 每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
         */
        jedisPoolConfig.setNumTestsPerEvictionRun(3);

        /**
         * 对象空闲多久后逐出, 当空闲时间>该值 且 空闲连接>最大空闲数 时直接逐出,不再根据MinEvictableIdleTimeMillis判断  (默认逐出策略)
         */
        jedisPoolConfig.setSoftMinEvictableIdleTimeMillis(1800000);

        /**
         * 在获取连接的时候检查有效性, 默认false
         */
        jedisPoolConfig.setTestOnBorrow(false);
        /**
         * 在空闲时检查有效性, 默认false
         */
        jedisPoolConfig.setTestWhileIdle(false);
        /**
         * //逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
         */
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(-1);

        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"192.168.1.104",6379);
    }
}
