package com.chinavalley.demo.thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest extends ReentrantReadWriteLock {

    /**
     * 读和读之间不互斥
     */
    public void read() {
        try {
            readLock().lock();
            System.out.println(Thread.currentThread().getName() + "获得了读锁, 时间为" +
                    System.currentTimeMillis());
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            readLock().unlock();
        }
    }

    /**
     * 写和写之间互斥
     */
    public void write() {
        try {
            writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "获得了读锁, 时间为" +
                    System.currentTimeMillis());
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        final ReentrantReadWriteLockTest td = new ReentrantReadWriteLockTest();
        Runnable readRunnable = new Runnable() {
            public void run()
            {
                td.read();
            }
        };
        Runnable writeRunnable = new Runnable() {
            public void run()
            {
                td.write();
            }
        };
        // 测试  实现读与写之间互斥
        Thread t0 = new Thread(readRunnable);
        Thread t1 = new Thread(writeRunnable);
        t0.start();
        t1.start();
    }

}
