<%@page contentType="text/html; charset=UTF-8" %>
<!-- 선언작업은 위치상관없지만 위에 하는게 좋겠다.! 
	 선언과 @(디렉티브) 는 맨 첫번째 줄에 선언하는게 좋다.
-->
<%!
private int count;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body bgcolor=#40e0d0 style="font-size: 9pt; line-height: 140%;">
	<center>
		<!-- HTML주석  -->
		현재까지의 페이지뷰수는 
		<%
			count++;
			String countStr = count+"";
			for(int i=0; i<countStr.length(); i++) {
		%>
			<img width='20' height='20' src='images/<%=countStr.charAt(i) %>.png'>
		<%
			}
		%>
		번 입니다
	</center>
</body>
</html>
