package com.xxx.demo.quartz.components.schedule;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class ScheDuleBase {

    /**
     * 获取调度器
     * @return
     * @throws SchedulerException
     */
    public static Scheduler getSchedulerBase() throws SchedulerException {
        return new StdSchedulerFactory().getScheduler();
    }

    /**
     * 简单触发器
     * @return
     */
    public static SimpleScheduleBuilder getSimpleScheduleBuilder(){
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder
                .simpleSchedule()//创建一个SimpleScheduleBuilder
//                .withIntervalInSeconds(10)//指定一个重复间隔,以毫秒为单位。
//                .withRepeatCount(5) //次数为10次
//                .withIntervalInHours(1)//每间隔1小时执行一次
//                .repeatForever() //一直执行,奔腾到老不停歇
//                .repeatMinutelyForever() //1分钟执行(一直执行)
//                .repeatMinutelyForever(3) //间隔几分钟执行
//                .repeatSecondlyForever() //1秒执行(一直执行)
//                .repeatSecondlyForever(3)//每隔几秒钟执行(一直执行)
//                .repeatHourlyForever() //一小时执行
//                .repeatHourlyForever(3) //3小时执行
//                .repeatMinutelyForTotalCount(3,3) //每隔三分钟执行3次
//                .repeatMinutelyForTotalCount(2) //每分钟执行，共2次
//                .repeatSecondlyForTotalCount(2,3) //每隔3秒钟执行2次
//                .repeatHourlyForTotalCount(3,2) //每2小时执行 3次
//                .repeatHourlyForTotalCount(3) //每小时执行 共3次
                //错过的触发机制
//                .withMisfireHandlingInstructionFireNow() //失效之后再恢复并马上执行
//                //就是当某个任务在理论执行的时间点没有执行，当任务正常起来之后，马上就去执行刚才未执行的任务。
//                .withMisfireHandlingInstructionIgnoreMisfires()
//                .withMisfireHandlingInstructionNextWithExistingCount()//不触发立即执行
//                .withMisfireHandlingInstructionNextWithRemainingCount()//忽略misfired,这次被忽略的trigger也不会再次执行
//                .withMisfireHandlingInstructionNowWithExistingCount()
//                .withMisfireHandlingInstructionNowWithRemainingCount()
                ;
        return simpleScheduleBuilder;
    }

    /**
     * Cron触发器
     * @return
     */
    public static CronScheduleBuilder getCornScheDuleBuilder(){
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder
                //.atHourAndMinuteOnGivenDaysOfWeek() // (通过`分钟`、`小时`指定)执行，，而天数由`周`确定，如果“周二、周四的10:05“等；
                //.dailyAtHourAndMinute() //每天在指定的时间执行，根据这个调度创建一个cron表达式
                //.monthlyOnDayAndHourAndMinute()   ////调度计划：每月的某一天，在指定的时间（小时和分钟）执行
                //.weeklyOnDayAndHourAndMinute()    //调度计划：每周的某一天，在指定的时间（小时和分钟）执行
                .cronSchedule("")     //根据cron表达式建造
                //.inTimeZone()       //设置时区
                //.withMisfireHandlingInstructionDoNothing()  //所有的misfire不管，执行下一个周期的任务
                //.withMisfireHandlingInstructionFireAndProceed() //会合并部分的misfire,正常执行下一个周期的任务
                //  假设9，10的任务都misfire了，系统在10：15分起来了。只会执行一次misfire，下次正点执行。
                //.withMisfireHandlingInstructionIgnoreMisfires() //所有misfire的任务会马上执行
                //打个比方，如果9点misfire了，在10：15系统恢复之后，9点，10点的misfire会马上执行
                ;
        return cronScheduleBuilder;
    }

    /**
     * 日期触发器
     * @return
     */
    public static DailyTimeIntervalScheduleBuilder dailyTimeIntervalScheduleBuilder(){
        DailyTimeIntervalScheduleBuilder dailyTimeIntervalScheduleBuilder = DailyTimeIntervalScheduleBuilder
                .dailyTimeIntervalSchedule()    //创建实例
//                .withIntervalInHours()  //按小时执行
//                .withIntervalInMinutes()    //按分钟执行
//                .withIntervalInSeconds()    //按秒数执行
//                .onDaysOfTheWeek(1)         //周几执行
//                .endingDailyAfterCount()    //支持次数
//                .endingDailyAt()            //结束时间
//                .startingDailyAt()          // 开始触发时间
//                .onEveryDay()               //每天执行
//                .onMondayThroughFriday()    //周一到周五
//                .onSaturdayAndSunday()      //周六到周日
//
//                //断线策略
//                .withMisfireHandlingInstructionDoNothing()
//                .withMisfireHandlingInstructionFireAndProceed()
//                .withMisfireHandlingInstructionIgnoreMisfires()
        ;
        return dailyTimeIntervalScheduleBuilder;
    }

    /**
     * 日历触发器
     * @return
     */
    public static CalendarIntervalScheduleBuilder calendarIntervalScheduleBuilder(){
        CalendarIntervalScheduleBuilder calendarIntervalScheduleBuilder = CalendarIntervalScheduleBuilder
                .calendarIntervalSchedule() //取得实例
//                .withInterval()
//                .withIntervalInDays()
//                .withIntervalInMonths()
//                .withIntervalInHours()
//                .withIntervalInMinutes()
//                .withIntervalInSeconds()
//                .withIntervalInWeeks()
//                .withIntervalInYears()
//                .inTimeZone()
//                .preserveHourOfDayAcrossDaylightSavings()
//                .skipDayIfHourDoesNotExist()
//                .withMisfireHandlingInstructionDoNothing()
//                .withMisfireHandlingInstructionFireAndProceed()
//                .withMisfireHandlingInstructionIgnoreMisfires()
                ;
        return calendarIntervalScheduleBuilder;
    }
}
