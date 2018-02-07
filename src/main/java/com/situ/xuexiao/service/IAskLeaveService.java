package com.situ.xuexiao.service;

import java.util.List;

import com.situ.xuexiao.common.SeverResponse;
import com.situ.xuexiao.pojo.AskLeave;
import com.situ.xuexiao.vo.AskLeaveVO;
import com.situ.xuexiao.vo.PageBean;

public interface IAskLeaveService {

	List<AskLeave> findAskLeaveByTeacherID(String iD);

	PageBean<AskLeaveVO> findAskLeavePageBean(int pageIndex, int pageSize, String iD);

	SeverResponse<AskLeave> addTeacherAskLeave(AskLeave askLeave);

	SeverResponse<AskLeave> addStudentAskLeave(AskLeave askLeave);

	PageBean<AskLeaveVO> findAskLeavePageBeanByReleasePeople(int pageIndex, int pageSize, String name);

	SeverResponse<AskLeave> agreeAskLeave(String iD);

	SeverResponse<AskLeave> disAgreeAskLeave(String iD);

}
