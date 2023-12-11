package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.spring.mvc.Controller;

public class UserLogoutActionController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) { 
		
		String forwardPath ="";
		
		request.getSession().invalidate(); // 세션 무효화 작업 필수
		forwardPath="redirect:user_main.do";
		
		return forwardPath;
	}
	

}
