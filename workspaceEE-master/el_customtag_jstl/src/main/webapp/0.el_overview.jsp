<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.itwill.bean.User"%>
<%@page import="com.itwill.bean.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*********** String,Wrapper속성객체*********/
	request.setAttribute("a", new String("String 속성객체")); 
	request.setAttribute("b", new Integer(2));
	request.setAttribute("c", new Boolean(true));
	request.setAttribute("d", "String 속성객체");
	request.setAttribute("e", 3);
	request.setAttribute("f", false);
	
	/*********** 자바빈 속성객체****************/ // 일반자바객체를 자바빈 이라 함
	// List,Map,String,Wrapper 객체들을 제외한 나머지 객체들을 포함한다.
	// 빈들은 대부분 멤버필드를 가지고 있으며 멤버필드를 가지고 있는 객체들을 출력한다. 
	// 멤버필드를 속성이라 하고 그 속성들을 출력하는거다. 빈은 get,set 가 없으면 출력이 안된다.
	// 메소드는 실행코드일뿐  객체가 아니다.
	// 쉽게 말해 멤버객체를 가지고 있으며 도메인 등을 말함
	request.setAttribute("guest", new Guest(1, "KIM", "2023/10/02", "aaa@gmail.com", "http://www.naver.com", "타이틀", "컨텐트" ));
	request.setAttribute("user", new User("aaa", "111", "홍길동", "aaa@gmail.com"));
	
	/*********** List(array) 속성객체***********/ 
	List<Guest> guestList = new ArrayList<Guest>(); // 스콥객체 붙어야 출력가능
	guestList.add(new Guest(1, "KIM", "2023/10/02", "aaa@gmail.com", "http://www.naver.com", "타이틀1", "컨텐트1" ));
	guestList.add(new Guest(2, "OIM", "2023/10/02", "bbb@gmail.com", "http://www.naver.com", "타이틀2", "컨텐트2" ));
	guestList.add(new Guest(3, "VIM", "2023/10/02", "ccc@gmail.com", "http://www.naver.com", "타이틀3", "컨텐트3" ));
	request.setAttribute("guestList", guestList);
	/*
	List<Guest> zzzzzzz = new ArrayList<Guest>();
	request.setAttribute("guestList", zzzzzzz);
	" " 안에 들어가는 이름이 중요함. 틀리게 쓰거나 굳이 다르게 쓸 필요는 없다.
	zzzzzzz 는 중요한 부분이 아님. " " 가 중요함! 
	*/
	
	/*********** Map 속성객체*******************/
	Map<String, User> userMap = new HashMap<String, User>(); // 스콥객체 붙어야 출력가능
	userMap.put("aaa", new User("aaa", "111", "홍길동1", "aaa@gmail.com"));
	userMap.put("bbb", new User("bbb", "222", "홍길동2", "aaa@gmail.com"));
	userMap.put("ccc", new User("ccc", "333", "홍길동3", "aaa@gmail.com"));
	request.setAttribute("userMap", userMap);
	
	// 여기까지 속성객체로 사용할수 있는 것들을 모두 기술함.
	
	
	/*********** JSP local변수[EL출력대상객체아님]******************/
	String str1 = "난 JSP 로칼 변수";
	int int1 = 1234;
	User user1 =  new User("KING", "1111", "왕왕", "king@gmail.com"); 
	/*
	만약 로칼변수를 출력하고 싶다면 <% 로 % 를 사용해야함.
	*/
		
	/*
	속성(attribute)객체
		- 속성객체이름: a,b,c,d,e,f,guest,user,guestList,userMap
	*/


%>    

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL(Expression Language)</h1><hr>
<ul>
	<li>#########NO EL(EL을 사용하지않았을때)##########</li>
	<li>***********[1] String,Wrapper속성객체출력*****************</li>
	<li><%=request.getAttribute("a") %></li>
	<li><%=request.getAttribute("b") %></li>
	<li><%=request.getAttribute("c") %></li>
	<li><%=request.getAttribute("d") %></li>
	<li><%=request.getAttribute("e") %></li>
	<li><%=request.getAttribute("f") %></li>

	<li>***********[2] 자바빈 속성객체출력*************************</li>
	<li><%=request.getAttribute("guest") %></li>
	<li><%=((Guest)request.getAttribute("guest")).getGuest_no() %></li>
	<li><%=((Guest)request.getAttribute("guest")).getGuest_name() %></li>
	<li><%=((Guest)request.getAttribute("guest")).getGuest_email() %></li>
	<li><%=((Guest)request.getAttribute("guest")).getGuest_homepage() %></li>
	
	<li>***********[3] List(array)속성객체출력*********************</li>
	<li><%=(List<Guest>)request.getAttribute("guestList") %></li>
	<li><%=((List<Guest>)request.getAttribute("guestList")).get(0) %></li>
	<li><%=((List<Guest>)request.getAttribute("guestList")).get(0).getGuest_no() %></li>
	<li><%=((List<Guest>)request.getAttribute("guestList")).get(0).getGuest_name() %></li>
	<li><%=((List<Guest>)request.getAttribute("guestList")).get(0).getGuest_email() %></li>
	<li><%=((List<Guest>)request.getAttribute("guestList")).get(0).getGuest_homepage() %></li>
	
	<li>***********[4] Map 속성객체출력****************************</li>
	<li><%=request.getAttribute("userMap") %></li>
	<li><%=((Map<String,User>)request.getAttribute("userMap")).get("aaa") %></li>
	<li><%=((Map<String,User>)request.getAttribute("userMap")).get("aaa").getUserId() %></li>
	<li><%=((Map<String,User>)request.getAttribute("userMap")).get("aaa").getPassword() %></li>
	<li><%=((Map<String,User>)request.getAttribute("userMap")).get("aaa").getName() %></li>
	<li><%=((Map<String,User>)request.getAttribute("userMap")).get("aaa").getEmail() %></li>
	
	<li>***********[5] JSP service안에선언된 local변수 EL로는 출력 불가능***********</li>
	<li><%=str1 %></li>
	<li><%=int1 %></li>
	<li><%=user1 %></li>
	<li><%=user1.getUserId() %></li>
	<li><%=user1.getPassword() %></li>

	
	<li>######### EL사용 ##########</li>
	<li>***********[1] String,Wrapper속성객체출력*****************</li>
	<li>${a}</li>
	<li>${b}</li>
	<li>${c}</li>
	<li>${d}</li>
	<li>${e}</li>
	<li>${f}</li>
	
	<li>***********[2] 자바빈 속성객체출력*************************</li>
	<li>${guest}</li>
	<li>${guest.guest_no}</li>
	<!-- 만약 이름이 틀리다면 javax.el.PropertyNotFoundException: 이런 오류가 발생한다. 그러므로 주의해서 이름 작성해야한다. -->
	<li>${guest.guest_name}</li>
	<li>${guest.guest_email}</li>
	<li>${guest.guest_homepage}</li>
	<li>${guest.getGuest_homepage()}</li> 
	<!-- 메소드로 작성해도 출력은 되지만 메소드로 작성할 이유가 없다.메소드로 출력하면 굳이 el로 사용할 이유가 없다. -->
	
	<li>***********[3] List(array)속성객체출력*********************</li>
	<li>${guestList}</li>
	<li>${guestList[0]}</li>
	<!-- 배열과비슷함. 바로 인덱싱하면된다. 인덱스 있는 것들은 바로 인덱싱으로 작성하면 된다. -->
	<li>${guestList[0].guest_no}</li>
	<li>${guestList[0].guest_name}</li>
	<li>${guestList[0].guest_email}</li>
	<li>${guestList[0].guest_homepage}</li>
	
	<li>***********[4] Map 속성객체출력****************************</li>
	<li>${userMap}</li>
	<li>${userMap['aaa']}</li>
	<li>${userMap['aaa'].userId}</li>
	<li>${userMap['aaa'].password}</li>
	<li>${userMap['aaa'].name}</li>
	<li>${userMap['aaa'].email}</li>
	
	<li>***********[5] JSP service안에선언된 local변수 EL로는 출력 불가능***********</li>
	<li>${str1}</li>
	<li>${int1}</li>
	<li>${user1}</li>
	<li>${user1.getUserId()}</li>
	<li>${user1.userId}</li>
	<!-- 널이라 아무것도 안뜸. el에서 값이 없더라도 널이 출력되지는 않는다.-->
	
	
</ul>
</body>
</html>








