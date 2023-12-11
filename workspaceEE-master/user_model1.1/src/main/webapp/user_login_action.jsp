
<%@page import="com.itwill.user.User"%>
<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%
/*
	0  . GET방식요청일때 user_login_form.jsp로 redirection
	1  . 요청객체 인코딩설정 -> 필터설정해서 굳이 할필요 없다.
	2  . 파라메타 받기
	3  . UserService객체생성
	4  . UserService.login() 메쏘드실행
	*/
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("user_login_form.jsp");
		return;
	}
	
	String userId = request.getParameter("userId");
	String password = request.getParameter("password");
	
	UserService userService = new UserService();

	/*
	 * 회원로그인
	 * 
	 * 0:아이디존재안함
	 * 1:패쓰워드 불일치
	 * 2:로그인성공(세션)
	 */
	int result = userService.login(userId, password);

	if (result == 0) {
		
		// 0:아이디존재안함
		String msg1 = userId + "는 존재하지 않는 아이디 입니다.";
		/***************** case1 script **************
		out.println("<script>");
		out.println(" 	alert('" + msg1 + "');");
		out.println(" 	location.href='user_login_form.jsp';");
		out.println("</script>");
		*********************************************/
		
		/************** case2 forward ****************/
		request.setAttribute("msg1", msg1);
		request.setAttribute("fuser", new User(userId, password, "", ""));
		
		RequestDispatcher rd = request.getRequestDispatcher("user_login_form.jsp");
		rd.forward(request, response);
		
		/*********************************************/
		
	} else if (result == 1) {
		
		// 1:패쓰워드 불일치
		String msg2 = "패스워드가 일치하지않습니다.";
		/***************** case1 script **************
		out.println("<script>");
		out.println(" 	alert('" + msg2 + "');");
		out.println(" 	location.href='user_login_form.jsp';");
		out.println("</script>");
		*********************************************/
		
		/************** case2 forward ****************/
		request.setAttribute("msg2", msg2);
		request.setAttribute("fuser", new User(userId, password, "", ""));
		
		RequestDispatcher rd = request.getRequestDispatcher("user_login_form.jsp");
		rd.forward(request, response);
		
		/*********************************************/
	} else if (result == 2) {
		// 2:로그인성공(세션)
		session.setAttribute("sUserId", userId);
		response.sendRedirect("user_main.jsp");
	}
	
%>