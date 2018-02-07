package com.situ.xuexiao.service;

import java.util.List;

import com.situ.xuexiao.common.SeverResponse;
import com.situ.xuexiao.pojo.Course;
import com.situ.xuexiao.vo.PageBean;

public interface ICourseService {

	List<Course> findAllCourse();

	Course findCourseByID(String id);

	List<Course> findOtherCourse(String iD);

	PageBean<Course> findAllCourses(int pageIndex, int pageSize);

	PageBean<Course> findCourseByCondition(Course course, int pageIndex, int pageSize);

	SeverResponse<Course> deleteCourse(String iD);

	SeverResponse<Course> updateCourse(Course course);

	SeverResponse<Course> addCourse(Course course);

	SeverResponse<Course> deleteAll(String[] selectedIds);

}
