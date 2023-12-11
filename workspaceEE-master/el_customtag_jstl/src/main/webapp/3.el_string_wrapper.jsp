<%@page import="com.itwill.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("sUserId", "aaa");
	session.setAttribute("sUser", new User("aaa", "111", "홍길동", "aaa@gmail.com"));
	// 이 코드들은 controller 에 있다
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL String,Wrapper객체(기본형객체) 출력</h1>
<ol>
	<li>${sUserId}</li>
	<li>${sUser.userId}</li>
	<li>${sUser.password}</li>
	<li>${sUser.name}</li>
	<li>${sUser.email}</li>
	<!-- 이렇게 출력한다. -->
</ol>
</body>
</html>










