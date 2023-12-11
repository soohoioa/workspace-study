package com.itwill.shop;

public class Member {

	// 온라인 쇼핑몰에 회원 로그인을 하고 쇼핑몰이 판매하고 있는 제품2개를 장바구니에담은 후에 주문을 한다

//		int no;
//		int name
//		int address;
//		void print(){
//		}
		// 회원 기본정보 메소드
		// 회원 기본정보 출력 메소드
		
		// 회원 로그인 
		
		

		// <<속성>>
		int no; // 회원 번호
		String name; // 회원 이름
		String address; // 회원 주소
		
		
		// <<기능>>
		// 회원 기본정보 메소드
		void info (int no, String name, String address) {
			this.no = no;
			this.name = name;
			this.address = address;
		}
		
		// 회원 기본정보 출력 메소드
		void headerPrint() {
			System.out.printf("------ 회원정보 ------ %n");
			System.out.printf("%s %s %s %n", "회원번호", "회원이름", "회원주소" );
			System.out.printf("---------------------- %n");
		}
		
		void print () {
			System.out.printf("%d %s %s %n", this.no, this.name, this.address);
		}
		
}
