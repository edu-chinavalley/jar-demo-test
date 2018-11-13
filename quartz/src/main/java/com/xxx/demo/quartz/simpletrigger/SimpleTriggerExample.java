/**
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved. 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not 
 * use this file except in compliance with the License. You may obtain a copy 
 * of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
 * License for the specific language governing permissions and limitations 
 * under the License.
 * 
 */
 
package com.xxx.demo.quartz.simpletrigger;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class SimpleTriggerExample {

  public void run() throws Exception {

    // 获得引用
    SchedulerFactory sf = new StdSchedulerFactory();
    Scheduler sched = sf.getScheduler();



    // 选择触发时间
    Date startTime = DateBuilder.nextGivenSecondDate(null, 15);

    // 创建任务
    JobDetail job = newJob(SimpleJob.class).withIdentity("job1", "group1").build();

    //创建定时器
    SimpleTrigger trigger = (SimpleTrigger) newTrigger().withIdentity("trigger1", "group1").startAt(startTime).build();

    //添加定时任务
    Date ft = sched.scheduleJob(job, trigger);
    System.out.println(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() + " times, every "
             + trigger.getRepeatInterval() / 1000 + " seconds");

//    // 创建任务二
//    job = newJob(SimpleJob.class).withIdentity("job2", "group1").build();
//
//    //创建新的定时器
//    trigger = (SimpleTrigger) newTrigger().withIdentity("trigger2", "group1").startAt(startTime).build();
//
//    //注册任务
//    ft = sched.scheduleJob(job, trigger);
//    System.out.println(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() + " times, every "
//             + trigger.getRepeatInterval() / 1000 + " seconds");
//
//    //注册任务三
//    job = newJob(SimpleJob.class).withIdentity("job3", "group1").build();
//
//    //设置定时器 每个十秒进行一次，
//    trigger = newTrigger().withIdentity("trigger3", "group1").startAt(startTime)
//        .withSchedule(simpleSchedule().withIntervalInSeconds(10).withRepeatCount(10)).build();
//
//    //提交任务
//    ft = sched.scheduleJob(job, trigger);
//    System.out.println(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() + " times, every "
//             + trigger.getRepeatInterval() / 1000 + " seconds");
//
//    //从七十秒开始触发两次
//    trigger = newTrigger().withIdentity("trigger3", "group2").startAt(startTime)
//        .withSchedule(simpleSchedule().withIntervalInSeconds(10).withRepeatCount(2)).forJob(job).build();
//
//    ft = sched.scheduleJob(trigger);
//    System.out.println(job.getKey() + " will [also] run at: " + ft + " and repeat: " + trigger.getRepeatCount()
//             + " times, every " + trigger.getRepeatInterval() / 1000 + " seconds");
//
//    // job4 will run 6 times (run once and repeat 5 more times)
//    // job4 will repeat every 10 seconds
//    job = newJob(SimpleJob.class).withIdentity("job4", "group1").build();
//
//    trigger = newTrigger().withIdentity("trigger4", "group1").startAt(startTime)
//        .withSchedule(simpleSchedule().withIntervalInSeconds(10).withRepeatCount(5)).build();
//
//    ft = sched.scheduleJob(job, trigger);
//    log.info(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() + " times, every "
//             + trigger.getRepeatInterval() / 1000 + " seconds");
//
//    // job5 will run once, five minutes in the future
//    job = newJob(SimpleJob.class).withIdentity("job5", "group1").build();
//
//    trigger = (SimpleTrigger) newTrigger().withIdentity("trigger5", "group1")
//        .startAt(futureDate(5, IntervalUnit.MINUTE)).build();
//
//    ft = sched.scheduleJob(job, trigger);
//    log.info(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() + " times, every "
//             + trigger.getRepeatInterval() / 1000 + " seconds");
//
//    // job6 will run indefinitely, every 40 seconds
//    job = newJob(SimpleJob.class).withIdentity("job6", "group1").build();
//
//    trigger = newTrigger().withIdentity("trigger6", "group1").startAt(startTime)
//        .withSchedule(simpleSchedule().withIntervalInSeconds(40).repeatForever()).build();
//
//    ft = sched.scheduleJob(job, trigger);
//    log.info(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() + " times, every "
//             + trigger.getRepeatInterval() / 1000 + " seconds");


    sched.start();

//    // jobs can also be scheduled after start() has been called...
//    // job7 will repeat 20 times, repeat every five minutes
//    job = newJob(SimpleJob.class).withIdentity("job7", "group1").build();
//
//    trigger = newTrigger().withIdentity("trigger7", "group1").startAt(startTime)
//        .withSchedule(simpleSchedule().withIntervalInMinutes(5).withRepeatCount(20)).build();
//
//    ft = sched.scheduleJob(job, trigger);
//    System.out.println(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() + " times, every "
//             + trigger.getRepeatInterval() / 1000 + " seconds");
//
//    // jobs can be fired directly... (rather than waiting for a trigger)
//    job = newJob(SimpleJob.class).withIdentity("job8", "group1").storeDurably().build();
//
//    sched.addJob(job, true);
//
//    System.out.println("'Manually' triggering job8...");
//    sched.triggerJob(jobKey("job8", "group1"));
//
//    System.out.println("------- Waiting 30 seconds... --------------");

    try {
      // wait 33 seconds to show jobs
      Thread.sleep(30L * 1000L);
      // executing...
    } catch (Exception e) {
      //
    }

//    // jobs can be re-scheduled...
//    // job 7 will run immediately and repeat 10 times for every second
//    System.out.println("------- Rescheduling... --------------------");
//    trigger = newTrigger().withIdentity("trigger7", "group1").startAt(startTime)
//        .withSchedule(simpleSchedule().withIntervalInMinutes(5).withRepeatCount(20)).build();
//
//    ft = sched.rescheduleJob(trigger.getKey(), trigger);
//    System.out.println("job7 rescheduled to run at: " + ft);
//
//    System.out.println("------- Waiting five minutes... ------------");
    try {
      // wait five minutes to show jobs
      Thread.sleep(300L * 1000L);
      // executing...
    } catch (Exception e) {
      //
    }

    System.out.println("------- Shutting Down ---------------------");

    sched.shutdown(true);

    System.out.println("------- Shutdown Complete -----------------");

    // display some stats about the schedule that just ran
    //显示执行了几次任务
    SchedulerMetaData metaData = sched.getMetaData();
    System.out.println("Executed " + metaData.getNumberOfJobsExecuted() + " jobs.");

  }

  public static void main(String[] args) throws Exception {

    SimpleTriggerExample example = new SimpleTriggerExample();
    example.run();

  }

}
