package com.xh.investment.quartz.demo;

import java.util.Date;

import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyJobExample {

	public static void run() throws Exception{
		Logger logger = LoggerFactory.getLogger(MyJobExample.class);
		logger.info("�?��初始�?.....");
		
		SchedulerFactory sf = new StdSchedulerFactory();	//创建scheduler工厂
		Scheduler scheduler = sf.getScheduler();			//通过scheduler工厂获取scheduler
		
		logger.info("");
		
		Date runTime = DateBuilder.evenMinuteDate(new Date());		//计算�?��执行时间
		
		logger.info("执行时间:" + runTime.toString());
		JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("job1","group1").build(); //定义�?��job并于MyJob class
		
		//Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startNow().build();
		
		scheduler.scheduleJob(job, trigger);
		scheduler.start();
		
		logger.info("-----------Started Scheduler-------------");
		logger.info("-----------Waiting 20 seconds------------");
		
		try{
			Thread.sleep(20L*1000L);
		} catch(Exception e){
			
		}
		logger.info("---------------Shutting Down--------------");
		scheduler.shutdown(true);
		logger.info("---------------Shutdown Complete----------");
		
	}
	
	public static void main(String[] args) throws Exception {
		MyJobExample myJobExample = new MyJobExample();
		myJobExample.run();
	}
	
}
