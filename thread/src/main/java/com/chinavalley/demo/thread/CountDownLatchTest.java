package com.chinavalley.demo.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 与join相似 可以实现一个线程结束 再执行另一个线程
 * 与join的区别  可以实现一个线程执行一半 再去执行另一个线程
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("线程名称："+Thread.currentThread().getName()+"----开始");
        //创建count的个数
        final CountDownLatch count = new CountDownLatch(5);

        for (int i = 0 ; i < 5 ; i++){
            new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程名称："+Thread.currentThread().getName()+"---执行");
                    // 达到目的 减掉一个
                    count.countDown();
                }
            }).start();
        }
        // 阻塞主线程 直到子线程都结束
        count.await();
        System.out.println("线程名称："+Thread.currentThread().getName()+"----结束");
    }
}
