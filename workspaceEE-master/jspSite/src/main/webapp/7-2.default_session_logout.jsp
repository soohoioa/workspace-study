<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="7-2.default_session_login_check.jspf" %>
<%
   /*
   세션객체무효화
   */
  session.invalidate();
  response.sendRedirect("7-2.default_session_login_form.jsp");
  // Redirect 하면 새로운 쿠키를 만들어 클라이언트에 심는다. 새로운 세션이 발생한다. 
  
%>