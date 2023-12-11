package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.spring.mvc.Controller;

public class GuestErrorController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath = 
				"forward:/WEB-INF/views/guest_error.jsp";// TODO Auto-generated method stub
		return forwardPath;
	}

}
