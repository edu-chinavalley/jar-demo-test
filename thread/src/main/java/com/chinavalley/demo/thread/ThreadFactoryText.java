package com.chinavalley.demo.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadFactoryText {

    static class MyThreadFactory implements ThreadFactory{
        private static final AtomicInteger poolNumber = new AtomicInteger(1);//原子类，线程池编号
        private final ThreadGroup group;//线程组
        private final AtomicInteger threadNumber = new AtomicInteger(1);//线程数目
        private final String namePrefix;//为每个创建的线程添加的前缀

        MyThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();//取得线程组
            namePrefix = "pool-" + poolNumber.getAndIncrement() + "-thread-";
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);//真正创建线程的地方，设置了线程的线程组及线程名
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)//默认是正常优先级
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }

    }

    static class MyTask implements Runnable {

        private int num;

        public MyTask(int num) {
            this.num = num;
        }

        public void run() {
//            System.out.println("Task "+ num+" is running");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getThreadGroup().getName());
            try {
                Thread.sleep(2*10000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        System.out.println("main thread beging");
        MyThreadFactory factory = new MyThreadFactory();

        Thread thread = null;
        for(int i = 0; i < 10; i++) {
            thread = factory.newThread(new MyTask(i));
            thread.start();
        }
        System.out.println("main thread end");
    }

}
