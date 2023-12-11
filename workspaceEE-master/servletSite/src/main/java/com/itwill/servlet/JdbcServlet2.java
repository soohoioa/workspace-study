package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

/**
 * Servlet implementation class JdbcServlet1
 */
@WebServlet("/Jdbc2.do")
public class JdbcServlet2 extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			/*
			 * 1. Service 객체 생성
			 */
			AddressService addressService = new AddressService();
			// 서비스 생성마다 객체생성하면서 요청하면 귀찮다,,; 라고 알고있기.
			
			/*
			 * 2. Service 객체 메소드 실행
			 */
			List<Address> addressList = addressService.addressList();
			
			/*
			 * 3. 클라이언트로 출력
			 */
			
		
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();

			out.println("<html>");
			out.println("<head>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"com.css\">");
			out.println("</head>");
			out.println("<body>");
			out.println("<br>");
			out.println("<p align=center><font size=5 color=#0000FF>◈◈ JDBC 테스트 2◈◈</font><br>");
			out.println(
					"<table width=80% align=center border=1 cellspacing=0 bordercolordark=white bordercolorlight=#ADADAD>");
			out.println("<tr bgcolor=#000000 class=t1>");
			out.println("<td align=center height=20 width=25%><font color=#FFFFFF>이름</font></td>");
			out.println("<td align=center height=20 width=25%><font color=#FFFFFF>전화번호</font></td>");
			out.println("<td align=center height=20 width=50%><font color=#FFFFFF>주소</font></td>");
			out.println("</tr>");
			for (Address address:addressList) {
				out.println("<tr class=t1>");
				out.println("<td align=center width=25% height=20>"+ address.getName() +"</td>");
				out.println("<td align=center width=25% height=20>"+ address.getPhone() +"</td>");
				out.println("<td align=center width=50% height=20>"+ address.getAddress() +"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html> ");
		} catch (Exception e) {
			// service 는 재정의 메소드라 함부로 재정의 할경우 위반됨; 그래서 try 로 전체를 감싸줬다.
			e.printStackTrace();
		}
		
	}

}
