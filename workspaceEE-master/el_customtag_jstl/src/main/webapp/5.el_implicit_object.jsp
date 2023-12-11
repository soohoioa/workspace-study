<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL 내장객체(implicit object) 타입은맵이다.</h1><hr>
<ul>
	<li>---pageScope,requestScope,sessionScope,applicationScope---</li>
		
	<li>--------param---------------</li>	
	<li>--------paramValues---------</li>
	<li>--------cookie--------------
		<ul>
			<li>${cookie}</li>
			<li>${cookie.JSESSIONID}</li>
			<li>${cookie.JSESSIONID.name}</li>
			<li>${cookie.JSESSIONID.value}</li>
		</ul>
	</li>	
	<li>-----pageContext[빈객체]---------
		<ul>
			<li>${pageContext.request}</li>	
			<li>${pageContext.request.method}</li>	
			<li>${pageContext.request.contextPath}</li>	
			<li>${pageContext.out}</li>	
			<li>${pageContext.session}</li>	
			<li>${pageContext.servletContext}</li>	
			<li>${pageContext.servletConfig}</li>	
			<li>${pageContext.response}</li>	
		</ul>	
	</li>
	
</ul>	

</ul>
</body>
</html>