package com.xxx.demo.quartz.test.easysimple;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class EasySimple {

    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sche = sf.getScheduler();
        JobDataMap dataMap = new JobDataMap();
        dataMap.put("key1","value");

        JobDetail job = JobBuilder.newJob() //创建一个任务
                .withIdentity("job1","group1")  //创建唯一的id和组别
                //.withIdentity("job1") // 创建唯一的id,组别为null
                //.withIdentity(new JobKey("job1",null))    //创建唯一的id和组别
                .setJobData(dataMap)    //填充各种参数
                .usingJobData("param","good")   //可以填充各种参数
                .requestRecovery()  //中断恢复,默认为true 启动的时候会自动把持久化的任务提取出来执行
                .requestRecovery(true)  //中断恢复 指定策略 启动的时候会自动把持久化的任务提取出来执行
                .ofType(job1.class) //导入要加载的任务
                .build();
    }

    class job1 implements Job{

        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            System.out.printf("example");
        }
    }
}
