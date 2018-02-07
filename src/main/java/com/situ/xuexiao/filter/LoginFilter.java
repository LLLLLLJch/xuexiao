package com.situ.xuexiao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.situ.xuexiao.pojo.Student;
import com.situ.xuexiao.pojo.Teacher;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 HttpServletRequest req = (HttpServletRequest) request;
	       HttpServletResponse resp = (HttpServletResponse) response;
	       String uri = req.getRequestURI();
	       String requestPath = uri.substring(uri.lastIndexOf("/") + 1, uri.length());
	       if (	 requestPath.equals("checkImg")|| requestPath.equals("studentLogin.action")
	    		   || requestPath.equals("teacherLogin.action")
	    		   || requestPath.equals("login.jsp")
	    		   || requestPath.equals("goLoginPage.action")) {
	           //直接放行
	           chain.doFilter(request, response);
	       } else {
	    	   HttpSession session = req.getSession();
	    	   Student student = (Student) session.getAttribute("student");
	    	   Teacher teacher = (Teacher) session.getAttribute("teacher");
				if (student == null && teacher == null) {
					resp.sendRedirect(req.getContextPath() + "/login/goLoginPage.action");
					return;
				} else {
					chain.doFilter(request, response);
				}
	       }
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
