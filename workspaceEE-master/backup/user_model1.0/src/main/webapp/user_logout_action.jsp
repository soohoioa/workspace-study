<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%@include file="user_login_check.jspf" %>

<%
	session.invalidate(); //  invalidate 함수는 세션을 없애고 세션에 속해있는 값들을 모두 없앤다.
	response.sendRedirect("user_main.jsp");
%>