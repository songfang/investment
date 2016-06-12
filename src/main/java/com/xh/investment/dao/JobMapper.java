package com.xh.investment.dao;

import java.util.List;

import com.xh.investment.domain.Job;



public interface JobMapper {
	
	List<Job> getAll();
	
    int deleteByPrimaryKey(Long jobId);

    int insert(Job record);

    int insertSelective(Job record);

    Job selectByPrimaryKey(Long jobId);
    
    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);
}