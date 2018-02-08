package com.situ.xuexiao.service;

import com.situ.xuexiao.common.SeverResponse;
import com.situ.xuexiao.pojo.Advice;
import com.situ.xuexiao.vo.FindAdviceByCondition;
import com.situ.xuexiao.vo.PageBean;

public interface IAdviceService {

	PageBean<Advice> findAllAdvice(int pageIndex, int pageSize);

	SeverResponse<Advice> addAdvice(Advice advice);

	PageBean<Advice> findAdviceByCondition(int pageIndex, int pageSize, FindAdviceByCondition findAdviceByCondition);

}
