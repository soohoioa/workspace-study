package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.spring.mvc.Controller;

public class UserMainController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) { 
		// 생성, 실행 모두 DispatcherServlet 가 한다. DispatcherServlet 가 "redirect"와 "forward" 한다. 		
		return "forward:/WEB-INF/views/user_main.jsp";
	}
	

}
