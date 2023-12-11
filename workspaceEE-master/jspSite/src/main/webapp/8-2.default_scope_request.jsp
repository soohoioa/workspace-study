<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
-------- 8-2.default_scope_request.jsp include start ----------<br>
<ol>
	<li>pageContext:<%=pageContext.getAttribute("pageStudent") %></li>
	<li>request:<%=request.getAttribute("requestStudent") %></li>
	<li>session:<%=session.getAttribute("sessionStudent") %></li>
	<li>application:<%=application.getAttribute("applicationStudent") %></li>
</ol> 
-------- 8-2.default_scope_request.jsp  include end----------<br>





