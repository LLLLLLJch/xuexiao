package com.situ.xuexiao.dao;

import java.util.List;
import java.util.Map;

import com.situ.xuexiao.pojo.Notice;
import com.situ.xuexiao.vo.FindNoticeByCondition;

public interface NoticeDao {

	int findAskLeaveCount();

	List<Notice> findAllAskLeavePageBean(Map<String, Object> map);

	int findTeacherNoticeCount();

	List<Notice> findTeacherNotice(Map<String, Object> map);

	int addAllNotice(Notice notice);

	int addTeacherNotice(Notice notice);

	int findNoticeCountByCondition(FindNoticeByCondition findNoticeByCondition);

	List<Notice> findNoticeByCondition(Map<String, Object> map);

	int findStudentNoticeCountByCondition(FindNoticeByCondition findNoticeByCondition);

	List<Notice> findStudentNoticeByCondition(Map<String, Object> map);

	int deleteNotice(String ID);

	Notice showNotice(String ID);

}
