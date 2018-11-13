package com.chinavalley.demo.thread;

public class ThreadLocalText {
    /**
     * 为每个线程创建副本   为了方便每个线程处理自己的状态而引入的一个机制
     */
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();

    /**
     * 重写initialValue  目的是为了在set前调用get 不会报空指针异常
     */
//    ThreadLocal<Long> longLocal = new ThreadLocal<Long>(){
//        protected Long initialValue() {
//            return Thread.currentThread().getId();
//        };
//    };
//    ThreadLocal<String> stringLocal = new ThreadLocal<String>(){;
//        protected String initialValue() {
//            return Thread.currentThread().getName();
//        };
//    };

    /**
     * longLocal.set
     * 对Thread类中的threadLocals进行初始化
     */
    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    /**
     * longLocal.get
     * 对Thread类中的threadLocals进行初始化 与set一样
     * 在进行get之前，必须先set，否则会报空指针异常；
     */
    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalText test = new ThreadLocalText();


        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());


        Thread thread1 = new Thread(){
            public void run() {
                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
            };
        };
        thread1.start();
        thread1.join();

        // 说明ThreadLocal 记录的是各个线程自己的
        System.out.println(test.getLong());
        System.out.println(test.getString());
    }
}
