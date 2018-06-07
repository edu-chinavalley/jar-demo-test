package com.chinavalley.demo.thread.ProducerAndConsumer;

/**
 * 生产者
 */
public class Producer extends Thread {
    // 每次生产的产品数量
    private int num;

    // 所在放置的仓库
    private Stor storage;

    // 构造函数，设置仓库
    public Producer(Stor storage){
        this.storage = storage;
    }

    // 线程run函数
    public void run(){
        produce(num);
    }

    // 调用仓库Storage的生产函数
    public void produce(int num){
        storage.produce(num);
    }

    // get/set方法
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Stor getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
