package com.situ.xuexiao.controller;

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
import com.situ.xuexiao.pojo.Notice;
import com.situ.xuexiao.pojo.Teacher;
import com.situ.xuexiao.service.INoticeService;
import com.situ.xuexiao.vo.FindNoticeByCondition;
import com.situ.xuexiao.vo.PageBean;

@Controller
@RequestMapping("noticeIndex")
public class NoticeController {

	@Autowired
	private INoticeService noticeService;
	
	@RequestMapping("goAddPage")
	public String goAddPage() {
		return "notice_add";
	}
	
	@RequestMapping("findStudentNotice")
	public String findStudentNotice(Model model,String pageIndexStr,String pageSizeStr) {
		int pageIndex = 1;
		int pageSize = 12;
		if (pageIndexStr != null && pageIndexStr.equals("")) {
			pageIndex = Integer.parseInt(pageIndexStr);
		}
		if (pageSizeStr != null && pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageBean<Notice> pageBean = noticeService.findStudentNotice(pageIndex, pageSize);
		model.addAttribute("pageBean", pageBean);
		return "notice_list";
	}
	
	@RequestMapping("findTeacherNotice")
	public String findTeacherNotice(Model model,String pageIndexStr,String pageSizeStr) {
		int pageIndex = 1;
		int pageSize = 12;
		if (pageIndexStr != null && !pageIndexStr.equals("")) {
			pageIndex = Integer.parseInt(pageIndexStr);
		}
		if (pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageBean<Notice> pageBean = noticeService.findTeacherNotice(pageIndex, pageSize);
		model.addAttribute("pageBean", pageBean);
		return "notice_list";
	}
	
	@RequestMapping("addNotice")
	@ResponseBody
	public SeverResponse<Notice> addNotice(HttpServletRequest request,Notice notice,String level) {
		String ID = UUID.randomUUID().toString().replaceAll("-", "");
		Date postedDate = new Date();
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		//所有人可见
		Notice newNotice = new Notice(ID, notice.getContent(), notice.getTitle(), notice.getPicture(), postedDate, teacher);
		if(level.equals("all")) {
			return noticeService.addAllNotice(newNotice);
		}
		//仅教师可见
		return noticeService.addTeacherNotice(newNotice);
	}
	
	@RequestMapping("findNoticeByCondition")
	public String findNoticeByCondition(HttpServletRequest request,Model model,FindNoticeByCondition findNoticeByCondition,String pageIndexStr,String pageSizeStr) {
		System.out.println(findNoticeByCondition);
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
			System.out.println("22222222222");
			PageBean<Notice> pageBean = noticeService.findStudentNoticeByCondition(pageIndex, pageSize,findNoticeByCondition);
			model.addAttribute("pageBean", pageBean);
			return "notice_list";
		}
		System.out.println("111111111111");
		PageBean<Notice> pageBean = noticeService.findNoticeByCondition(pageIndex, pageSize,findNoticeByCondition);
		model.addAttribute("pageBean", pageBean);
		return "notice_list";
	}
}
