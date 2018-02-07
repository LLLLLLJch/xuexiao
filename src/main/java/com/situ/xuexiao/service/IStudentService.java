package com.situ.xuexiao.service;

import com.situ.xuexiao.common.SeverResponse;
import com.situ.xuexiao.pojo.Student;
import com.situ.xuexiao.vo.FindStudentByCondition;
import com.situ.xuexiao.vo.PageBean;

public interface IStudentService {

	PageBean<Student> findAllStudents(int pageIndex, int pageSize);

	Student findUpdateStudent(String ID);

	SeverResponse<Student> updateStudent(Student student);

	PageBean<Student> findStudentByCondition(FindStudentByCondition findStudentByCondition);

	SeverResponse<Student> deleteStudent(String iD);

	SeverResponse<Student> deleteAll(String[] selectedIds);

	SeverResponse<Student> addStudent(Student student);

	int findStudentBanji(Integer sequenceNO);

	Student checkUser(String name, String password);

}
