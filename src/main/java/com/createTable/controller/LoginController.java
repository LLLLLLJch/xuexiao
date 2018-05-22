package com.createTable.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.createTable.pojo.Member;

@Controller
@RequestMapping("/loginIndex")
public class LoginController {

	@RequestMapping("/goLoginPage")
	public String goLoginPage() {
		return "login";
	}
	@RequestMapping("/login")
	public static String main(String[] args,HttpServletRequest request,Member member,String name) {
		member.setUseName(name);
		if(member.getUseName().equals("admin") && member.getPassword().equals("111111")){
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			return "redirect:http://localhost:8082/xuexiao/";
		}
		return "fail";
	}
	/*public String studentLogin(HttpServletRequest request,Member member,String name) {
		member.setUseName(name);
		if(member.getUseName().equals("admin") && member.getPassword().equals("111111")){
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			return "redirect:http://localhost:8082/xuexiao/";
		}
		return "fail";
	}*/
}
