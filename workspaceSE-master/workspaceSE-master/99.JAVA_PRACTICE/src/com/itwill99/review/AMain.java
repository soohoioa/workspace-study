package com.itwill99.review;
/*
 * 2-1.AMain 클래스에 메인메쏘드 작성(생성)

	2-1-1.메인메쏘드에 코드작성
      	- A객체생성		 
  		- A객체멤버변수에 값대입
		- A객체멤버변수의 값출력
 */

public class AMain {

	public static void main(String[] args) {
		
		// - A객체생성	
		A a = new A();
		
		// - A객체멤버변수에 값대입
		a.no = 1;
		a.name = "KIM";
		
		// - A객체멤버변수의 값출력
		System.out.println("a.no 값 : " + a.no);
		System.out.println("a.name 값 : " + a.name);

	}

}
