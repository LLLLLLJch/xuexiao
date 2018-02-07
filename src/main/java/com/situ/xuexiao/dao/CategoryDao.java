package com.situ.xuexiao.dao;

import java.util.List;

import com.situ.xuexiao.pojo.Category;

public interface CategoryDao {

	List<Category> findCourseType(String ID);

	List<Category> findAddCourseType();

	List<Category> findAskLeaveType();

}
