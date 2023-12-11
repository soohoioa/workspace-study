<%@page import="java.net.URLEncoder"%>
<%@page import="com.itwill.user.User"%>
<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	/*
		0  . GET방식요청일때 user_main.jsp로 redirection
		1  . 요청객체 인코딩설정 -> 필터설정해서 굳이 할필요 없다.
	    2  . 파라메타 받기 -> 비밀번호 확인은 받은필요없다. 유효성체크때문에 해준것일뿐.  
	    3  . UserService객체생성
	    4  . UserService.create() 메쏘드실행
	    5-1. 아이디중복이면 user_write_form.jsp  
	    5-2. 가입성공이면   user_login_form.jsp 로 redierction
	*/
	
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("user_main.jsp");
		return;
	}
	String userId = request.getParameter("userId");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	User newUser=new User(userId,password,name,email);
	
	UserService userService=new UserService();
	int result=userService.create(newUser);
	if(result ==-1){
		/* 아이디 중복 */
		/***************** case1 script **************
		String msg=URLEncoder.encode(userId+" 는 이미존재하는 아이디입니다.","UTF-8");
		password=URLEncoder.encode(password,"UTF-8");
		name=URLEncoder.encode(name,"UTF-8");
		email=URLEncoder.encode(email,"UTF-8");

		String queryString = "msg="+msg+"&userId="+userId+"&password="+password+"&name="+name+"&email="+email;
		out.println("<script>");
		out.println(" 	alert('"+msg+"');");
		out.println(" 	location.href='user_write_form.jsp?"+queryString+"';");
		out.println("</script>");
		*********************************************/
	
		/***************** case2 Redirect **************
		response.sendRedirect("user_write_form.jsp?" + queryString); 
			Redirect 하면 바디데이터가 없다. 
			실행해보면 회원가입후 다시 같은 아이디로 회원가입 시 아무것도 안나온다. 
			그래서 메세지를 뿌려주는 case 로 이동; 
		************************************************/
		
		/****************case3 forward*********************/
		String msg=userId+" 는 이미존재하는 아이디입니다.";
		request.setAttribute("msg", msg);
		request.setAttribute("fuser", newUser); //서블릿들은 데이터를 저장할수 었기에 이런 데이터들이 있어야한다.
		// 서블릿이 데이터를 저장할수 없는 이유는 멤버필드가 없기때문이다.
		
		RequestDispatcher rd = request.getRequestDispatcher("user_write_form.jsp");
		rd.forward(request, response);
		/***************************************************/
		
		
		return;
	} else if(result ==1){ // 두가지가 잇는경우에는 else 대신 boolean 을 사용해도 상관없다.
		// 가입 성공
		response.sendRedirect("user_login_form.jsp");
		return;
	}
	
%>
