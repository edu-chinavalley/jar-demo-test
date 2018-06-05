package com.chinavalley.demo.jedis.pubsub;

public class SubTaskListen implements Runnable {

    private SubTask subTask;
    public SubTaskListen(SubTask subTask){
        this.subTask = subTask;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(20000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        subTask.unsubscribe("channel");
    }
}
