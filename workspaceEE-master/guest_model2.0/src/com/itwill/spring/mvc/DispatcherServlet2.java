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
public class DispatcherServlet2 extends HttpServlet { // 최초요청시 객체생성, 두번째 부터는 서비스만 실행.이미 객체 생성했으므로
	/*
	 DispatcherServlet 클래스가 HttpServlet 클래스를 상속받는다. HttpServlet 는 웹 요청을 처리하는 서블릿을 작성하기 위한 기반 클래스이다.
	 */
	private Map<String, Controller> handlerMapping;
	/*
	 handlerMapping 은 요청 경로와 그에 해당하는 컨트롤러 객체를 매핑하기 위한 맵이다. 
	 이 맵은 초기화시점에 설정, 요청이 들어올 때 해당 경로에 맞는 컨트롤러를 찾아 실행하게 된다.
	*/
	
	@Override
	public void init(ServletConfig config) throws ServletException { // init 생성자 다음에 바로실행된다.
		/*
		 public void init(ServletConfig config) throws ServletException 는 서블릿 클래스에서 오버라이딩 할수있는 메소드중 하나로,
		 서블릿 초기화시 호출되는 메소드이다. 이 메소드를 오버라이딩 하여 서블릿 초기화 작업을 수행할수있다.
		 	- ServletConfig 객체는 서블릿의 초기화 매개변수 및 설정정보에 접근하기 위한 인터페이스이다. 
		 	  서블릿 컨테이너는 이 객체를 생성하여 init 메소드에 전달한다.
		 	- throws ServletException 부분은 메소드가 ServletException 예외를 던질수 있음을 나타내며, 
		 	  초기화 과정에서 예외가 발생할 수 있는 경우에 대비한것이다.
		 
		 init 메소드는 서블릿 초기화 시에 호출되는 메소드이다. 이 메소드 내부에서는 handlerMapping 맵을 초기화 하는 작업을 수행한다.
		 ServletConfig 매개 변수를 통해 서블릿의 설정정보에 접근할수있다.
		 */
		super.init(config); // 상위 클래스인 HttpServlet의 init 메서드를 호출하여 초기화 작업을 수행한다.
		handlerMapping = new HashMap<String, Controller>();
		/*
		 handlerMapping 은 HashMap 타입의 변수로, 요청 경로를 문자열String 로 매핑하며, 매핑된 값은 Controller 타입의 객체이다.
		 String: 이 해시맵의 키(key)의 타입으로, 클라이언트의 요청 경로(URL)를 나타낸다. 
		 Controller: 이 해시맵의 값(value)의 타입으로, 요청 경로에 매핑되는 컨트롤러 객체를 나타넨디.
		 		 
		 handlerMapping 맵을 생성하고, 요청경로와 컨트롤러 객체를 매핑할 준비한다.
		 각 요청 경로에 해당하는 컨트롤러를 Controller 타입으로 매핑하게 된다.
		 */
		
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
		 ServletContext : 이 객체는 웹 애플리케이션의 컨텍스트를 나타내는 인터페이스이다. 
		 				  웹 애플 내의모든 서블릿들이 이 객체를 통해 서로 정보를 공유하고 애플리케이션 레벨의 기능을 사용할 수 있다.
		 getServletContext() : 이 메소드는 현재 서블릿의 ServletContext객체를 반환한다.
		 				       모든 서블릿 인스턴스는 해당 메소드를 호출, 자신의 ServletContext 객체에 접근할수있다.
		 getServletContext() 를 호출하여 ServletContext 객체를 얻으면 웹 애플 내에서 다양한 정보와 기능을 활용할수있다.
		 */
		
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
			// entrySet()과 keySet() 여기서 키만받음
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
