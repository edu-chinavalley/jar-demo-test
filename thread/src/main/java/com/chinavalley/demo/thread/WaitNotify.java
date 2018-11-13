package com.chinavalley.demo.thread;
/**
 * wait用法
 */
public class WaitNotify implements Runnable {

    private String name;
    private Object prev;
    private Object self;

    private WaitNotify(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;

                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        WaitNotify pa = new WaitNotify("A", c, a);
        WaitNotify pb = new WaitNotify("B", a, b);
        WaitNotify pc = new WaitNotify("C", b, c);


        new Thread(pa).start();
        Thread.sleep(100);  //确保按顺序A、B、C执行
        new Thread(pb).start();
        Thread.sleep(100);
        new Thread(pc).start();
        Thread.sleep(100);
    }
}
