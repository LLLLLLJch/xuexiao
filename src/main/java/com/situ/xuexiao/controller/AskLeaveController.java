package com.situ.xuexiao.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.xuexiao.common.SeverResponse;
import com.situ.xuexiao.pojo.AskLeave;
import com.situ.xuexiao.pojo.Student;
import com.situ.xuexiao.pojo.Teacher;
import com.situ.xuexiao.service.IAskLeaveService;
import com.situ.xuexiao.service.ITeacherService;
import com.situ.xuexiao.vo.AskLeaveVO;
import com.situ.xuexiao.vo.PageBean;
import com.situ.xuexiao.vo.TeacherBanji;

@Controller
@RequestMapping("askLeaveIndex")
public class AskLeaveController {

	@Autowired
	private IAskLeaveService askLeaveService;
	@Autowired
	private ITeacherService teacherService;

	@RequestMapping("goAddPage")
	public String goAddPage() {
		return "askLeave_add";
	}

	@RequestMapping("addAskLeave")
	@ResponseBody
	public SeverResponse<AskLeave> addAskLeave(AskLeave askLeave, HttpServletRequest request) {
		String ID = UUID.randomUUID().toString().replaceAll("-", "");
		Date postDate = new Date();
		HttpSession session = request.getSession();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		int num = (int) session.getAttribute("num");
		if (num == 1) {
			Student student = (Student) session.getAttribute("student");
			TeacherBanji teacherBanji = teacherService.findOldMajorTeacher(student.getBanji().getSequenceNO());
			askLeave.setID(ID);
			askLeave.setPostedDate(postDate);
			askLeave.setReleasePeople(student.getName());
			Teacher teacher = new Teacher();
			teacher.setSequenceNO(teacherBanji.getTeacherID());
			askLeave.setRecipient(teacher);
			return askLeaveService.addStudentAskLeave(askLeave);
		}
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		askLeave.setID(ID);
		askLeave.setPostedDate(postDate);
		askLeave.setReleasePeople(teacher.getName());
		return askLeaveService.addTeacherAskLeave(askLeave);
	}

	@RequestMapping("findNoDeal")
	public String findNoDeal(Model model, String ID, String pageIndexStr, String pageSizeStr) {
		int pageIndex = 1;
		int pageSize = 12;
		if (pageIndexStr != null && !pageIndexStr.equals("")) {
			pageIndex = Integer.parseInt(pageIndexStr);
		}
		if (pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageBean<AskLeaveVO> pageBean = askLeaveService.findAskLeavePageBean(pageIndex, pageSize, ID);
		model.addAttribute("pageBean", pageBean);
		return "askLeave_deal";
	}
	
	@RequestMapping("findMineAskLeave")
	public String findMineAskLeave(String ID,HttpServletRequest request,Model model,String pageIndexStr, String pageSizeStr) {
		int pageIndex = 1;
		int pageSize = 12;
		if (pageIndexStr != null && !pageIndexStr.equals("")) {
			pageIndex = Integer.parseInt(pageIndexStr);
		}
		if (pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		HttpSession session = request.getSession();
		int num = (int) session.getAttribute("num");
		if(num == 1) {
			Student student = (Student) session.getAttribute("student");
			PageBean<AskLeaveVO> pageBean = askLeaveService.findAskLeavePageBeanByReleasePeople(pageIndex, pageSize,student.getName());
			model.addAttribute("pageBean", pageBean);
			return "askLeave_record";
		}
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		PageBean<AskLeaveVO> pageBean = askLeaveService.findAskLeavePageBeanByReleasePeople(pageIndex, pageSize,teacher.getName());
		model.addAttribute("pageBean", pageBean);
		return "askLeave_record";
	}
	
	@RequestMapping("agreeAskLeave")
	@ResponseBody
	public SeverResponse<AskLeave> agreeAskLeave(String ID) {
		return askLeaveService.agreeAskLeave(ID);
	}
	
	@RequestMapping("disAgreeAskLeave")
	@ResponseBody
	public SeverResponse<AskLeave> disAgreeAskLeave(String ID) {
		return askLeaveService.disAgreeAskLeave(ID);
	}
}
