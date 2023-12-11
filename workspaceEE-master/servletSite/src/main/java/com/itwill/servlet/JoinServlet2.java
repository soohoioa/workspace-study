package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join2.do")
public class JoinServlet2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("05-03.form2.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		/*
		 * 0.요청객체인코딩설정
		 */
		request.setCharacterEncoding("UTF-8");
		
		/*
		 * 1.파라메타받기
		 */
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String job = request.getParameter("job");
		String[] hobbies = request.getParameterValues("hobby");
		if(hobbies == null) {
			hobbies = new String[0];
		}

		/*
		 * 2.업무실행(Service객체 메쏘드호출)
		 */
		if(id==null||password==null||repassword==null||name==null||address==null||id.equals("")||password.equals("")||repassword.equals("")||name.equals("")||address.equals("")) {
			out.println("<h3>빈칸을 채워주세요.</h3>");
			out.println("<a href='05-03.form2.html'>가입폼</a>");
			return;
		}

		/*
		 * 3.클라이언트로 응답출력
		 */
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("<style type='text/css'>");
		out.println("th{");
		out.println("border: 1px solid black;");
		out.println("}");
		out.println("td,tr{");
		out.println("border: 0.5px solid black;");
		out.println("text-align: center;");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3 align='center'>가입정보</h3>");
		out.println("<div style='width:300px;margin: 0 auto 0 auto'>");
		out.println("<table style='width:280px;padding: 0 10px 0 10px'>");
		out.println("<tr><th>항목</th><th>입력값</th></tr>");
		out.println("<tr><td>아이디</td><td>"+id+"</td></tr>");
		out.println("<tr><td>패쓰워드</td><td>"+password+"</td></tr>");
		out.println("<tr><td>이름</td><td>"+name+"</td></tr>");
		out.println("<tr><td>주소</td><td>"+address+"</td></tr>");
		out.println("<tr><td>성별</td><td>"+gender+"</td></tr>");
		out.println("<tr><td>직업</td><td>"+job+"</td></tr>");
		out.printf("<tr><td rowspan='%d'>취미</td></tr>", hobbies.length + 1);
		
		for (String hobby : hobbies) {
			out.println("<tr><td>" + hobby + "</td></tr>");
		}
		
		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

	}

}