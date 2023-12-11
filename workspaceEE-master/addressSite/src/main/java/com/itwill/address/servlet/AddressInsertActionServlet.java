package com.itwill.address.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

/**
 * Servlet implementation class AddressInsertActionServlet
 */
@WebServlet("/address_insert_action.do")
//action 사용시 대부분 응답작업 안함 -> 
//response.setContentType("text/html;charset=UTF-8"); PrintWriter out = response.getWriter(); 
//작업안함 -> 요청바디 없다.
public class AddressInsertActionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("address_main.do");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			/*
			 * 0.요청객체encoding설정
			 * 1.파라메타받기
			 * 2.AddressService객체생성
			 * 3.AddressService.addressWrite()메쏘드실행
			 * 4.address_list.do 로 redirection
			 */
			request.setCharacterEncoding("UTF-8"); // 0.요청객체encoding설정
			
			String name=request.getParameter("name"); // 1.파라메타받기
			String phone=request.getParameter("phone");
			String address=request.getParameter("address");
			
			// null 경우 자바스크립트에서 다 막아줌, 여기서는 안함
			
			AddressService addressService=new AddressService(); //2.AddressService객체생성
			
			int rowCount=addressService.addressWrite(new Address(0, name, phone, address));
			// Address no는 시퀀스로 들어가서 no제외하고 3개만 필요
			
			response.sendRedirect("address_list.do"); // 4.address_list.do 로 redirection
			/*
			 * sendRedireect 방식이란
			   response 기본 객체에서 많이 사용되는 기능 중 하나는 리다이렉트 기능이다. 
			   리다이렉트는 웹 서버가 웹 브라우저에게 다른 페이지로 이동하라고 응답하는 기능이다. 
			   예를 들어, 사용자가 로그인에 성공한 후 메인 페이지로 자동으로 이동하는 사이트가 많은데 이렇게 특정 페이지를 실행한 후 지정한 페이지로 이동하길 원할 때 리다이렉트 기능을 사용한다.

			   즉, 리다이렉트는 웹 서버 측에서 웹 브라우저에게 어떤 페이지로 이동하라고 지정하는 것이다. 
			   리다이렉트는 아래 모양으로 사용할 수있다.

 			   response.sendRedirect("이동할 jsp 페이지");
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("address_error.html");
			return;
		}

	}

}
