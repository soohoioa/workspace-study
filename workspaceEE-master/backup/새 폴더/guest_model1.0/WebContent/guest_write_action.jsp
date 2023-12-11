<%@page import="java.util.Date"%>
<%@page import="com.itwill.guest.Guest"%>
<%@page import="com.itwill.guest.GuestService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
/*
	GET방식이면 guest_main.jsp redirection

  0.요청객체encoding설정
  1.파라메타받기(guest_name,guest_email,guest_homepage,guest_title,guest_content)
     Guest객체생성
  2.GuestService객체생성
  3.GuestService객체 insertGuest(Guest객체) 메쏘드호출
  4.guest_list.jsp로 redirection
 */
if (request.getMethod().equalsIgnoreCase("GET")) {
	response.sendRedirect("guest_main.jsp");
	return;
}
request.setCharacterEncoding("UTF-8");

String guest_name = request.getParameter("guest_name");
String guest_email = request.getParameter("guest_email");
String guest_homepage = request.getParameter("guest_homepage");
String guest_title = request.getParameter("guest_title");
String guest_content = request.getParameter("guest_content");

GuestService guestService = new GuestService();
int rowCount = guestService.insert(new Guest(0, guest_name, null, guest_email, guest_homepage, guest_title, guest_content));
// 번호는 시퀀스로 들어감, Date 는 수정이 필요 없으므로 null 로 작성.
// int rowCount 로 반환되지만 딱히 사용은 안한다.
response.sendRedirect("guest_list.jsp");


/*
Guest guest = new Guest(0, guest_name, newDate(), guest_email, guest_homepage, guest_title, guest_content);
guestService.insert(guest);
response.sendRedirect("guest_list.jsp");
*/

%>