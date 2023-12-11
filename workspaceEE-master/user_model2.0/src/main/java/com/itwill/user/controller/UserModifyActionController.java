package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwill.spring.mvc.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserModifyActionController implements Controller{

	private UserService userService;
	public UserModifyActionController() {
		try {
			userService=new UserService();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) { 
		
		String forwardPath="";
		try {
			if(request.getMethod().equalsIgnoreCase("GET")){
				forwardPath="redirect:user_main.do";
				return forwardPath;
			}
			
			// HttpSession session = request.getSession(true);
			
			String sUserId = (String)request.getSession().getAttribute("sUserId");			
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			int rowCount=userService.update(new User(sUserId,password,name,email));
			forwardPath="redirect:user_view.do"; // 여기서 포워드도 가능.
			
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/user_error.jsp";
		}
			
		return forwardPath;
	}
	

}
