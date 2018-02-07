package com.situ.xuexiao.service;

import java.util.List;

import com.situ.xuexiao.common.SeverResponse;
import com.situ.xuexiao.pojo.BanJi;
import com.situ.xuexiao.pojo.Teacher;
import com.situ.xuexiao.vo.FindStudentByCondition;
import com.situ.xuexiao.vo.PageBean;
import com.situ.xuexiao.vo.TeacherBanji;

public interface ITeacherService {

	List<Teacher> findClassTeacher();

	PageBean<Teacher> findAllTeacer(int pageIndex, int pageSize);

	Teacher findMajorTeacher(String ID);

	Teacher showTeacher(String ID);

	List<Teacher> findNotMajorTeacher();

	SeverResponse<BanJi> deleteTeacher(String iD);

	SeverResponse<Teacher> addTeacher(Teacher teacher);

	SeverResponse<Teacher> updateTeacher(Teacher teacher);

	PageBean<Teacher> findTeacherByCondition(FindStudentByCondition findStudentByCondition);

	SeverResponse<Teacher> deleteAll(String[] selectedIds);

	Teacher checkUser(String name, String password);

	TeacherBanji findOldMajorTeacher(Integer sequenceNO);

	Teacher findOldTeacher(Integer teacherID);

}
