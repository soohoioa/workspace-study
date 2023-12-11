package com.itwill.spring.mvc;

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
import com.itwill.guest.controller.GuestErrorController;
import com.itwill.guest.controller.GuestListController;
import com.itwill.guest.controller.GuestMainController;
import com.itwill.guest.controller.GuestModifyActionController;
import com.itwill.guest.controller.GuestModifyFormController;
import com.itwill.guest.controller.GuestRemoveActionController;
import com.itwill.guest.controller.GuestViewController;
import com.itwill.guest.controller.GuestWriteActionController;
import com.itwill.guest.controller.GuestWriteFormController;

/*
  1. 클라이언트(웹 브라우저) 의 모든 요청을 받는 서블릿 작성
  2. 확장자 *.do 는 모든 클라이언트의 요청이 서블릿을 실행하도록 web.xml 에 url pattern mapping
  << web.xml >>
    
  <servlet>
  	<servlet-name>dispatcher</servlet-name>
  	<servlet-class>com.itwill.spring.mvc.DispatcherServlet</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>dispatcher</servlet-name>
  	<url-pattern>*.do</url-pattern>
  </servlet-mapping>
  
 */

public class DispatcherServlet extends HttpServlet {
	
	private GuestService guestService;

	public DispatcherServlet() throws Exception {
		guestService = new GuestService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*
		<< 요청url(command)>>
		/guest_main.do  	
		/guest_list.do			
		/guest_view.do		
		/guest_write_form.do	
		/guest_write_action.do	
		/guest_modify_form.do	
		/guest_modify_action.do	
		/guest_remove_action.do
		*/

		/*
		 * 1. DispatcherServlet 이 클라이언트의 요청 URI를 사용해서 요청분석한다.
		 */
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		System.out.println(command);
		
		/*
		 * 2.DispatcherServlet 이 클라이언트 요청에 따른 비즈니스 실행 할 Controller 객체 생성
		 */
		String forwardPath = "";
		Controller controller = null;
		
		if (command.equals("/guest_main.do")) {
			/***** guest_main.do 를 처리하는 Controller 객체 생성 *****/
			controller = new GuestMainController();			
			
		} else if (command.equals("/guest_list.do")) {
			/***** guest_list.do 를 처리하는 Controller 객체 생성 *****/
			controller = new GuestListController();			
			
		} else if (command.equals("/guest_view.do")) {
			/***** guest_view.do 를 처리하는 Controller 객체 생성 *****/
			controller = new GuestViewController();			
			
		} else if (command.equals("/guest_write_form.do")) {
			/**** guest_write_form.do 를 처리하는 Controller 객체 생성****/
			controller = new GuestWriteFormController();		
			
		} else if (command.equals("/guest_write_action.do")) {
			/**** guest_write_action.do 를 처리하는 Controller 객체 생성****/
			controller = new GuestWriteActionController();
			
		} else if (command.equals("/guest_remove_action.do")) {
			/**** guest_remove_action.do 를 처리하는 Controller 객체 생성****/
			controller = new GuestRemoveActionController();
			
		} else if (command.equals("/guest_modify_form.do")) {
			/**** guest_modify_form.do 를 처리하는 Controller 객체 생성****/
			controller = new GuestModifyFormController();
			
		} else if (command.equals("/guest_modify_action.do")) {
			/**** guest_modify_action.do 를 처리하는 Controller 객체 생성****/
			controller = new GuestModifyActionController();
			
		} else {
			/**** ???.do 를 처리하는 Controller 객체 생성****/
			controller = new GuestErrorController();
		}
		
		forwardPath = controller.handleRequest(request, response);
		
		/*
		 * 3.DispatcherServlet 이 forwardPath 를 사용해서 forward 혹은 redirect를한다.
		 */
		
		/**************** forward or redirect *****************/
		/*
		 * forward  --> forward:/WEB-INF/views/guest_xxx.jsp
		 * redirect --> redirect:guest_xxx.do
		 */
		String[] pathArray = forwardPath.split(":");
		String forwardOrRedirect = pathArray[0];
		String path = pathArray[1];

		if (forwardOrRedirect.equals("redirect")) {
			response.sendRedirect(path);
		} else if (forwardOrRedirect.equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
		/*****************************************************/

	}

}
