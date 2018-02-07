package com.situ.xuexiao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.xuexiao.common.SeverResponse;
import com.situ.xuexiao.dao.TeacherDao;
import com.situ.xuexiao.pojo.BanJi;
import com.situ.xuexiao.pojo.Teacher;
import com.situ.xuexiao.service.ITeacherService;
import com.situ.xuexiao.vo.FindStudentByCondition;
import com.situ.xuexiao.vo.PageBean;
import com.situ.xuexiao.vo.TeacherBanji;
@Service
public class TeacherServiceImpl implements ITeacherService{

	@Autowired
	private TeacherDao teacherDao;

	@Override
	public List<Teacher> findClassTeacher() {
		return teacherDao.findClassTeacher();
	}

	@Override
	public PageBean<Teacher> findAllTeacer(int pageIndex, int pageSize) {
		PageBean<Teacher> pageBean = new PageBean<Teacher>();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalCount = teacherDao.findTeacherCount();
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		int index = (pageIndex - 1) * pageSize;
		List<Teacher> list = teacherDao.findAllTeacher(index,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public Teacher findMajorTeacher(String ID) {
	 	return teacherDao.findMajorTeacher(ID);
	}

	@Override
	public Teacher showTeacher(String ID) {
		return teacherDao.showTeacher(ID);
	}

	@Override
	public List<Teacher> findNotMajorTeacher() {
		return teacherDao.findNotMajorTeacher();
	}

	@Override
	public SeverResponse<BanJi> deleteTeacher(String ID) {
		if(teacherDao.deleteTeacher(ID)>0) {
			return SeverResponse.createError("删除成功");
		}
		return SeverResponse.createError("删除失败");
	}

	@Override
	public SeverResponse<Teacher> addTeacher(Teacher teacher) {
		if(teacherDao.addTeacher(teacher) > 0){
			return SeverResponse.createSuccess("添加成功");
		}
		return SeverResponse.createError("添加失败");
	}

	@Override
	public SeverResponse<Teacher> updateTeacher(Teacher teacher) {
		if(teacherDao.updateTeacher(teacher)>0) {
			return SeverResponse.createSuccess("修改成功");
		}
		return SeverResponse.createError("修改失败");
	}

	@Override
	public PageBean<Teacher> findTeacherByCondition(FindStudentByCondition findStudentByCondition) {
		PageBean<Teacher> pageBean = new PageBean<Teacher>();
		pageBean.setPageIndex(findStudentByCondition.getPageIndex());
		pageBean.setPageSize(findStudentByCondition.getPageSize());
		int totalCount = teacherDao.findTeacherCountByCondition(findStudentByCondition.getName(),findStudentByCondition.getGender());
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
			List<Teacher> list = teacherDao.findAllTeacher(index, findStudentByCondition.getPageSize());
			pageBean.setList(list);
		}else {
			List<Teacher> list = teacherDao.findStudentByCondition(map);
			pageBean.setList(list);
		}
		return pageBean;
	}

	@Override
	public SeverResponse<Teacher> deleteAll(String[] selectedIds) {
		int count = 0;
		for (String ID : selectedIds) {
			teacherDao.deleteTeacher(ID);
			count++;
		}
		if(selectedIds.length == count) {
			return SeverResponse.createSuccess("删除成功");
		}
		return SeverResponse.createError("删除失败");
	}

	@Override
	public Teacher checkUser(String name, String password) {
		return teacherDao.checkTeacher(name,password);
	}

	@Override
	public TeacherBanji findOldMajorTeacher(Integer sequenceNO) {
		return teacherDao.findOldMajorTeacher(sequenceNO);
	}

	@Override
	public Teacher findOldTeacher(Integer teacherID) {
		return teacherDao.findOldTeacher(teacherID);
	}
}
