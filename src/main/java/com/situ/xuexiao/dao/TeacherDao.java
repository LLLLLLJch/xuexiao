package com.situ.xuexiao.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Param;

import com.situ.xuexiao.common.SeverResponse;
import com.situ.xuexiao.pojo.BanJi;
import com.situ.xuexiao.pojo.Student;
import com.situ.xuexiao.pojo.Teacher;
import com.situ.xuexiao.vo.TeacherBanji;

public interface TeacherDao {

	List<Teacher> findClassTeacher();

	List<Teacher> findAllTeacher();

	int findTeacherCount();

	List<Teacher> findAllTeacher(@Param(value="index")int index, @Param(value="pageSize")int pageSize);

	Teacher findMajorTeacher(String ID);

	Teacher showTeacher(String ID);

	List<Teacher> findNotMajorTeacher();

	int addMajorTeacher(Map<String, Object> map);

	void updateTeacherCategory(int sequenceNO);

	TeacherBanji findOldMajorTeacher(Integer banjiID);

	Teacher findOldTeacher(Integer teacherID);

	boolean updateTeacherBanji(@Param(value="teacherID")Integer teacherID, @Param(value="ID")String ID);

	void updateOldTeacherCategory(String ID);

	int deleteTeacher(String ID);

	int addTeacher(Teacher teacher);

	int updateTeacher(Teacher teacher);

	int findTeacherCountByCondition(@Param(value="name")String name, @Param(value="gender")Integer gender);

	List<Teacher> findStudentByCondition(Map<String, Object> map);

	Teacher checkTeacher(@Param(value="name")String name, @Param(value="password")String password);


}
