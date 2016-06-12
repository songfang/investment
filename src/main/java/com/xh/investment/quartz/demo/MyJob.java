package com.xh.investment.quartz.demo;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job {

	public MyJob() {
		// TODO Auto-generated constructor stub
	}

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("my first Quartz job......");
	}

}
