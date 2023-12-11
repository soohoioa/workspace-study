package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetLoginServlet
 */
@WebServlet("/post_login.do") // url 이 중복이면 사이트는 뜨지않음,
public class PostLoginServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 파라미터 받기 -> 비즈니스 업무실행 -> 출력
		// else문 사용하지말고 if 문만 사용하기. 
		// else 하지말고 return 해라.
		
		/*
		 * 1. 요청시 전송되는 파라미터받기
		  	- 파라미터이름은 input element의 name 속성의 값
		  		<form action="get_login.do" method="get">
					아이디:<input type="text" name="id"><br/>
					패에쓰:<input type="password" name="pass"><br/><br/>
				</form>
		 */
		String id = request.getParameter("id");
		String pass= request.getParameter("pass");
		if(id == null || pass == null || id.equals("") || pass.equals("")) {
			out.println("<h1>POST 로그인 결과</h1><hr>");	
			out.println("<h3>아이디 패스워드를 입력하세요!!!<h3><hr>");
			out.println("<a href ='05-02.login_post.html'> 다시 로그인 </a> ");
			
			return;
		}
		
		/*
		 * 2. 서비스객체를 사용해서 업무(로그인) 실행
		 * ----------
		 *  id | pass
		 * ----------
		 * xxxx|1111
		 * ----------
		 * yyyy|2222
		 * ----------
		 */
		boolean isMember1 = id.equals("xxxx") && pass.equals("1111");
		boolean isMember2 = id.equals("yyyy") && pass.equals("2222");
		
		/*
		 * 3. 클라이언트로 출력(UI결과전송)
		 */
		out.println("<h1>POST 로그인 결과</h1><hr>");
		
		if (isMember1 || isMember2) {
			out.println("<h3>" + id + "님 로그인 성공<h3><hr>");
			out.println("<a href ='index.html'> 메인으로 </a> ");
		} else {
			out.println("<h3>" + id + "님 로그인 실패<h3><hr>");
			out.println("<a href ='05-02.login_post.html'> 다시 로그인 </a> ");

		}
		// 폼을 포스트로 작성하고 폼을 서브밋하면 포스트 방식으로 하나밖에 없다.
		// 포스트는 무조건 폼을 사용해야함. 그 외는 겟 방식
		// 포스트는 폼에서 서브밋 버튼밖에 없다 그 외는 모두 겟 방식이다.
		
	}

}
