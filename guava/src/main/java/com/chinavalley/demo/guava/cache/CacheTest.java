package com.chinavalley.demo.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.Weigher;

import java.util.concurrent.TimeUnit;

public class CacheTest {

    public static void main(String ...args){
        Cache<String,String> cache = CacheBuilder.newBuilder()
                /**
                 * 缓存的大小
                 */
                .initialCapacity(10)
                /**
                 * 缓存的并发数
                 */
                .concurrencyLevel(5)
                /**
                 * 缓存项在持续的时间内没有被读/写访问，会被清理
                 */
                .expireAfterAccess(1000L,TimeUnit.SECONDS)
                /**
                 * 访问后的过期时间
                 */
                .expireAfterWrite(1000L,TimeUnit.SECONDS)

                /**
                 * 最大缓存数量
                 */
                .maximumSize(1000)
                /**
                 * 最大的缓存大小
                 */
                .maximumWeight(10000)
                /**
                 * 开启缓存统计
                 */
                .recordStats()
                /**
                 * https://blog.csdn.net/aitangyong/article/details/53504253
                 */
                // TODO: 2018/5/24 需要明确用处 
                //.refreshAfterWrite()
                /**
                 * 删除监听器
                 * https://blog.csdn.net/aitangyong/article/details/53127605
                 */
               // .removalListener()
                /**
                 * 使用软引用存储值
                 */
               // .softValues()
                /**
                 * 使用ticker用来测试，改变时间源
                 * https://blog.csdn.net/aitangyong/article/details/53114797
                 */
                //.ticker()
                /**
                 * 使用弱引用存储键
                 */
                .weakKeys()
                /**
                 * weakValues
                 */
                .weakValues()
                /**
                 *
                 */
                //.weigher()
                .build();


    }
}
