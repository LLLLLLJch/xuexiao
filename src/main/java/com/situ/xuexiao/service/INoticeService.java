package com.situ.xuexiao.service;

import com.situ.xuexiao.common.SeverResponse;
import com.situ.xuexiao.pojo.Notice;
import com.situ.xuexiao.vo.PageBean;

public interface INoticeService {

	PageBean<Notice> findStudentNotice(int pageIndex, int pageSize);

	PageBean<Notice> findTeacherNotice(int pageIndex, int pageSize);

	SeverResponse<Notice> addAllNotice(Notice newNotice);

	SeverResponse<Notice> addTeacherNotice(Notice newNotice);

}
