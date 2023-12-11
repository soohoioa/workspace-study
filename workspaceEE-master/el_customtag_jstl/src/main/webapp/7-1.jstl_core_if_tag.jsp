<%@page import="com.itwill.bean.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	session.setAttribute("sUserId", "guard");
	
	request.setAttribute("level", 5);
	request.setAttribute("guest", new Guest());
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL core if tag</h1>
<hr>

<c:if test="true">
	1. 반드시 실행<br>
</c:if>

<c:if test="false">
	2. 반드시 실행 안함<br>
</c:if>

<c:if test="${sUserId != null}">
	<a href="logout_action.jsp">${sUserId} 님 로그아웃</a><br>
</c:if>

<c:if test="${empty sUserId}">
	<a href="login_form.jsp">로그인</a><br>
</c:if>

<c:if test="${empty level}">
	레벨을 입력하세요<br>
</c:if>
<!-- 어떻게 보면 위에 코드가 if문, 아래 코드가 if-else문으로 볼수도 있다. -->
<c:if test="${!empty level}">
	<c:if test="${level>=3 && level <4}">
		${level} 레벨이군요 잘하시네요<br>
	</c:if>
	<c:if test="${level>=4 && level <=5}">
		${level} 레벨이라니 부러워요 고수시군요!!<br>
	</c:if>
</c:if>
<!-- if문 안에 추가로 if문을 기술할수있다. -->

</body>
</html>
















