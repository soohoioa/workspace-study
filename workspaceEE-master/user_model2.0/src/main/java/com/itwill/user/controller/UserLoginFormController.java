package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.spring.mvc.Controller;

public class UserLoginFormController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) { 
				
		return "forward:/WEB-INF/views/user_login_form.jsp";
	}
	

}
