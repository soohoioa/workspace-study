package com.itwill01.method;

public class BookLibraryMain {

	public static void main(String[] args) {
		/*
		 * 책객체생성
		 */
		Book b1 = new Book();
		Book b2 = new Book();

		
		
		/*
		 * 책정보대입메쏘드호출
		 */
		b1.info(123, "햇님달님", 1-1, "오누이");
		b2.info(456, "신데렐라", 2-1, "호박마차");
		
		
		/*
		 * 책정보출력메쏘드호출
		 */
		b1.headerPrint();
		b1.print();
		b2.print();
		
	}
}
