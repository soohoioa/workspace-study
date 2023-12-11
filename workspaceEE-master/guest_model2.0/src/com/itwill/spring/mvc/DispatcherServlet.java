package com.itwill.spring.mvc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
  1.클라이언트(웹브라우져)의 모든요청을 받는 서블릿작성
  2.확장자 *.do 인 모든클라이언트의 요청이 서블릿을 실행하도록 web.xml에 url pattern mapping 
  <<web.xml>>
  
  <servlet>
  	<servlet-name>dispatcher</servlet-name>
  	<servlet-class>com.itwill.spring.mvc.DispatcherServlet</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>dispatcher</servlet-name>
  	<url-pattern>*.do</url-pattern>
  </servlet-mapping>
 */
public class DispatcherServlet extends HttpServlet { // 최초요청시 객체생성, 두번째 부터는 서비스만 실행.이미 객체 생성했으므로
	private Map<String, Controller> handlerMapping;

	@Override
	public void init(ServletConfig config) throws ServletException { // init 생성자 다음에 바로실행된다.
		super.init(config);
		handlerMapping = new HashMap<String, Controller>();

		/*
			<< Map<String, Controller> handlerMapping>>
		 ------------------------------------------------ 
		 |key(String)	   |	  value(Controller객체) | 
		 ------------------------------------------------
		 |/guest_main.do   |com..GuestMainController객체|
		 ------------------------------------------------
		 |/guest_list.do   |com..GuestListController객체| 
		 ------------------------------------------------
		 |/guest_view.do   |com..GuestViewController객체|
		 ------------------------------------------------
		 */

		/********** 직접 생성 **********
		handlerMapping.put("/guest_main.do", new GuestMainController());
		handlerMapping.put("/guest_list.do", new GuestListController());
		handlerMapping.put("/guest_view.do", new GuestViewController());
		handlerMapping.put("/guest_write_form.do", new GuestWriteFormController());
		handlerMapping.put("/guest_write_action.do", new GuestWriteActionController());
		handlerMapping.put("/guest_remove_action.do", new GuestRemoveActionController());
		handlerMapping.put("/guest_modify_form.do", new GuestModifyFormController());
		handlerMapping.put("/guest_modify_action.do", new GuestModifyActionController());
		handlerMapping.put("/guest_error.do", new GuestErrorController());
		********** 직접 생성 **********/
		
		/***** 설정파일 (guest_controller_mapping.properties)을 읽어서 객체 생성  *****/
		ServletContext application = getServletContext();
		
		/*
		<<web.xml에설정된 파일이름 파라메타값 가져오기>>
		<servlet>
		    <servlet-name>dispatcher</servlet-name>
		    <servlet-class>com.itwill.spring.mvc.DispatcherServlet</servlet-class>
		    <init-param>
		    	<param-name>configFile</param-name>
		    	<param-value>/WEB-INF/guest_controller_mapping.properties</param-value>
		    </init-param>
		    <load-on-startup>0</load-on-startup>
	  	</servlet>
		*/
		
		String configFile = config.getInitParameter("configFile");
		String configFilePath=application.getRealPath(configFile);
		
		try {
			FileInputStream configFileInputStream=new FileInputStream(configFilePath);
			Properties controllerMappingProperties=new Properties();
			controllerMappingProperties.load(configFileInputStream);
			Set commandKeySet =controllerMappingProperties.keySet();
			// 엔트리의 set 키의 셋 여기서 키만받음
			Iterator<String> commandKeyIterator = commandKeySet.iterator();
			// System.out.println(commandKeyIterator);
			
			/*
			keySet(): Properties 객체의 모든 키(key)를 담은 Set 컬렉션을 반환합니다.
			Iterator: 컬렉션의 원소를 하나씩 순회하며 접근하기 위한 인터페이스입니다.
			hasNext(): Iterator가 다음 원소를 가지고 있는지를 확인하는 메서드입니다.
			next(): Iterator에서 다음 원소를 가져오는 메서드입니다.	 
			*/
			
			while (commandKeyIterator.hasNext()) {
				String Command = commandKeyIterator.next();
				String controllerClassName =  controllerMappingProperties.getProperty(Command);
				// System.out.println(Command + " --> " + controllerClassName);
				
				/*
				 Controller클래스이름을 사용해서 Controller 객체를 생성한다.
				 		1. Controller클래스이름을 사용해서 클래스를 메모리에 로딩한다.
				 		2. 메모리에 로딩된 클래스의 기본생성자를 호출해서 객체를 생성할수 있다.
				 				(기본생성자가 없으면 안된다는 말이다. 반드시 기본생성자 있어야 함!!)
				 */
				
				Class controllerClass = Class.forName(controllerClassName); // 이 클래스가 메모리에 로딩된다.
				// controllerClass 는 클래스의 정보를 담고있는 클래스다
				Controller controller = (Controller)controllerClass.newInstance(); 
				//하위타입 지칭하면 안됨. 그래서 상속구조를 만듬. 컨트롤러 자식이기만 하면 다 만들어줘야함
				// 클래스이름이 틀리면 로딩 자체가 안된다. java.lang.ClassNotFoundException 라는 에러가 발생함.
				System.out.println(Command + " ---> " + controller); // 주소가 출력된다.
				handlerMapping.put(Command, controller);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		/*
		 <<Properties객체>>
		 --------------------------------------------
		 |key(String)      |      value(String)     |
		 --------------------------------------------
		 |/guest_main.do   |com..GuestMainController|	
		  -------------------------------------------
		 |/guest_list.do   |com..GuestListController|		
		  -------------------------------------------
		 |/guest_view.do   |com..GuestViewController|		
		 --------------------------------------------	
		 */
		
		
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
		 * 1. DispatcherServlet이 클라이언트의 요청URI를 사용해서 요청분석
		 */
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		System.out.println(command);
		
		/*
		 * 2.DispatcherServlet이 클라이언트 요청에따른 비지니스실행할 Controller객체생성
		 */
		String forwardPath = "";
		Controller controller=handlerMapping.get(command);		
		forwardPath=controller.handleRequest(request, response);
		
		/*
		 * 3.DispatcherServlet이 forwardPath를 사용해서 forward 혹은 redirect를한다.
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
