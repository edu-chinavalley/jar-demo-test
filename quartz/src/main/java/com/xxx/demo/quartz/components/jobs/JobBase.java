package com.xxx.demo.quartz.components.jobs;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;

public class JobBase {

    public static JobDetail createSimpleJob(Class<? extends Job> clszz){

        JobDetail job = JobBuilder.newJob() //创建一个任务
                .withIdentity("job1","group1")  //创建唯一的id和组别
                //.withIdentity("job1") // 创建唯一的id,组别为null
                //.withIdentity(new JobKey("job1",null))    //创建唯一的id和组别
                //.setJobData(dataMap)    //填充各种参数
                .usingJobData("param","good")   //可以填充各种参数
                .requestRecovery()  //中断恢复,默认为true 启动的时候会自动把持久化的任务提取出来执行
                //.requestRecovery(true)  //中断恢复 指定策略 启动的时候会自动把持久化的任务提取出来执行
                .ofType(clszz) //导入要加载的任务
                //.storeDurably() //任务处理完成后,不会在数据库里删除相关信息 默认为true
                .storeDurably(true)
                .withDescription("添加备注")
                .build();

        return job;
    }
}
