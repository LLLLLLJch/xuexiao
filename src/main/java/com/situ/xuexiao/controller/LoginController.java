package com.situ.xuexiao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.xuexiao.pojo.Student;
import com.situ.xuexiao.pojo.Teacher;
import com.situ.xuexiao.service.IStudentService;
import com.situ.xuexiao.service.ITeacherService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private IStudentService studentService;
	@Autowired
	private ITeacherService teacherService;
	
	@RequestMapping("/goLoginPage")
	public String goLoginPage() {
		return "login";
	}
	
	@RequestMapping("/studentLogin")
	public String studentLogin(HttpServletRequest request,Student stu) {
		Student student = studentService.checkUser(stu.getName(),stu.getPassword());
		if(student != null){
			HttpSession session = request.getSession();
			session.setAttribute("student", student);
			session.setAttribute("num", 1);
			return "redirect:http://localhost:8082/xuexiao/";
		}
		return "fail";
	}
	
	@RequestMapping("/teacherLogin")
	public String teacherLogin(HttpServletRequest request,Teacher tea) {
		Teacher teacher = teacherService.checkUser(tea.getName(),tea.getPassword());
		if(teacher != null){
			HttpSession session = request.getSession();
			session.setAttribute("teacher", teacher);
			session.setAttribute("num", 2);
			return "redirect:http://localhost:8082/xuexiao/";
		}
		return "fail";
	}
	@RequestMapping("/goexit")
	public String goexit(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return "redirect:/login/goLoginPage.action";
		
	}
}
