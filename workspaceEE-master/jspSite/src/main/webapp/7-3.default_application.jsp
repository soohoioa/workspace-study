<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>기본객체 application(ServletContext)</h1>
<hr/>
<ol>
<li><%=application %></li>
<li>서버정보 <%=application.getServerInfo() %></li>
<li>major version : <%=application.getMajorVersion() %></li>
<li>minor version : <%=application.getMinorVersion() %></li>
<li>context real path : <%=application.getRealPath("") %></li>
<li>log : <%application.log(">>>>>나의 로그"); %></li>
<xmp>
---------web.xml-----------------
<?xml version="1.0" encoding="UTF-8"?>
<web-app >
  <display-name>jspSite</display-name>
  <context-param>
  	<param-name>name</param-name>
  	<param-value>KIM</param-value>
  </context-param>
  <context-param>
  	<param-name>contextPath</param-name>
  	<param-value>/jspSite</param-value>
  </context-param>
  ..
</web-app>
</xmp>
<li>application parameter(name):<%=application.getInitParameter("name") %>
<li>application parameter(contextPath):<%=application.getInitParameter("contextPath") %>
</ol>
</body>
</html>
