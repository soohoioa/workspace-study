package com.itwill03.포함.배열관계;

public class BookLibraryMain {

	public static void main(String[] args) {
		/*
		 * 회원객체생성
		 */
		BookMember bookMember = new BookMember(1111, "GOO", "333-9090");
		
		bookMember.print();
		/*
		 * 책객체들생성
		 */
		Book[] rentbooks = {
			new Book(1, "JAVA", "시", "좋은책"),
			new Book(2, "SPRING", "소설", "멋진책"),
			new Book(3, "OOP", "에세이", "어려운책")			
		};
		
		
		/*
		 * 회원이 책들[] 대여
		 * 
		 * 책객체들[] 배열의미  참조변수를 회원의 멤버변수에대입
		 */
		bookMember.setBooks(rentbooks);
		
		
		/*
		 * 회원정보출력(회원정보와 회원이빌린들책정보출력)
		 */
		bookMember.print();		
		

	}

}
