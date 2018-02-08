package com.situ.xuexiao.service;

import java.util.List;

import com.situ.xuexiao.pojo.Category;

public interface ICategoryService {

	List<Category> findCourseType(String string);

	List<Category> findAddCourseType();

	List<Category> findAskLeaveType();

	List<Category> findAllAdviceType();

}
