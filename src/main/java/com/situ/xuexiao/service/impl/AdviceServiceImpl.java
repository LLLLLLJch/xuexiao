package com.situ.xuexiao.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.xuexiao.common.SeverResponse;
import com.situ.xuexiao.dao.AdviceDao;
import com.situ.xuexiao.pojo.Advice;
import com.situ.xuexiao.pojo.Student;
import com.situ.xuexiao.service.IAdviceService;
import com.situ.xuexiao.vo.FindAdviceByCondition;
import com.situ.xuexiao.vo.PageBean;

@Service
public class AdviceServiceImpl implements IAdviceService{

	@Autowired
	private AdviceDao adviceDao;

	@Override
	public PageBean<Advice> findAllAdvice(int pageIndex, int pageSize) {
		PageBean<Advice> pageBean = new PageBean<Advice>();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalCount = adviceDao.findAdviceCount();
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		int index = (pageIndex - 1) * pageSize;
		List<Advice> list = adviceDao.findAllAdvice(index,pageSize);
		System.out.println(list);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public SeverResponse<Advice> addAdvice(Advice advice) {
		String ID = UUID.randomUUID().toString().replaceAll("-", "");
		Date postedDate = new Date();
		advice.setID(ID);
		advice.setPostedDate(postedDate);
		if(adviceDao.addAdvice(advice) > 0) {
			return SeverResponse.createSuccess("提出成功");
		}
		return SeverResponse.createError("提出失败");
	}

	@Override
	public PageBean<Advice> findAdviceByCondition(int pageIndex, int pageSize,
			FindAdviceByCondition findAdviceByCondition) {
		PageBean<Advice> pageBean = new PageBean<Advice>();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalCount = adviceDao.findAdviceCountByCondition(findAdviceByCondition);
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		int index = (pageIndex - 1) * pageSize;
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("index", index);
		map.put("pageSize", pageSize);
		map.put("title", findAdviceByCondition.getTitle());
		map.put("startTime", findAdviceByCondition.getStartTime());
		map.put("endTime", findAdviceByCondition.getEndTime());
		map.put("category_id", findAdviceByCondition.getCategory_id());
		List<Advice> list = adviceDao.findAdviceByCondition(map);
		System.out.println(list);
		pageBean.setList(list);
		return pageBean;
	}
}
