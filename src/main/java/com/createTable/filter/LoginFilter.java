package com.createTable.filter;

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

import com.createTable.pojo.Member;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 HttpServletRequest req = (HttpServletRequest) request;
	       HttpServletResponse resp = (HttpServletResponse) response;
	       String uri = req.getRequestURI();
	       String requestPath = uri.substring(uri.lastIndexOf("/") + 1, uri.length());
	       if (	 requestPath.equals("login.action")
	    		   || requestPath.equals("login.jsp")
	    		   || requestPath.equals("goLoginPage.action")) {
	           //直接放行
	           chain.doFilter(request, response);
	       } else {
	    	   HttpSession session = req.getSession();
	    	   Member member = (Member) session.getAttribute("member");
				if (member == null) {
					resp.sendRedirect(req.getContextPath() + "/loginIndex/goLoginPage.action");
					return;
				} else {
					chain.doFilter(request, response);
				}
	       }
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
