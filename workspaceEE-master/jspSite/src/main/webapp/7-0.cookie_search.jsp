<%@page import="javax.servlet.http.Cookie"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	1. 요청객체로부터 클라이언트가 전송한 쿠키객체들얻기
	쿠키는 모두 클라이언트가 저장한다. 서버는 응답할때 심고 요청할때 읽는다.
	*/
	Cookie[] cookies =  request.getCookies(); // 다양한 정보가 들어갈 수 있으므로, 배열로 받아와야한다.
	
	String previouSearchKeyword ="";

	if(cookies != null) {
		for(Cookie cookie:cookies) {
			System.out.println("["+request.getRemoteAddr()+"]가 전송한쿠키 이름:"+cookie.getName());
			System.out.println("["+request.getRemoteAddr()+"]가 전송한쿠키 값  :"+cookie.getValue());
			if(cookie.getName().equals("searchKeyword")) {
				previouSearchKeyword=cookie.getValue();
			}
		}
	}
	
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>쿠키읽기</h1><hr/>
	<form action="7-0.cookie_create.jsp">
		검색어:<input type="text" name="searchKeyword" 
			placeholder="검색어를 입력하세요" value="">
		<input type="submit" value="검색" >
	</form>
</body>
</html>