package com.situ.xuexiao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.xuexiao.common.SeverResponse;
import com.situ.xuexiao.dao.StudentDao;
import com.situ.xuexiao.pojo.Student;
import com.situ.xuexiao.service.IStudentService;
import com.situ.xuexiao.vo.FindStudentByCondition;
import com.situ.xuexiao.vo.PageBean;
@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	private StudentDao studentDao;
	
	@Override
	public PageBean<Student> findAllStudents(int pageIndex, int pageSize) {
		PageBean<Student> pageBean = new PageBean<Student>();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalCount = studentDao.findStudentCount();
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		int index = (pageIndex - 1) * pageSize;
		List<Student> list = studentDao.findAllStudents(index,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public Student findUpdateStudent(String id) {
		return studentDao.findUpdateStudent(id);
	}

	@Override
	public SeverResponse<Student> updateStudent(Student student) {
		if(studentDao.updateStudent(student)>0) {
			return SeverResponse.createSuccess("修改成功");
		}
		return SeverResponse.createError("修改失败");
	}

	@Override
	public PageBean<Student> findStudentByCondition(FindStudentByCondition findStudentByCondition) {
		PageBean<Student> pageBean = new PageBean<Student>();
		pageBean.setPageIndex(findStudentByCondition.getPageIndex());
		pageBean.setPageSize(findStudentByCondition.getPageSize());
		int totalCount = studentDao.findStudentCountByCondition(findStudentByCondition.getName(),findStudentByCondition.getGender());
		if(totalCount == 0) {
			totalCount = 1;
		}
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / findStudentByCondition.getPageSize());
		pageBean.setTotalPage(totalPage);
		int index = (findStudentByCondition.getPageIndex() - 1) * findStudentByCondition.getPageSize();
		Map<String,Object> map = new HashMap<>();
		map.put("name", findStudentByCondition.getName());
		map.put("gender", findStudentByCondition.getGender());
		map.put("index", index);
		map.put("pageSize", findStudentByCondition.getPageSize());
		if(findStudentByCondition.getName().equals("") && findStudentByCondition.getGender() == 0) {
			List<Student> list = studentDao.findAllStudents(index, findStudentByCondition.getPageSize());
			pageBean.setList(list);
		}else {
			List<Student> list = studentDao.findStudentByCondition(map);
			pageBean.setList(list);
		}
		return pageBean;
	}

	@Override
	public SeverResponse<Student> deleteStudent(String ID) {
		if(studentDao.deleteStudent(ID)>0) {
			return SeverResponse.createSuccess("删除成功");
		}
		return SeverResponse.createError("删除失败");
	}

	@Override
	public SeverResponse<Student> deleteAll(String[] selectedIds) {
		int count = 0;
		for (String ID : selectedIds) {
			studentDao.deleteStudent(ID);
			count++;
		}
		if(selectedIds.length == count) {
			return SeverResponse.createSuccess("删除成功");
		}
		return SeverResponse.createError("删除失败");
	}

	@Override
	public SeverResponse<Student> addStudent(Student student) {
		if(studentDao.addStudent(student)>0) {
			return SeverResponse.createError("添加成功");
		}
		return SeverResponse.createError("添加失败");
	}

	@Override
	public int findStudentBanji(Integer sequenceNO) {
		return studentDao.findStudentBanji(sequenceNO);
	}

	@Override
	public Student checkUser(String name, String password) {
		return studentDao.checkStudent(name,password);
	}

}
