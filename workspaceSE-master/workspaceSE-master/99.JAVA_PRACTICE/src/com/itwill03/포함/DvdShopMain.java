package com.itwill03.포함;

public class DvdShopMain {

	public static void main(String[] args) {
		
		/*
		 * 회원객체생성
		 */
		DvdMember dvdMember = new DvdMember(9876, "김자바", "010-1234-5678", null);
		
		/*
		 * Dvd객체생성
		 */
		Dvd dvd1 = new Dvd(111, "검사외전", "범죄");
		
		/*
		 * 회원이Dvd을 대여
		 * 
		 * Dvd객체참조변수를 회원의 멤버변수에대입
		 */
		dvdMember.setRentDvd(dvd1);
		
		/*
		 * 회원정보출력(회원이빌린Dvd정보출력)
		 */
		dvdMember.memPrint();
		
	}

}
