package com.xh.investment.dao;

import java.util.List;

import com.xh.investment.domain.Futures;

public interface FuturesMapper {
	
	List<Futures> getAll();
	
    int deleteByPrimaryKey(Long id);

    int insert(Futures record);

    int insertSelective(Futures record);

    Futures selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Futures record);

    int updateByPrimaryKey(Futures record);
}