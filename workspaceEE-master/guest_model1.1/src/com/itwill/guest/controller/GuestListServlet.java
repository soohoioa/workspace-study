package com.itwill.guest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

/**
 * Servlet implementation class GuestListServlet
 */
@WebServlet("/guest_list.do")
public class GuestListServlet extends HttpServlet {
	
	private GuestService guestService;
	
	public GuestListServlet() throws Exception{
		guestService=new GuestService();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath="";
		try {
			
			List<Guest> guestList=guestService.findAll();
			request.setAttribute("guestList", guestList);
			forwardPath="forward:/WEB-INF/views/guest_list.jsp";
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		}
		
		/**************** forward or redirect *****************/
		/*
		 * forward  --> forward:/WEB-INF/views/guest_xxx.jsp
		 * redirect --> redirect:guest_xxx.do
		 */
		String[] pathArray=forwardPath.split(":");
		// forwardPath 문자열을 : 콜론 기준으로 분할하여 pathArray 배열에 저장한다.
		String forwardOrRedirect = pathArray[0];
		// forwardOrRedirect 변수에는 분할된 배열의 첫번째 요소가 저장된다.
		// 이 값은 redirect 또는 forward 가 된다.
		String path=pathArray[1];
		// path 변수에는 분할된 배열의 두번째 요소가 저장된다. 
		// 이 값은 실제로 리다이렉션 하거나 포워드할 경로가 된다.
		if(forwardOrRedirect.equals("redirect")) { // forwardOrRedirect 의 값이 redirect 인 경우
			response.sendRedirect(path); // 호출하여 브라우저에게 지정된 path 로 리다이렉션 하도록 요청한다.
			// 즉, 사용자의 브라우저는 새로운 URL 로 이동한다.
		}else if(forwardOrRedirect.equals("forward")) { // forwardOrRedirect 의 값이 forward 인 경우
			RequestDispatcher rd = request.getRequestDispatcher(path);// RequestDispatcher 생성하여 지정된 path 로 내부적으로 포워딩한다.
			// 포워드란 현재의 서블릿에서 다른 서블릿으로 제어권을 넘겨주는것을 의미한다.
			rd.forward(request, response);// 호출하여 현재 요청과 응답객체를 새로운 경로로 전달,
			// 해당 경로의 서블릿으로 제어를 전환한다. 
		}
		/*****************************************************/
	}
	
	/*
	"Redirect"와 "forward" 는 웹 개발관련용어, 웹 페이지나 리소스의 이동에 대한 다른방법을 나타내는데 사용, 
	비슷한 개념을 가지고 있지만 약간 다른 의미를 지니고 있다.
	
	1. Redirect : 클라이언트(웹 브라우저)가 요청한 웹 페이지나 리소스를 다른 위치로 보내는 프로세스를 의미한다.
				  사용자가 원래 요청한 페이지에 대한 URL 을 입력하거나 클릭했을때 다른 페이지로 전환되는 경우도 포함한다.
				  Redirect 는 HTTP 상태코드와 함께 이루어진다.
	2. 	Forward : 클라이언트의 요청을 서버 내부에서 다른 리소스나 서버로 전달하는 프로세스를 의미한다.
		  		  사용자의 요청이 처음 서버에 도달하면, 서버는 이 요청을 다른 위치나 서버로 전달, 
		  		  전달된 위치에서 처리된 응답을 다시 클라이언트에게 돌려준다.
		  		  사용자에게는 보이지 않고, 클리아언트는 최종 응답을 받는 것처럼 동작한다.
		  		  주로 서버 간 통신이나 서버 내부에서의 작업 분배를 위해 사용한다.
	
	Redirect 는 클라이언트에게 요청한 리소스의 위치가 변경되었음을 알리고 새 위치로 이동시키는 프로세스
	Forward  는 서버 내에서 요청을 다른 리소스나 서버로 전달하여 처리하는 프로세스
	
	 */

}
