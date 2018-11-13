package com.chinavalley.demo.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadAtomTest extends Thread {

    static class ThreadDomain{
        public static AtomicInteger aiRef = new AtomicInteger();

        /**
         * addAndGet()与getAndAdd()两个操作是可分割  导致不是原子操作
         * 可以在 addNum方法加上synchronized
         */
        public void addNum() {
            System.out.println(Thread.currentThread().getName() + "加了100之后的结果：" +
                    aiRef.addAndGet(100));
            aiRef.getAndAdd(1);
        }
    }
    private ThreadDomain td;

    public ThreadAtomTest(ThreadDomain td) {
        this.td = td;
    }

    public void run() {
        td.addNum();
    }

    public static void main(String[] args) {
        try {
            ThreadDomain td = new ThreadDomain();
            ThreadAtomTest[] mt = new ThreadAtomTest[5];
            for (int i = 0; i < mt.length; i++) {
                mt[i] = new ThreadAtomTest(td);
            }
            for (int i = 0; i < mt.length; i++) {
                mt[i].start();
            }
            Thread.sleep(1000);
            System.out.println(ThreadDomain.aiRef.get());
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


