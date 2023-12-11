package com.itwill03.포함;

public class BookLibraryMain {
	public static void main(String[] args) {
		
		/*
		 * 회원객체생성
		 */
		// BookMember member1 = new BookMember(9999, "홍자바", "010-1234-5678", null, null);
		BookMember bookmember = new BookMember(1, "KIM", "010-1234-5678");
		// BookMember bookmember = new BookMember(1, "KIM", "010-1234-5678", null); -->> 책 정보를 null 로 넣어도 되고 안넣어도 되고
		
		
		/*
		 * 책객체생성
		 */
		// Book book1 = new Book(1111, "혼자공부하는자바", "A-1", "전공서적");
		// Book book2 = new Book(2222, "혼자공부하는파이썬", "B-1", "전공서적");
		Book rentBook = new Book(123, "자바바", "IT", "나자바바라!");
		
		
		/*
		 * 회원이 책들 대여
		 * 
		 * 책객체참조변수를 회원의 멤버변수에대입
		 */
		// member1.setBook1(book1);
		// member1.setBook2(book2);
		bookmember.setRentBook(rentBook);
		
		
		/*
		 * 회원정보출력(회원정보와 회원이 빌린책들 정보출력)
		 */
		// member1.memberPrint();
		bookmember.print();
		
		
	}
}
