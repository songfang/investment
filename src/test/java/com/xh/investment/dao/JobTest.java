package com.xh.investment.dao;

import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.xh.investment.domain.Job;


public class JobTest {

		String resource = "mybatis.xml";
		InputStream is = JobTest.class.getClassLoader().getResourceAsStream(
				resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
				.build(is);

	@Test
	public void addJobTest() {
		
		Job job = new Job();
		job.setJobName("test5");
		job.setJobGroup("group");
		job.setJobStatus("0");
		job.setCronExpression("");
		job.setDescription("");
		job.setBeanClass("");
		job.setIsConcurrent("");
		job.setSpringId("");
		job.setMethodName("");
		job.setCreateTime(new Date());
		job.setUpdateTime(new Date());
		
		SqlSession session = sessionFactory.openSession();
		String statment = "com.xh.investment.dao.JobMapper.insert";
		session.insert(statment, job);
		session.commit();
		session.close();
	}

	@Test
	public void getJobTest() {
		SqlSession session = sessionFactory.openSession();
		String statment = "com.xh.investment.dao.JobMapper.selectByPrimaryKey";
		Job job = session.selectOne(statment, (long)1);
		session.close();
		System.out.println(job.toString());

	}

}
