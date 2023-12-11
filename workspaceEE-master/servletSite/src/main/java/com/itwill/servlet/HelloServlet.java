package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 상속받고 재정의하고	
		response.setContentType("text/html;charset=UTF-8"); // 응답의 헤더, 헤더는 데이터 받기전에, 미리 헤더에 내가 보낼 타입 기술
		// response.setContentType("text/plain;charset=UTF-8");
		// html 로 작성시 html 구조로 보여주고 plain 으로 작성시 텍스트 형식으로 뿌려준다. 차이점 확인하기.
		PrintWriter out = response.getWriter(); // 여기서 out 은 서버쪽에 연결된 아웃풋스트림
		

		 out.println("<!DOCTYPE html>");
		 out.println("<html>");
		 out.println("<head>");
		 out.println("<meta charset=\"UTF-8\">");
		 out.println("<title>Insert title here</title>");
		 out.println("</head>");
		 out.println("<body>");
		 for(int i = 0; i < 10; i++) {
			 out.printf("	<h1>Hello Servlet(안녕 서블릿)[%d]</h1><hr>", i+1);
		 }
		 out.println("</body>");
		 out.println("</html>");
		 
		
		

	}

}
