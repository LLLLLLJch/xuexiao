package com.situ.xuexiao.service;

import com.situ.xuexiao.common.SeverResponse;
import com.situ.xuexiao.pojo.Notice;
import com.situ.xuexiao.vo.FindNoticeByCondition;
import com.situ.xuexiao.vo.PageBean;

public interface INoticeService {

	PageBean<Notice> findStudentNotice(int pageIndex, int pageSize);

	PageBean<Notice> findTeacherNotice(int pageIndex, int pageSize);

	SeverResponse<Notice> addAllNotice(Notice newNotice);

	SeverResponse<Notice> addTeacherNotice(Notice newNotice);

	PageBean<Notice> findNoticeByCondition(int pageIndex, int pageSize, FindNoticeByCondition findNoticeByCondition);

	PageBean<Notice> findStudentNoticeByCondition(int pageIndex, int pageSize,
			FindNoticeByCondition findNoticeByCondition);

	SeverResponse<Notice> deleteNotice(String ID);

	SeverResponse<Notice> deleteAll(String[] selectedIds);

	Notice findNoticeByID(String ID);

}
