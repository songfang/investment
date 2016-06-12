package com.xh.investment.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xh.investment.dao.FuturesMapper;
import com.xh.investment.domain.Futures;

@Service("futuresService")
public class FuturesService {
	
	public static final Logger logger = Logger.getLogger(FuturesService.class);
	
	@Autowired
	private FuturesMapper futuresMapper;
	
	public List<Futures> getAllFutureData(){
		return futuresMapper.getAll();
	}
	

}
