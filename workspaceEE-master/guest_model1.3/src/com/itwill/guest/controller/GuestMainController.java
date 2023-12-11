package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.spring.mvc.Controller;

public class GuestMainController implements Controller { 
	
	@Override
	public String handleRequest(HttpServletRequest request , HttpServletResponse response) {
		String forwardPath = "forward:/WEB-INF/views/guest_main.jsp";
	
		return forwardPath;
	}
	
}
