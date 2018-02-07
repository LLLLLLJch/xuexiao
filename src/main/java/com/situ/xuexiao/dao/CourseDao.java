package com.situ.xuexiao.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.situ.xuexiao.pojo.Course;

public interface CourseDao {

	List<Course> findAllCourse();

	Course findCourseByID(String id);

	List<Course> findOtherCourse(String ID);

	int findCourseCount();

	List<Course> findAllCourses(@Param(value="index")int index, @Param(value="pageSize")int pageSize);

	int findCourseCountByCondition(Course course);

	List<Course> findCourseByCondition(Map<String, Object> map);

	int deleteCourse(String ID);

	int updateCourse(Course course);

	int addCourse(Course course);

}
