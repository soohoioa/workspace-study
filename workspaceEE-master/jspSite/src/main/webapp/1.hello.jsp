<!-- 
	1. 자동으로 생성되는 서블릿 파일(*.java) 의 위치
	C:\2023-05-JAVA-DEVELOPER\workspaceEE\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\jspSite\org\apache\jsp
	: 위치는 이클립스가 자동으로 생성하는거라 변경될수있다.
	
	2. 자동으로 생성되는 서블릿 파일의 이름
		_1_hello_jsp.java
	

 -->

<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
	<% for(int i = 0; i < 10; i++) {%> <!-- <%  %> 자바 코드 삽입  -->
		<h1>Hello JSP[change]</h1>
	<% } %>
	<hr/>
	<jsp:include page="6-2.action_tag_included_footer.jsp"/>
</body>
</html>
