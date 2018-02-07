package com.situ.xuexiao.dao;

import java.util.List;
import java.util.Map;

import com.situ.xuexiao.pojo.AskLeave;
import com.situ.xuexiao.vo.AskLeaveVO;

public interface AskLeaveDao {

	List<AskLeave> findAskLeaveByTeacherID(int ID);

	int findAskLeaveCount(String ID);

	List<AskLeaveVO> findAllAskLeavePageBean(Map<String, Object> map);

	int addTeacherAskLeave(AskLeave askLeave);

	int addStudentAskLeave(AskLeave askLeave);

	int findAskLeaveCountByReleasePeople(String name);

	List<AskLeaveVO> findAllAskLeavePageBeanByReleasePeople(Map<String, Object> map);

	int agreeAskLeave(String ID);

	int disAgreeAskLeave(String ID);

}
