package com.situ.xuexiao.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.situ.xuexiao.pojo.Advice;
import com.situ.xuexiao.vo.FindAdviceByCondition;

public interface AdviceDao {

	int findAdviceCount();

	List<Advice> findAllAdvice(@Param(value="index")int index, @Param(value="pageSize")int pageSize);

	int addAdvice(Advice advice);

	int findAdviceCountByCondition(FindAdviceByCondition findAdviceByCondition);

	List<Advice> findAdviceByCondition(Map<String, Object> map);

}
