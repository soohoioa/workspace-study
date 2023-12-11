package com.itwill99.cls;

public class Abc { 
	
	// Q1. 멤버 변수 정의
	String name;
	int abcf;
	int defdd; 
	// 클래스로 부터 찍어낸 객체가 가져야할 데이터를 저장할 변수를 선언
	// 멤버변수 3개가 정의되어 있다.
	
	// 메소드는 실행코드 블록이다
	
	
	void coffee() {
		// coffee 라는 이름을 줌
		// 기능적인 이름을 작성해줘야 함 , 블록 내용과 이름이 다르면 보기 불편함.
		// 메소드의 블록 크기는 적을수롣 좋음
		// 크기가 많으면 여러가지 기능을 함꺼번에 담을수 잇고 한꺼번에 담으면 안된다.
		// ( ) 변수가 들어가면 변수가 들어가고 없ㅇ면 작성 안한다
		// void : 기능이 실행되고 호출한 놈에게 줄 데이터의 타입을 기입한다. 
		// void는 들어갈 데이터 타입이 없을 때 작성할수 있다.
		// 객체기능들은 필요할때마다 호출
		// 대부분 자신이 갖고있는 멤버 변경
		System.out.println("--오늘은 즐거운 금요일 불금!!--");
		System.out.println("--어제는 즐거운 목요일!!--");
		System.out.println("--내일은 즐거운 토요일!!--");
	}
	
	
	// Q5. 반환타입 void , 인자1개(타입은 상관없음) 받을수 있도록 메소드 정의
	// 블록 내용은 받은 데이터를 출력하세요
	void b (int arg) { // 여기서  arg는 호출시에 만들어짐
		System.out.println("b()" + arg);
		// 여기서 return; 은 생략되어있다
	}
	
	void add (int i) {
		System.out.println(i + 5678);
	}
	
	
	int c (int no) {
		return no+1;
	} // void가 아닌 int 이므로 return 이 필요하다.
	
	
	
	
	/**********************************************/
	
	String a;
	int b;
	int c;
	
	void setA (String a) { 
		// a 멤버를 세팅하는 행위
		this.a = a;
	} 
	
	void print () {
		System.out.println(this.a);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
