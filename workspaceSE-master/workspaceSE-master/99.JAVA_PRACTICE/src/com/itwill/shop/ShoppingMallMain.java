package com.itwill.shop;

public class ShoppingMallMain {

	public static void main(String[] args) {
		
		/*
		 * 객체들생성
		 */
		Member m1=new Member();
		Product p1=new Product();
		
		/*
		 * 객체들정보출력
		 */
		m1.info(12345, "홍길동", "서울시 강남구");
		p1.info(01, "헤어드라이기", 100000);
		
		m1.headerPrint();
		m1.print();
		
		System.out.println();
		
		p1.headerPrint();
		p1.print();
		
		
	}
}
