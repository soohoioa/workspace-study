package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwill.spring.mvc.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserLoginActionController implements Controller{
	private UserService userService;
	public UserLoginActionController() {
		try {
			userService=new UserService();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public String handleRequest(HttpServletRequest request, 
								HttpServletResponse response) {
		String forwardPath="";
		try {
			if(request.getMethod().equalsIgnoreCase("GET")) {
				forwardPath="redirect:user_login_form.do";
				return forwardPath;
			}
			String userId=request.getParameter("userId");
			String password=request.getParameter("password");
			int result=
					userService.login(userId, password);
			if(result==0) {
				//0:아이디존재안함
				String msg1=userId+" 는 존재하지않는 아이디입니다.";
				request.setAttribute("msg1",msg1);
				request.setAttribute("fuser", new User(userId,password,"",""));
				forwardPath="forward:/WEB-INF/views/user_login_form.jsp";
			}else if(result==1) {
				//1:패쓰워드 불일치
				String msg2="패쓰워드가 일치하지않습니다.";
				request.setAttribute("msg2",msg2);
				request.setAttribute("fuser", new User(userId,password,"",""));
				forwardPath="forward:/WEB-INF/views/user_login_form.jsp";
			}else if(result==2) {
				//2:로그인성공
				HttpSession session=request.getSession(true);
				session.setAttribute("sUserId", userId);
				forwardPath="redirect:user_main.do";
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/user_error.jsp";
		}
		
		return forwardPath;
	}
	

}
