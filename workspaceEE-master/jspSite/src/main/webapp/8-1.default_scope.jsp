<%@page import="com.itwill.student.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Student pageStudent = new Student(); 
	Student requestStudent = new Student(); 
	Student sessionStudent = new Student(); 
	Student applicationStudent = new Student(); 

	pageContext.setAttribute("pageStudent", pageStudent);
	request.setAttribute("requestStudent", requestStudent);
	session.setAttribute("sessionStudent", sessionStudent);
	application.setAttribute("applicationStudent", applicationStudent);
	
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>SCOPE객체</h1>
<hr>
<ol>
	<li>pageContext:<%=pageContext.getAttribute("pageStudent") %></li>
	<li>request:<%=request.getAttribute("requestStudent") %></li>
	<li>session:<%=session.getAttribute("sessionStudent") %></li>
	<li>application:<%=application.getAttribute("applicationStudent") %></li>
</ol> 
<br/>

<jsp:include page="8-2.default_scope_request.jsp" />


<a href='8-3.default_scope_page_session_application1.jsp'>8-3.default_scope_page_session_application1.jsp</a>

</body>
</html>


