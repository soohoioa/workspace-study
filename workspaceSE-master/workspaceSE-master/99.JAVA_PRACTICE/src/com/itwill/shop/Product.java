package com.itwill.shop;

public class Product {

	// 온라인 쇼핑몰에 회원 로그인을 하고 쇼핑몰이 판매하고 있는 제품2개를 장바구니에담은 후에 주문을 한다

//		int no;
//		int title
//		int price;
//		void print(){
//		}
		// 제품 기본정보 메소드
		// 제품 기본정보 출력 메소드
		
		// 추가 : 장바구니, 주문 
		
		

		// <<속성>>
		int no; // 제품 번호
		String title; // 제품 이름 
		int price; // 제품 가격
		
		
		// <<기능>>
		// 제품 기본정보 메소드
		void info (int no, String title, int price) {
			this.no = no;
			this.title = title;
			this.price = price;
		}

		// 제품 기본정보 출력 메소드
		void headerPrint() {
			System.out.printf("------ 제품정보 ------ %n");
			System.out.printf("%s %s %s %n", "제품번호", "제품이름", "제품가격" );
			System.out.printf("---------------------- %n");
		}
		
		void print () {
			System.out.printf("%d %s %s %n", this.no, this.title, this.price);
		}
		
}
