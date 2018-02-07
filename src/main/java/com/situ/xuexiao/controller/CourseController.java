package com.situ.xuexiao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.xuexiao.common.SeverResponse;
import com.situ.xuexiao.pojo.Category;
import com.situ.xuexiao.pojo.Course;
import com.situ.xuexiao.service.ICategoryService;
import com.situ.xuexiao.service.ICourseService;
import com.situ.xuexiao.vo.PageBean;

@Controller
@RequestMapping("courseIndex")
public class CourseController {

	@Autowired
	private ICourseService courseService;
	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping("goAddPage")
	public String goAddPage() {
		return "course_add";
	}
	
	@RequestMapping("findAllCourses")
	public String StudentList(Model model, String pageIndexStr, String pageSizeStr) {
		int pageIndex = 1;
		int pageSize = 12;
		if (pageIndexStr != null && pageIndexStr.equals("")) {
			pageIndex = Integer.parseInt(pageIndexStr);
		}
		if (pageSizeStr != null && pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageBean<Course> pageBean = courseService.findAllCourses(pageIndex, pageSize);
		model.addAttribute("pageBean", pageBean);
		return "course_list";
	}
	
	@RequestMapping("findCourseByCondition")
	public String findCourseByCondition(Model model,Course course,String pageIndexStr,String pageSizeStr) {
		int pageIndex = 1;
		if (pageIndexStr != null && !pageIndexStr.equals("")) {
			pageIndex = Integer.parseInt(pageIndexStr);
		}
		int pageSize = 12;
		if (pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageBean<Course> pageBean = courseService.findCourseByCondition(course,pageIndex,pageSize);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("course", course);
		return "course_list";
	}
	
	@RequestMapping("deleteCourse")
	@ResponseBody
	public SeverResponse<Course> deleteCourse(String ID) {
		return courseService.deleteCourse(ID);
	}
	
	@RequestMapping("findUpdateCourse")
	public String findUpdateCourse(Model model,String ID) {
		Course course = courseService.findCourseByID(ID);
		model.addAttribute("course", course);
		List<Category> list = categoryService.findCourseType(course.getCategory().getID());
		model.addAttribute("list", list);
		return "course_update";
	}
	
	@RequestMapping("updateCourse")
	@ResponseBody
	public SeverResponse<Course> updateupdateCourse(Course course) {
		return courseService.updateCourse(course);
	}
	
	@RequestMapping("showCourse")
	public String showCourse(Model model,String ID) {
		Course course = courseService.findCourseByID(ID);
		model.addAttribute("course", course);
		return "course_show";
	}
	
	@RequestMapping("findAddCourse")
	@ResponseBody
	public List<Course> findAddCourse() {
		return courseService.findAllCourse();
	}
	
	@RequestMapping("addCourse")
	@ResponseBody
	public SeverResponse<Course> addCourse(Course course) {
		return courseService.addCourse(course);
	}

	@RequestMapping("deleteAll")
	@ResponseBody
	public SeverResponse<Course> deleteAll(String[] selectedIds) {
		return courseService.deleteAll(selectedIds);
	}
}
