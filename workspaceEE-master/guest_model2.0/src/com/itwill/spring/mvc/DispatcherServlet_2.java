package com.itwill.spring.mvc;
// guest_1.2 버전
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

/*
즉, Spring MVC에서 
DispatcherServlet 과 @WebServlet(urlPatterns = { "*.do" }) 는 모두 웹 요청을 처리하고 관리하는 역할을 하며, 
@WebServlet을 이용하여 "*.do"로 끝나는 URL에 대한 요청을 Spring의 DispatcherServlet으로 전달하여 처리할 수 있다. 
이것은 웹 애플리케이션의 요청-응답 처리 흐름을 효율적으로 관리하는 데 도움을 준다.
*/

//@WebServlet( urlPatterns = {"/guest_list.do","/guest_main.do","/guest_view.do","/guest_write_form.do"})
@WebServlet(urlPatterns = { "*.do" }) // 확장자 패턴 *.do 사용함. 하지만 / 를 붙이면 에러이므로 붙이면 안됨.
/*
 @WebServlet : 어노테이션으로, 서블릿을 선언하고 매핑하기 위해 사용한다.
 urlPatterns : 속성은 해당 서블릿이 어떤 URL 패턴과 일치하는지를 지정한다.
 
 *.do 로 작성하면 .do 로 끝나는 모든 URL에 해당하는 요청이 이 사블릿으로 매핑됨 
 	-> 해당 서블릿은 주어진 URL 패턴과 일치하는 요청이 발생할 때 호출되어 작업을 실행한다. 
 	-> 동일한 서블릿을 사용하기에 데이터 조작 작업을 일괄적으로 처리 가능하다.
 
 @WebServlet(urlPatterns = { "*.do" }) 란,
 .do 로 끝나는 URL 에 대한 요청을 처리하기 위한 서블릿을 선언하고 매핑하는 것을 나타낸다.
 이 패턴은 주로 웹 애플리케이션에서 데이터 조작과 관련된 작업을 처리하는데 사용된다.
 
  ++ @WebServlet(urlPatterns = { "*.do" }) 는 DispatcherServlet 의 기능과 유사한 역할을 수행할수있다.
*/
public class DispatcherServlet_2 extends HttpServlet { 
	/*
	 * DispatcherServlet :
	 Spring MVC (Model-View-Controller) 프레임워크는 웹 애플리케이션의 웹 요청과 응답을 처리하기 위한 구조를 제공한다.
	 웹 애플리케이션의 요청을 받고 해당 요청을 처리하기 위해 적절한 핸들러(컨트롤러)로 전달하는 역할을 수행한다.
	 모든 웹 요청을 중앙에서 관리하고, 요청에 따라 적절한 컨트롤러로 분배하는 역할을 한다. 
	 
	 주요 역할 : 클라이언트의 요청 받음 -> 요청 처리위 해 핸들러(컨트롤러) 선택하고 호출
	 			-> 컨트롤러가 처리한 결과를 기반으로 뷰를 렌더링 -> 최종 응답을 생성하여 클라이언트에 전달
	 */
	private GuestService guestService;

	public DispatcherServlet_2() throws Exception {
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
		 * 1. DispatcherServlet이 클라이언트의 요청URI를 사용해서 요청분석
		 */
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		System.out.println(command);
		
		/*
		 * 2.DispatcherServlet이 클라이언트 요청에따른 비지니스실행[Service객체사용]
		 */
		String forwardPath = "";
		if (command.equals("/guest_main.do")) {
			/****************** guest_main.do ****************/
			forwardPath = "forward:/WEB-INF/views/guest_main.jsp";
			/**********************************************/
		} else if (command.equals("/guest_list.do")) {
			/****************** guest_list.do ****************/
			try {
				List<Guest> guestList = guestService.findAll();
				request.setAttribute("guestList", guestList);
				forwardPath = "forward:/WEB-INF/views/guest_list.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
			}
			/**********************************************/
		} else if (command.equals("/guest_view.do")) {
			/****************** guest_view.do ****************/
			try {
				String guest_noStr = request.getParameter("guest_no");
				if (guest_noStr == null || guest_noStr.equals("")) {
					forwardPath = "redirect:guest_main.do";
				} else {
					GuestService guestService = new GuestService();
					Guest guest = guestService.findByNo(Integer.parseInt(guest_noStr));
					request.setAttribute("guest", guest);
					forwardPath = "forward:/WEB-INF/views/guest_view.jsp";
				}
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
			}
			/***********************************************/
		} else if (command.equals("/guest_write_form.do")) {
			/****************** guest_write_form.do **********/
			forwardPath = "forward:/WEB-INF/views/guest_write_form.jsp";
			/*************************************************/
		} else if (command.equals("/guest_write_action.do")) {
			/****************** guest_write_action.do ********/
			try {
				if (request.getMethod().equalsIgnoreCase("GET")) {
					// response.sendRedirect("guest_main.do");
					forwardPath = "redirect:guest_main.do";
				} else {
					String guest_name = request.getParameter("guest_name");
					String guest_email = request.getParameter("guest_email");
					String guest_homepage = request.getParameter("guest_homepage");
					String guest_title = request.getParameter("guest_title");
					String guest_content = request.getParameter("guest_content");
					int rowCount = guestService.insert(
							new Guest(0, guest_name, null, guest_email, guest_homepage, guest_title, guest_content));
					// response.sendRedirect("guest_list.do");
					forwardPath = "redirect:guest_list.do";
				}
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
			}
			/*************************************************/
		} else if (command.equals("/guest_remove_action.do")) {
			/****************** guest_remove_action.do *******/
			try {
				if (request.getMethod().equalsIgnoreCase("GET")) {
					forwardPath = "redirect:guest_main.do";
				} else {
					String guest_noStr = request.getParameter("guest_no");
					int rowCount = guestService.delete(Integer.parseInt(guest_noStr));
					// response.sendRedirect("guest_list.do");
					forwardPath = "redirect:guest_list.do";
				}
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
			}

			/*************************************************/
		} else if (command.equals("/guest_modify_form.do")) {
			/****************** guest_modify_form.do *********/
			try {
				if (request.getMethod().equalsIgnoreCase("GET")) {
					forwardPath = "redirect:guest_main.do";
				} else {
					String guest_noStr = request.getParameter("guest_no");
					Guest guest = guestService.findByNo(Integer.parseInt(guest_noStr));
					request.setAttribute("guest", guest);
					forwardPath = "forward:/WEB-INF/views/guest_modify_form.jsp";
				}
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
			}
			/*************************************************/
		} else if (command.equals("/guest_modify_action.do")) {
			/****************** guest_modify_action.do *******/
			try {
				if (request.getMethod().equalsIgnoreCase("GET")) {
					forwardPath = "redirect:guest_main.do";
				} else {
					String guest_noStr = request.getParameter("guest_no");
					String guest_name = request.getParameter("guest_name");
					String guest_email = request.getParameter("guest_email");
					String guest_homepage = request.getParameter("guest_homepage");
					String guest_title = request.getParameter("guest_title");
					String guest_content = request.getParameter("guest_content");

					int rowCount = guestService.update(new Guest(Integer.parseInt(guest_noStr), guest_name, null,
							guest_email, guest_homepage, guest_title, guest_content));

					forwardPath = "redirect:guest_view.do?guest_no=" + guest_noStr;
				}
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
			}
			/****************************************************/
		} else {
			forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
		}
		/*
		 * 3.DispatcherServlet이 forwardPath를 사용해서 forward 혹은 redirect를한다.
		 */
		
		/**************** forward or redirect *****************/
		// 이 값은 고정이기 때문에 미리 써 놓고 시작한다.
		/*
		 * forward  --> forward:/WEB-INF/views/guest_xxx.jsp
		 * redirect --> redirect:guest_xxx.do
		 */
		String[] pathArray = forwardPath.split(":"); // forwardPath 문자열을 : 콜론 기준으로 분할하여 pathArray 배열에 저장한다
		String forwardOrRedirect = pathArray[0];
		// forwardOrRedirect 변수에는 분할된 배열의 첫번째 요소가 저장된다. 이 값은  "redirect" 또는 "forward" 가 들어간다.
		String path = pathArray[1];
		// path 변수에는 분할된 배열의 두번째 요소가 저장된다. 이 값은 실제로 redirect 하거나 forward 할 경로가 된다.
		/*
		 예를 들어 설명 하면 forward:/WEB-INF/views/guest_error.jsp 문자열에서
		 : 를 기준으로 forward 는 forwardOrRedirect 변수에 저장되고,
		 /WEB-INF/views/guest_error.jsp 는 path 변수에 저장된다. 
		 redirect:guest_main.do 도 마찬가지로 : 를 기준으로
		 redirect 는 forwardOrRedirect 변수에 저장되고, guest_main.do 는 path 변수에 저장된다.
		 
		 왜 pathArray[0] , pathArray[1] 이냐면 : 를 기준으로 왼쪽이 0 , 오른쪽이 1이다. 그래서 0, 1 값이 들어간다.
		 */

		if (forwardOrRedirect.equals("redirect")) { // forwardOrRedirect 값이 "redirect"인 경우:
			response.sendRedirect(path); // 를 호출하여 브라우저에 지정된 path 로 redirect 하도록 요청한다.
			// 즉, 사용자의 브라우저는 새로운 URL 로 이동한다.
			
		} else if (forwardOrRedirect.equals("forward")) { // forwardOrRedirect 값이 "forward"인 경우:
			RequestDispatcher rd = request.getRequestDispatcher(path); // RequestDispatcher를 생성하여 지정된 path로 내부적으로 포워딩한다.
			// 여기서 포워드란 현재의 서블릿에서 다른 서블릿으로 제어권을 넘겨주는 것을 의미한다.
			rd.forward(request, response); // 를 호출하여 현재 요청과 응답 객체를 새로운 경로로 전달, 해당 경로의 서블릿으로 제어를 전환한다.
		}
		/*****************************************************/

	}

}
