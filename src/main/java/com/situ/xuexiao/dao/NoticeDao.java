package com.situ.xuexiao.dao;

import java.util.List;
import java.util.Map;

import com.situ.xuexiao.pojo.Notice;

public interface NoticeDao {

	int findAskLeaveCount();

	List<Notice> findAllAskLeavePageBean(Map<String, Object> map);

	int findTeacherNoticeCount();

	List<Notice> findTeacherNotice(Map<String, Object> map);

	int addAllNotice(Notice notice);

	int addTeacherNotice(Notice notice);

}
