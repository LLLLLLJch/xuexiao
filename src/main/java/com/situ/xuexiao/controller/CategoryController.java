package com.situ.xuexiao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.xuexiao.pojo.Category;
import com.situ.xuexiao.service.ICategoryService;

@Controller
@RequestMapping("categoryIndex")
public class CategoryController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping("findAddCourseType")
	@ResponseBody
	public List<Category> findAddCourseType() {
		return categoryService.findAddCourseType();
	}
	
	@RequestMapping("findAskLeaveType")
	@ResponseBody
	public List<Category> findAskLeaveType() {
		return categoryService.findAskLeaveType();
	}
}
