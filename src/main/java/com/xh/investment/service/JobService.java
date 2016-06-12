package com.xh.investment.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import com.xh.investment.dao.JobMapper;
import com.xh.investment.domain.Job;


/**
 * 调度任务管理
 * @author fang.song
 *
 */
@Service("jobService")
public class JobService {
	public final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired   
	private SchedulerFactoryBean schedulerFactoryBean;   //集成到Spring中的Quartz,用来生成Scheduler的factory
	
	@Autowired
	private JobMapper jobMapper;
	
	public List<Job> getAllTask(){
		return jobMapper.getAll();
	}

}
