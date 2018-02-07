package com.situ.xuexiao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.xuexiao.common.SeverResponse;
import com.situ.xuexiao.dao.CourseDao;
import com.situ.xuexiao.pojo.Course;
import com.situ.xuexiao.service.ICourseService;
import com.situ.xuexiao.vo.PageBean;
@Service
public class CourseServiceImpl implements ICourseService{

	@Autowired
	private CourseDao courseDao;

	@Override
	public List<Course> findAllCourse() {
		return courseDao.findAllCourse();
	}

	@Override
	public Course findCourseByID(String id) {
		return courseDao.findCourseByID(id);
	}

	@Override
	public List<Course> findOtherCourse(String ID) {
		return courseDao.findOtherCourse(ID);
	}

	@Override
	public PageBean<Course> findAllCourses(int pageIndex, int pageSize) {
		PageBean<Course> pageBean = new PageBean<Course>();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalCount = courseDao.findCourseCount();
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		int index = (pageIndex - 1) * pageSize;
		List<Course> list = courseDao.findAllCourses(index,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public PageBean<Course> findCourseByCondition(Course course, int pageIndex, int pageSize) {
		PageBean<Course> pageBean = new PageBean<Course>();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalCount = courseDao.findCourseCountByCondition(course);
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		int index = (pageIndex - 1) * pageSize;
		Map<String, Object> map = new HashMap<String,Object>();
		System.out.println(course);
		map.put("name", course.getName());
		map.put("ID", course.getCategory().getID());
		map.put("index", index);
		map.put("pageSize", pageSize);
		List<Course> list = courseDao.findCourseByCondition(map);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public SeverResponse<Course> deleteCourse(String ID) {
		if(courseDao.deleteCourse(ID) > 0) {
			return SeverResponse.createSuccess("删除成功");
		}
		return SeverResponse.createError("删除失败");
	}

	@Override
	public SeverResponse<Course> updateCourse(Course course) {
		if(courseDao.updateCourse(course)>0) {
			return SeverResponse.createSuccess("修改成功");
		}
		return SeverResponse.createError("修改失败");
	}

	@Override
	public SeverResponse<Course> addCourse(Course course) {
		String ID = UUID.randomUUID().toString().replaceAll("-", "");
		course.setID(ID);
		if(courseDao.addCourse(course) > 0) {
			return SeverResponse.createSuccess("添加成功");
		}
		return SeverResponse.createError("添加失败");
	}

	@Override
	public SeverResponse<Course> deleteAll(String[] selectedIds) {
		int count = 0;
		for (String ID : selectedIds) {
			courseDao.deleteCourse(ID);
			count++;
		}
		if(selectedIds.length == count) {
			return SeverResponse.createSuccess("删除成功");
		}
		return SeverResponse.createError("删除失败");
	}
}
