<%@page import="com.itwill.user.User"%>
<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="user_login_check.jspf" %>

<%
/*
		0.login 여부체크 -> 따로 만들어놔서 할필요 없다.
		1.GET방식이면 user_main.jsp redirection
		2.요청객체인코딩설정 -> 필터설정헤서 할필요없다.
		3.파라메타받기(password,name,email)
		4.세션의 sUserId와 파라메타(password,name,email) 로 User객체생성후  UserService.update 메쏘드호출
		5.성공:user_view.jsp redirection
		  실패:user_error.jsp 
		  
		  rowCount 가 0이면 에러임. try catch 로 전체를 감싸서 Exception 잡기
	*/
	
	try {

		if (request.getMethod().equalsIgnoreCase("GET")) {
			response.sendRedirect("user_main.jsp");
			return;
		}

		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		UserService userService = new UserService();

		int rowCount = userService.update(new User(sUserId, password, name, email));
		
		// rowCount = 0;
		if(rowCount == 0) {
			throw new Exception("개발자야근");
		}
		response.sendRedirect("user_view.jsp");

	} catch (Exception e) {
		e.printStackTrace();
		response.sendRedirect("user_error.jsp");
	}
%>