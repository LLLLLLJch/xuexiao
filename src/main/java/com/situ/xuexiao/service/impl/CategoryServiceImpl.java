package com.situ.xuexiao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.xuexiao.dao.CategoryDao;
import com.situ.xuexiao.pojo.Category;
import com.situ.xuexiao.service.ICategoryService;
@Service
public class CategoryServiceImpl implements ICategoryService{

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<Category> findCourseType(String ID) {
		return categoryDao.findCourseType(ID);
	}

	@Override
	public List<Category> findAddCourseType() {
		return categoryDao.findAddCourseType();
	}

	@Override
	public List<Category> findAskLeaveType() {
		return categoryDao.findAskLeaveType();
	}

	@Override
	public List<Category> findAllAdviceType() {
		return categoryDao.findAllAdviceType();
	}
}
