package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloTextServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 정적은 매핑이 필요없지만 동적은 반드시 매핑이 필요함.

		response.setContentType("text/plain;charset=UTF-8"); // 응답할때 헤더값 줘야함
		PrintWriter out = response.getWriter(); 
		
		for (int i = 0; i < 100; i++) {
			out.println("Hello text" + (i + 1) + "[dynamic web resource]");			
		}

	}

}
