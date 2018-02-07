package com.situ.xuexiao.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.situ.xuexiao.pojo.Student;

public interface StudentDao {

	public List<Student> findAllStudents(@Param(value="index")int index,@Param(value="pageSize")int pageSize);

	public int findStudentCount();

	public int findStudentCountByCondition(@Param(value="name")String name, @Param(value="gender")int gender);

	public List<Student> findStudentByCondition(Map<String, Object> map);

	public Student findUpdateStudent(String id);

	public int updateStudent(Student student);

	public int deleteStudent(String ID);

	public int addStudent(Student student);

	public int findStudentBanji(Integer sequenceNO);

	public Student checkStudent(@Param(value="name")String name, @Param(value="password")String password);

}
