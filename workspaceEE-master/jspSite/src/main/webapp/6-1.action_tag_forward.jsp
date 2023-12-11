<%@page import="com.itwill.student.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println("6-1.action_forward.jsp");
	/*
	forwading
	  - 6-1.action_tag_forwarded.jsp 로 HTTP요청을보냄
	*/
	
	request.setAttribute("id", "guard");
	request.setAttribute("name", "홍길동");
	request.setAttribute("age", 11);
	request.setAttribute("student", new Student());
	
	// forward는 하나의 요청과 응답객체를 유지한 채 작업이 이루어진다.
	
%>
<jsp:forward page="6-1.action_tag_forwarded.jsp" />