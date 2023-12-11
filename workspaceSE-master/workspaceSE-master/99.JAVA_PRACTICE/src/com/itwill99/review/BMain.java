package com.itwill99.review;

/*
 * 2-1.BMain 클래스에 메인메쏘드 작성(생성)
		2-1-1.메인메쏘드에 코드작성
	  	- B객체생성
	  	- B객체멤버변수2개(x,y)에 값대입
	  	- B객체멤버변수2개의 값출력
	  	- B객체멤버메쏘드2개호출(m1,m2)
 */

public class BMain {

	public static void main(String[] args) {
		
		// 2-1.BMain 클래스에 메인메쏘드 작성(생성)
		
		// - B객체생성
		B b = new B();
		
		// - B객체멤버변수2개(x,y)에 값대입
		b.x = 1;
		b.y = "김자바";
		
		// - B객체멤버변수2개의 값출력
		System.out.println("b.x 의 값 : " + b.x);
		System.out.println("b.y 의 값 : " + b.y);
		
		// - B객체멤버메쏘드2개호출(m1,m2)
		b.m1();
		b.m2();
		
		
	}

}
