<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
/*
   GET방식이면 guest_main.jsp redirection 계속 체크해줘서 공통요소가 필요한거같다요
   
  0.요청객체encoding설정
  1.파라메타받기(guest_no)
  2.GuestService객체생성
  3.GuestService객체 deleteGuest(guest_no) 메쏘드호출
  4.guest_list.jsp로 redirection
 */
if (request.getMethod().equalsIgnoreCase("GET")) { // equalsIgnoreCase 대소문자 구분없이 비교하는 것
	response.sendRedirect("guest_main.jsp");
	return;
}

String guest_noStr = request.getParameter("guest_no");
GuestService guestService = new GuestService(); //리턴을 당하지 않았다면
int rowCount = guestService.delete(Integer.parseInt(guest_noStr));
//int rowCount 로 반환되지만 딱히 사용은 안한다.
response.sendRedirect("guest_main.jsp"); // 다 메인으로 보냄, 나중에 수정하기


/*
if (request.getMethod().equalsIgnoreCase("GET")) { 
	response.sendRedirect("guest_main.jsp");
	return;
}
request.setCharacterEncoding("UTF-8");
String guest_no = request.getParameter("guest_no");
int no = Integer.parseInt(guest_no);
GuestService guestService = new GuestService();
guestService.delete(no);
response.sendRedirect("guest_list.jsp");
*/



%>