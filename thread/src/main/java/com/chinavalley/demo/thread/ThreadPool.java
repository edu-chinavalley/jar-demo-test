package com.chinavalley.demo.thread;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

public class ThreadPool {

    public static void main(String[] args) {
        executeFixedDelay();
    }

    public static void testCachedThreadPool() {
        System.out.println("Main: Starting at: "+ new Date());
        ExecutorService exec = Executors.newCachedThreadPool();   //创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
        for(int i = 0; i < 10; i++) {
            exec.execute(new Handle(String.valueOf(i)));
        }
        exec.shutdown();  //执行到此处并不会马上关闭线程池,但之后不能再往线程池中加线程，否则会报错
        System.out.println("Main: Finished all threads at"+ new Date());
    }

    public static void testFixThreadPool() {
        System.out.println("Main Thread: Starting at: "+ new Date());
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 10; i++) {
            exec.execute(new Handle(String.valueOf(i)));
        }
        exec.shutdown();  //执行到此处并不会马上关闭线程池
        System.out.println("Main Thread: Finished at:"+ new Date());
    }

    public static void testSingleThreadPool() {
        System.out.println("Main Thread: Starting at: "+ new Date());
        ExecutorService exec = Executors.newSingleThreadExecutor();   //创建大小为1的固定线程池
        for(int i = 0; i < 10; i++) {
            exec.execute(new Handle(String.valueOf(i)));
        }
        exec.shutdown();  //执行到此处并不会马上关闭线程池
        System.out.println("Main Thread: Finished at:"+ new Date());
    }

    public static void testScheduledThreadPool() {
        System.out.println("Main Thread: Starting at: "+ new Date());
        ScheduledThreadPoolExecutor  exec = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(10);   //创建大小为10的线程池
        for(int i = 0; i < 10; i++) {
            exec.schedule(new Handle(String.valueOf(i)), 10, TimeUnit.SECONDS);//延迟10秒执行
        }
        exec.shutdown();  //执行到此处并不会马上关闭线程池
        while(!exec.isTerminated()){
            //wait for all tasks to finish
        }
        System.out.println("Main Thread: Finished at:"+ new Date());
    }

    /**
     * 间隔指的是连续两次任务开始执行的间隔
     *
     * 初始化延迟0ms开始执行，每隔2000ms重新执行一次任务
     * 对于scheduleAtFixedRate方法，当执行任务的时间大于我们指定的间隔时间时，
     * 它并不会在指定间隔时开辟一个新的线程并发执行这个任务。而是等待该线程执行完毕。
     * 并且时间间隔为0
     */
    public static void executeFixedRate() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
        executor.scheduleAtFixedRate(
                new Handle("hahahaha"),
                0,
                2000,
                TimeUnit.MILLISECONDS);
    }

    /**
     * 间隔指的是连续上次执行完成和下次开始执行之间的间隔。
     *
     * 以固定延迟时间进行执行
     * 本次任务执行完成后，需要延迟设定的延迟时间，才会执行新的任务
     */
    public static void executeFixedDelay() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
        executor.scheduleWithFixedDelay(
                new Handle("hahahaha"),
                0,
                2000,
                TimeUnit.MILLISECONDS);
    }

    /**
     * 每天晚上9点执行一次
     * 每天定时安排任务进行执行
     */
    public static void executeEightAtNightPerDay() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        long oneDay = 24 * 60 * 60 * 1000;
        long initDelay  = getTimeMillis("21:00:00") - System.currentTimeMillis();
        initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;

        executor.scheduleAtFixedRate(
                new Handle("hahahaha"),
                initDelay,
                oneDay,
                TimeUnit.MILLISECONDS);
    }

    /**
     * 获取指定时间对应的毫秒数
     * @param time "HH:mm:ss"
     * @return
     */
    private static long getTimeMillis(String time) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");
            Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);
            return curDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }


}
