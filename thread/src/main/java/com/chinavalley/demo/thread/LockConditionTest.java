package com.chinavalley.demo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionTest {
    //ReentrantLock 也可以通过继承实现
    private ReentrantLock lock = new ReentrantLock(true);//true 决定锁是公平的 也就是先运行的 先获取到锁
    private Condition condition = lock.newCondition();// 实现等待/通知

    public void await() {
        try {
            lock.lock();
            System.out.println("await时间为：" + System.currentTimeMillis());

            System.out.println("是否公平锁？" + lock.isFair());

            System.out.println("当前线程调用lock()的次数 = " + lock.getHoldCount());
            //await方法 是释放锁的
            condition.await();
            System.out.println("await等待结束");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public void signal() {
        try {
            lock.lock();
            System.out.println("signal时间为：" + System.currentTimeMillis());
            System.out.println("有" + lock.getQueueLength() + "个线程正在等待！");
            condition.signal();
        }
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception
    {
        LockConditionTest td = new LockConditionTest();
        MyThread40 mt = new MyThread40(td);
        mt.start();
        Thread.sleep(3000);
        td.signal();
    }


    static class MyThread40 extends Thread {
        private LockConditionTest td;

        public MyThread40(LockConditionTest td) {
            this.td = td;
        }

        public void run() {
            td.await();
        }
    }
}
