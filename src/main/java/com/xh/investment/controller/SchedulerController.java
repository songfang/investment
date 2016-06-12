package com.xh.investment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xh.investment.domain.Job;
import com.xh.investment.service.JobService;

@Controller
@RequestMapping("/task")
public class SchedulerController {

	@Autowired
	private JobService jobService;

	@RequestMapping("jobList")
	@ResponseBody
	public List<Job> jobList(HttpServletRequest request) {	
		return jobService.getAllTask();
/*		request.setAttribute("schedulerList", schedulerList);
		return "jsp/scheduler/scheduler";*/
	}
	
	@RequestMapping("schedulerList")
	public String schedulerList(HttpServletRequest request) {
		return "jsp/scheduler/scheduler";
	}
	
	@RequestMapping("treedata")
	@ResponseBody
	public List<Job> getSchedulerTree(HttpServletRequest request){
		return jobService.getAllTask();
	}
	
	//该注解用于将Controller的方法返回的对象，�?过�?当的HttpMessageConverter转换为指定格式后，写入到Response对象的body数据�?
	//返回的数据不是html标签的页面，而是其他某种格式的数据时（如json、xml等）使用�?
	@RequestMapping("add")
	@ResponseBody                                     
	public String schedulerList(HttpServletRequest request,Job scheduleJob){
		return "";
	}
	
	//改变job的状�?
	//客户端会
	@RequestMapping("changeSchedulerStatus")
	@ResponseBody
	public String changeSchedulerStatus(){
		return null;
	}
	
	@RequestMapping("updateCron")
	@ResponseBody
	public String updateCron(HttpServletRequest request,Long jobId,String cron){
		return "";
	}
}
