<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>기본객체 pageContext[PageContext]</h1>
<hr/>

<ol>
	<li><%=pageContext %></li>
	<li><%=request %> == <%=pageContext.getRequest() %></li>
	<li><%=response %> == <%=pageContext.getResponse() %></li>
	<li><%=session %> == <%=pageContext.getSession() %></li>
	<li><%=application %> == <%=pageContext.getServletContext() %></li>
	<li><%=config %> == <%=pageContext.getServletConfig() %></li>
	<li><%=out %> == <%=pageContext.getOut() %></li>
</ol>
</body>
</html>
