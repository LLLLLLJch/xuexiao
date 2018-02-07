package com.situ.xuexiao.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.xuexiao.common.SeverResponse;
import com.situ.xuexiao.dao.NoticeDao;
import com.situ.xuexiao.pojo.Notice;
import com.situ.xuexiao.service.INoticeService;
import com.situ.xuexiao.vo.AskLeaveVO;
import com.situ.xuexiao.vo.FindNoticeByCondition;
import com.situ.xuexiao.vo.PageBean;
@Service
public class NoticeServiceImpl implements INoticeService{

	@Autowired
	private NoticeDao noticeDao;

	@Override
	public PageBean<Notice> findStudentNotice(int pageIndex, int pageSize) {
		PageBean<Notice> pageBean = new PageBean<Notice>();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalCount = noticeDao.findAskLeaveCount();
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		int index = (pageIndex - 1) * pageSize;
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("index", index);
		map.put("pageSize", pageSize);
		List<Notice> list = noticeDao.findAllAskLeavePageBean(map);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public PageBean<Notice> findTeacherNotice(int pageIndex, int pageSize) {
		PageBean<Notice> pageBean = new PageBean<Notice>();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalCount = noticeDao.findTeacherNoticeCount();
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		int index = (pageIndex - 1) * pageSize;
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("index", index);
		map.put("pageSize", pageSize);
		List<Notice> list = noticeDao.findTeacherNotice(map);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public SeverResponse<Notice> addAllNotice(Notice newNotice) {
		if(noticeDao.addAllNotice(newNotice)>0) {
			return SeverResponse.createSuccess("发布成功");
		}
		return SeverResponse.createError("发布失败");
	}

	@Override
	public SeverResponse<Notice> addTeacherNotice(Notice newNotice) {
		if(noticeDao.addTeacherNotice(newNotice)>0) {
			return SeverResponse.createSuccess("发布成功");
		}
		return SeverResponse.createError("发布失败");
	}

	@Override
	public PageBean<Notice> findNoticeByCondition(int pageIndex, int pageSize,
			FindNoticeByCondition findNoticeByCondition) {
		PageBean<Notice> pageBean = new PageBean<Notice>();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalCount = noticeDao.findNoticeCountByCondition(findNoticeByCondition);
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		int index = (pageIndex - 1) * pageSize;
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("index", index);
		map.put("pageSize", pageSize);
		map.put("title", findNoticeByCondition.getTitle());
		map.put("startTime", findNoticeByCondition.getStartTime());
		map.put("endTime", findNoticeByCondition.getEndTime());
		List<Notice> list = noticeDao.findNoticeByCondition(map);
		System.out.println(list);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public PageBean<Notice> findStudentNoticeByCondition(int pageIndex, int pageSize,
			FindNoticeByCondition findNoticeByCondition) {
		PageBean<Notice> pageBean = new PageBean<Notice>();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalCount = noticeDao.findStudentNoticeCountByCondition(findNoticeByCondition);
		System.out.println(totalCount);
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		int index = (pageIndex - 1) * pageSize;
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("index", index);
		map.put("pageSize", pageSize);
		map.put("title", findNoticeByCondition.getTitle());
		map.put("startTime", findNoticeByCondition.getStartTime());
		map.put("endTime", findNoticeByCondition.getEndTime());
		List<Notice> list = noticeDao.findStudentNoticeByCondition(map);
		System.out.println(list);
		pageBean.setList(list);
		return pageBean;
	}
}