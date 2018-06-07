package com.chinavalley.demo.thread;

/**
 * 不可见的  在没有同步的情况下 会被JVM重排序
 */
public class NoVisibility {
    private static boolean ready = false;
    private static int num = 0;

    private static class ReadThread extends Thread{
        @Override
        public void run() {
            while (!ready){
                Thread.yield();
                System.out.println(ready);
                System.out.println(num);
            }
            System.out.println(ready);
        }
    }

    public static void main(String[] args) {
        new ReadThread().start();
        num = 50;
        ready = true;
    }

}
