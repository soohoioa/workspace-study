package com.itwill03.포함.배열관계;

public class DvdShopMain {

	public static void main(String[] args) {
		/*
		 * 회원객체생성
		 */
		DvdMember dvdmember1 = new DvdMember(111, "홍자바", "010-1234-5678");
		DvdMember dvdmember2 = new DvdMember(222, "김자바", "010-5896-2563");
		DvdMember dvdmember3 = new DvdMember(333, "윤자바", "010-1598-3574");
		
		
		/*
		 * Dvd들객체생성
		 */
		//Dvd dvd = new Dvd(1, "JAVA", "호러");
		Dvd d1 = new Dvd(1, "JAVA", "호러");
		Dvd d2 = new Dvd(2, "SPRING", "공포");
		Dvd d3 = new Dvd(3, "OOP", "미스터리");
		Dvd d4 = new Dvd(4, "ARRAY", "스릴러");
		Dvd d5 = new Dvd(5, "ECLIPSE", "로맨스");
		
		/*
		 * 회원이Dvd들을 대여
		 * - Dvd를 3개까지 대여할수있다.
		 * 
		 * Dvd객체배열 참조변수를 회원의 멤버변수에대입
		 */
		
		
		
		/*
		 * 회원정보출력(회원이빌린Dvd들정보출력)
		 */
		dvdmember1.print();
	}

}
