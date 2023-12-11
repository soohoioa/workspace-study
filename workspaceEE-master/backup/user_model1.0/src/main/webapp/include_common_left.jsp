<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>	
<%
	String sUserId = (String)session.getAttribute("sUserId");	
	// String sUserId = (String) session.getAttribute("sUserId");
	// 리턴 타입은 java.lang.Object이므로 데이터 본래의 타입으로 캐스트 연산을 해야 한다.
%>    		
<p>
	<strong>메 뉴</strong>
</p>
<ul>
	<% if(sUserId != null) { %>
		<!-- 로그인 후 -->
		<li><a href=""><%=sUserId %> 님</a></li>
		<li><a href="user_view.jsp">내정보</a></li>
		<li><a href="user_logout_action.jsp">로그아웃</a></li>
	<% } else { %>
		<!-- 로그인 전 -->
		<li><a href="user_login_form.jsp">로그인</a></li>
		<li><a href="user_write_form.jsp">회원가입</a></li>
	<% } %>
</ul>
