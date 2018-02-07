package com.situ.xuexiao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.xuexiao.common.SeverResponse;
import com.situ.xuexiao.dao.BanJiDao;
import com.situ.xuexiao.dao.TeacherDao;
import com.situ.xuexiao.pojo.BanJi;
import com.situ.xuexiao.pojo.Student;
import com.situ.xuexiao.pojo.Teacher;
import com.situ.xuexiao.service.IBanJiService;
import com.situ.xuexiao.vo.PageBean;
import com.situ.xuexiao.vo.TeacherBanji;
@Service
public class BanJiServiceImpl implements IBanJiService{

	@Autowired
	private BanJiDao banjiDao;
	@Autowired
	private TeacherDao teacherDao;
	
	@Override
	public List<BanJi> findAllBanJi() {
		return banjiDao.findAllBanJi();
	}

	@Override
	public PageBean<Student> findBanJiPageBean(int pageIndex, int pageSize) {
		PageBean<Student> pageBean = new PageBean<Student>();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalCount = banjiDao.findBanJiCount();
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		int index = (pageIndex - 1) * pageSize;
		List<Student> list = banjiDao.findAllBanJiPageBean(index,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public BanJi findUpdateBanji(String ID) {
		return banjiDao.findUpdateBanji(ID);
	}

	@Override
	public SeverResponse<BanJi> updateBanji(BanJi banJi,String teachername) {
		BanJi banJi2 = banjiDao.findBanjiByID(banJi.getID());
		TeacherBanji teacherBanji = teacherDao.findOldMajorTeacher(banJi2.getSequenceNO());
		System.out.println(banJi2);
		System.out.println(teacherBanji);
		System.out.println(teachername);
		Teacher oldTeacher = teacherDao.findOldTeacher(teacherBanji.getTeacherID());
		Teacher teacher = teacherDao.showTeacher(teachername);
		System.out.println(oldTeacher);
		System.out.println(teacher);
		if(oldTeacher.getID().equals(teacher.getID())) {
			if(banjiDao.updateBanji(banJi)>0) {
				return SeverResponse.createSuccess("修改成功");
			}
		}else {
			if(banjiDao.updateBanji(banJi)>0 && teacherDao.updateTeacherBanji(teacher.getSequenceNO(),teacherBanji.getID())) {
				teacherDao.updateTeacherCategory(teacher.getSequenceNO());
				teacherDao.updateOldTeacherCategory(oldTeacher.getID());
				return SeverResponse.createSuccess("修改成功");
			}
		}
		return SeverResponse.createError("修改失败");
	}

	@Override
	public SeverResponse<BanJi> deleteBanji(String ID) {
		BanJi banJi = banjiDao.findUpdateBanji(ID);
		TeacherBanji teacherBanji = teacherDao.findOldMajorTeacher(banJi.getSequenceNO());
		Teacher teacher = teacherDao.findOldTeacher(teacherBanji.getTeacherID());
		if(banjiDao.deleteBanji(ID)>0) {
			teacherDao.updateOldTeacherCategory(teacher.getID());
			return SeverResponse.createSuccess("删除成功");
		}
		return SeverResponse.createError("删除失败");
	}

	@Override
	public SeverResponse<BanJi> deleteAll(String[] selectedIds) {
		int count = 0;
		for (String ID : selectedIds) {
			BanJi banJi = banjiDao.findUpdateBanji(ID);
			TeacherBanji teacherBanji = teacherDao.findOldMajorTeacher(banJi.getSequenceNO());
			Teacher teacher = teacherDao.findOldTeacher(teacherBanji.getTeacherID());
			banjiDao.deleteBanji(ID);
			teacherDao.updateOldTeacherCategory(teacher.getID());
			count++;
		}
		if(selectedIds.length == count) {
			return SeverResponse.createSuccess("删除成功");
		}
		return SeverResponse.createError("删除失败");
	}

	@Override
	public SeverResponse<BanJi> addBanji(BanJi banJi,String teachername) {
		if(banjiDao.addBanji(banJi)>0) {
			BanJi banJi2 = banjiDao.findBanjiByID(banJi.getID());
			String ID = UUID.randomUUID().toString().replaceAll("-", "");
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("teacherSequenceNO", Integer.parseInt(teachername));
			map.put("banjiSequenceNO", banJi2.getSequenceNO());
			map.put("ID", ID);
			if(teacherDao.addMajorTeacher(map)>0) {
				System.out.println(Integer.parseInt(teachername));
				teacherDao.updateTeacherCategory(Integer.parseInt(teachername));
				return SeverResponse.createSuccess("添加成功");
			}
		}
		return SeverResponse.createError("添加失败");
	}

	@Override
	public PageBean<BanJi> findBanJiByCondition(String name, int pageIndex, int pageSize) {
		PageBean<BanJi> pageBean = new PageBean<BanJi>();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalCount = banjiDao.findBanJiCountByCondition(name);
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		int index = (pageIndex - 1) * pageSize;
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("name", name);
		map.put("index", index);
		map.put("pageSize", pageSize);
		List<BanJi> list = banjiDao.findBanJiByCondition(map);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public BanJi findBanjiByID(String ID) {
		return banjiDao.findBanjiByID(ID);
	}

	@Override
	public List<BanJi> findOtherBanji(String ID) {
		return banjiDao.findOtherBanji(ID);
	}
}
