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
 * Servlet implementation class AddressDetailServlet
 */
@WebServlet("/address_detail.do")
public class AddressDetailServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			/*
			 * 요청URL
			 *   http://localhost/addressSite/address_detail.do?no=1
			 *   http://localhost/addressSite/address_detail.do?no=2
			 *   http://localhost/addressSite/address_detail.do?no=3
			 *   http://localhost/addressSite/address_detail.do?no=4
			 *   http://localhost/addressSite/address_detail.do?no=5
			 */
			
			/*
			 * 0.요청객체encoding설정
			 * 1.파라메타받기
			 * 2.AddressService객체생성
			 * 3.AddressService객체 addressDetail(1) 메쏘드호출
			 * 4.Address객체 출력
			 */
			request.setCharacterEncoding("UTF-8");// 0.요청객체encoding설정
			/*
			 POST방식으로 보내는 값이 '한글'일 경우 깨지지 않게 전달하기 위해 
			 사용하는 것이 request.setCharacterEncoding("UTF-8"); 
			 POST방식으로 보낼때 사용함.
			 
			 +추가>
			 GET방식으로 보낸다면?
			 한글을 GET방식으로 보낼때는 톰캣에 기본적으로 UTF-8문자코드가 적용이 되어있어서 
			 자동으로 한글처리를 해주기때문에 한글이 깨지지 않습니다.
			 */
			
			String noStr = request.getParameter("no");// 1.파라메타받기
			/*
			 PK로 받아서 처리하기 위해; 여기서는 no 가 PK이다;
			 ※ 서버에서 클라이언트(웹브라우저) 가 넘긴 파라미터 받기 - 무조건 String으로 넘어온다.
			 --> 파라미터 이름이 동일한것이 없는 경우
   		 		:  String  변수 = request.getParameter("파라미터이름");
			 */
			
			
			/*
			 null ==> http://localhost/addressSite/address_detail.do
			 ""   ==> http://localhost/addressSite/address_detail.do?no=
			 */
			if(noStr==null || noStr.equals("")) {
				response.sendRedirect("address_list.do");
				return;
			}
			
			AddressService addressService=new AddressService(); // 2.AddressService객체생성
			Address findAddress=addressService.addressDetail(Integer.parseInt(noStr));// 실행이 안된다면 파라미터값이 없는경우이다.
			// 3.AddressService객체 addressDetail(2) 메쏘드호출
			/*
			parseInt() --> String타입의 숫자를 int타입으로 변환
			정수형으로 바뀌는 함수이기 때문에 문자열에 문자가 들어간 String은 바꿀 수 없음
			*/
			
			if(findAddress==null) {
				response.sendRedirect("address_list.do");
				return;
			}
			
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>Insert title here</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>["+findAddress.getName() + "님 주소록상세보기]</h1><hr>");
			out.println("<div>");
			out.println("	<a href='address_main.do'>[메인]</a>");
			out.println("	<a href='address_insert_form.do'>[주소록쓰기폼]</a>");
			out.println("	<a href='address_list.do'>[주소록리스트]</a>");
			//out.println("	<a href='address_delete_action.do?no="+findAddress.getNo()+"'>["+findAddress.getName()+"님삭제[GET]]</a>");
			out.println("	<form action='address_update_form.do' method='post' style='display:inline;'>");
			out.println("		<input type='hidden'   name='no' value='"+findAddress.getNo()+"'>");
			out.println("		<input type='submit' value='"+findAddress.getName()+"님 주소록수정폼[POST]'>");
			out.println("	</form>");
			out.println("<form action='address_delete_action.do' method='post' style='display:inline;'>");
			out.println("	<input type='hidden'   name='no' value='"+findAddress.getNo()+"'>");
			out.println("	<input type='submit' value='"+findAddress.getName()+"님삭제[POST]'>");
			out.println("</form>");
			out.println("</div>");
			out.println("<p>");
			out.println("	번호:"+findAddress.getNo()+"<br>");
			out.println("	이름:"+findAddress.getName()+"<br>");
			out.println("	전화:"+findAddress.getPhone()+"<br>");
			out.println("	주소:"+findAddress.getAddress()+"<br>");
			out.println("</p>");
			out.println("</body>");
			out.println("</html>");
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("address_error.html");
			return;
		}

	}

}