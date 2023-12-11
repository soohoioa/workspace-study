<%@page import="com.itwill.address.AddressService"%>
<%@page import="com.itwill.address.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
 
GET방식의요청이 들어오면 address_main.jsp 로 redirection
 
 * 0.요청객체 encoding설정 
 * 1.파라메타 바끼(no,id,name,phone,address) 
 * 2.파라메타데이타로 Address객체생성
 * 3.AddressService객체생성 
 * 4.AddressService.updateByNo()메쏘드실행 
 * 5.adress_detail.jsp 로
 * redirection
 */
 
 if(request.getMethod().equals("GET")) {
		response.sendRedirect("address_list.jsp");
		return;
	}
 
 request.setCharacterEncoding("UTF-8");
 
 String noStr = request.getParameter("no");
 String name = request.getParameter("name");
 String phone = request.getParameter("phone");
 String address = request.getParameter("address");
 
 AddressService addressService=new AddressService();
 addressService.addressUpdate(new Address(Integer.parseInt(noStr), name, phone, address));
 
 response.sendRedirect("address_detail.jsp?no=" + noStr);
%>














