package com.xh.investment.dao;

import com.xh.investment.domain.Trigger;
import com.xh.investment.domain.TriggerKey;

public interface TriggerMapper {
    int deleteByPrimaryKey(TriggerKey key);

    int insert(Trigger record);

    int insertSelective(Trigger record);

    Trigger selectByPrimaryKey(TriggerKey key);

    int updateByPrimaryKeySelective(Trigger record);

    int updateByPrimaryKey(Trigger record);
}