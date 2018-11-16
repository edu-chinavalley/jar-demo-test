package com.xxx.demo.quartz.components.trigger;

import com.xxx.demo.quartz.components.schedule.ScheDuleBase;
import org.quartz.CalendarIntervalTrigger;
import org.quartz.TriggerBuilder;

import java.util.Date;


public class Trigger {

    /**
     * 创建定时器
     * @return
     */
    public static Trigger createTrigger(){
        return (Trigger) TriggerBuilder
                .newTrigger() //创建新实例
                .startAt(new Date()) //开始时间
                .endAt(new Date())   //结束时间
                .forJob("forJob") //任务实体
                .modifiedByCalendar("asd")
                .usingJobData("asd","asd")  //传递参数
                .withDescription("asdaf") //描述
                .withIdentity("name","group1") //唯一索引
                .startNow()  //立即执行
                .withPriority(1) //优先级 时间->优先级->字母排序 数字越大，优先级越高
                .withSchedule(ScheDuleBase.getSimpleScheduleBuilder()) //添加关键schedule
                .build();
    }


}
