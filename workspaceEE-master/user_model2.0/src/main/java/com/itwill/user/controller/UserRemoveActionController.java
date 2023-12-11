package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwill.spring.mvc.Controller;
import com.itwill.user.UserService;

public class UserRemoveActionController implements Controller{

	private UserService userService;
	public UserRemoveActionController() {
		try {
			userService=new UserService();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) { 
		// 반드시 handleRequest 에 의해서 forwardPath 를 반환한다.
		String forwardPath ="";
		try {
			if (request.getMethod().equalsIgnoreCase("GET")) {
				forwardPath="redirect:user_main.do";
				return forwardPath;
			}
			HttpSession session = request.getSession(true);
			String sUserId =(String)session.getAttribute("sUserId");
			userService.remove(sUserId);
			session.invalidate();
			forwardPath="redirect:user_main.do";
			
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/user_error.jsp";
		}
		
		return forwardPath;
	}
	

}
