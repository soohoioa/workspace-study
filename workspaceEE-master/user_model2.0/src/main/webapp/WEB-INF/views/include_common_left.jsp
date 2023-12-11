<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>	
<%
	String sUserId = (String)session.getAttribute("sUserId");
	// 템플릿을 보여주기 위해 이 작업을 했다.
	// 이 작업은 비즈니스가 아니다. 이코드가 서블릿으로 가야하나 생각할수있지만 안가도됨
%>    		
<p>
	<strong>메 뉴</strong>
</p>
<ul>
	<%if(sUserId!=null){ %>
		<!-- 로그인후 -->
		<li><a href=""><%=sUserId %> 님</a></li>
		<li><a href="user_view.do">내정보</a></li>
		<li><a href="user_logout_action.do">로그아웃</a></li>
	<%}else{ %>
		<!-- 로그인전 -->
		<li><a href="user_login_form.do">로그인</a></li>
		<li><a href="user_write_form.do">회원가입</a></li>
 	<%} %>
</ul>
