package com.chinavalley.demo.thread;


import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ThreadGroupText implements Runnable {

    static class Result {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    private Result result;

    public ThreadGroupText(Result result) {
        this.result = result;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("Thread Start " + name);
        try {
            doTask();
            result.setName(name);
        } catch (InterruptedException e) {
            System.out.printf("Thread %s: Interrupted\n", name);
            return;
        }
        System.out.println("Thread end " + name);
    }

    private void doTask() throws InterruptedException {
        Random random = new Random((new Date()).getTime());
        int value = (int) (random.nextDouble() * 100);
        System.out.printf("Thread %s: %d\n", Thread.currentThread().getName(),
                value);
        //与 Tread.sleep一样  这样睡眠设置时间方式更可读
        TimeUnit.SECONDS.sleep(value);
    }

    public static void main(String[] args) {
        System.out.println("main thread start:");

        //创建5个线程，并入group里面进行管理
        ThreadGroup threadGroup = new ThreadGroup("Searcher");
        Result result = new Result();
        ThreadGroupText searchTask = new ThreadGroupText(result);
        for (int i = 0; i < 5; i++) {
            Thread thred = new Thread(threadGroup, searchTask);
            thred.start();
            System.out.println(thred.getState());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //通过这种方法可以看group里面的所有信息
        System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
        System.out.printf("Information about the Thread Group\n");
        threadGroup.list();

        //这样可以复制group里面的thread信息
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (int i = 0; i < threadGroup.activeCount(); i++) {
            System.out.printf("Thread %s: %s -- %s\n", threads[i].getName(),
                    threads[i].getState(),threads[i].getId());
        }

        //确保线程组里的线程之行结束  再向下执行
        waitFinish(threadGroup);

        //将group里面的所有线程都给interpet
        threadGroup.interrupt();

        System.out.println("main thread end:");
    }

    private static void waitFinish(ThreadGroup threadGroup) {
        while (threadGroup.activeCount() > 0) {
            try {
                System.out.println("activeCount = " + threadGroup.activeCount());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * uncaughtException  ThreadGroup统一异常处理
     * @param args
     */
//    public static void main(String[] args) {
//        ThreadGroup threadGroup1 =
//                // 这是匿名类写法
//                new ThreadGroup("group1") {
//                    // 继承ThreadGroup并重新定义以下方法
//                    // 在线程成员抛出unchecked exception
//                    // 会执行此方法
//                    public void uncaughtException(Thread t, Throwable e) {
//                        System.out.println(t.getName() + ": " + e.getMessage());
//                    }
//                };
//        // 这是匿名类写法
//        Thread thread1 =
//                // 这个线程是threadGroup1的一员
//                new Thread(threadGroup1, new Runnable() {
//                    public void run() {
//                        // 抛出unchecked异常
//                        throw new RuntimeException("测试异常");
//                    }
//                });
//
//        thread1.start();
//    }

}
