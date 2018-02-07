package com.situ.xuexiao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.xuexiao.common.SeverResponse;
import com.situ.xuexiao.dao.AskLeaveDao;
import com.situ.xuexiao.pojo.AskLeave;
import com.situ.xuexiao.service.IAskLeaveService;
import com.situ.xuexiao.vo.AskLeaveVO;
import com.situ.xuexiao.vo.PageBean;
@Service
public class AskLeaveServiceImpl implements IAskLeaveService{

	@Autowired
	private AskLeaveDao askLeaveDao;

	@Override
	public List<AskLeave> findAskLeaveByTeacherID(String ID) {
		return askLeaveDao.findAskLeaveByTeacherID(Integer.parseInt(ID));
	}

	@Override
	public PageBean<AskLeaveVO> findAskLeavePageBean(int pageIndex, int pageSize, String ID) {
		PageBean<AskLeaveVO> pageBean = new PageBean<AskLeaveVO>();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalCount = askLeaveDao.findAskLeaveCount(ID);
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		int index = (pageIndex - 1) * pageSize;
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("ID", ID);
		map.put("index", index);
		map.put("pageSize", pageSize);
		List<AskLeaveVO> list = askLeaveDao.findAllAskLeavePageBean(map);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public SeverResponse<AskLeave> addTeacherAskLeave(AskLeave askLeave) {
		if(askLeaveDao.addTeacherAskLeave(askLeave)>0) {
			return SeverResponse.createSuccess("申请成功");
		}
		return SeverResponse.createError("申请失败");
	}

	@Override
	public SeverResponse<AskLeave> addStudentAskLeave(AskLeave askLeave) {
		if(askLeaveDao.addStudentAskLeave(askLeave)>0) {
			return SeverResponse.createSuccess("申请成功");
		}
		return SeverResponse.createError("申请失败");
	}

	@Override
	public PageBean<AskLeaveVO> findAskLeavePageBeanByReleasePeople(int pageIndex, int pageSize, String name) {
		PageBean<AskLeaveVO> pageBean = new PageBean<AskLeaveVO>();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalCount = askLeaveDao.findAskLeaveCountByReleasePeople(name);
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		int index = (pageIndex - 1) * pageSize;
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("name", name);
		map.put("index", index);
		map.put("pageSize", pageSize);
		List<AskLeaveVO> list = askLeaveDao.findAllAskLeavePageBeanByReleasePeople(map);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public SeverResponse<AskLeave> agreeAskLeave(String ID) {
		if(askLeaveDao.agreeAskLeave(ID)>0) {
			return SeverResponse.createSuccess("处理成功");
		}
		return SeverResponse.createError("处理失败");
	}

	@Override
	public SeverResponse<AskLeave> disAgreeAskLeave(String ID) {
		if(askLeaveDao.disAgreeAskLeave(ID)>0) {
			return SeverResponse.createSuccess("处理成功");
		}
		return SeverResponse.createError("处理失败");
	}
}
