package com.itwill03.포함;

public class BookMember {

	/*
	- 캡슐화
	
	<<속성>>
	 회원번호
	 회원이름
	 전화번호
	 빌린책
	*/
	private int no;
	private String name;
	private String phoneNumber;
	private Book book;
	
	public BookMember() {
		
	}

	public BookMember(int no, String name, String phoneNumber) {
		super();
		this.no = no;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public BookMember(int no, String name, String phoneNumber, Book book) {
		super();
		this.no = no;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.book = book;
	}

	
	/*
	<<기능>>
	  회원정보출력 
	 */
	public void print() {
		System.out.println(no + "\t" + name + "\t" + phoneNumber);
		if(book != null) {
			System.out.print(">> 빌린책 : ");
			book.print();
		} else {
			System.out.println(">> 빌린책 없다.");
		}
	}
	
	
	// getter, setter
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Book getBook() {
		return book;
	}

	public void setRentBook(Book book) {
		this.book = book;
	}
	
	
	
//	private int memberNo;
//	private String memberName;
//	private String memberPhone;
//	private Book book1;
//	private Book book2;
//	
//	public BookMember() {
//		
//	}
//
//	public BookMember(int memberNo, String memberName, String memberPhone, Book book1, Book book2) {
//		this.memberNo = memberNo;
//		this.memberName = memberName;
//		this.memberPhone = memberPhone;
//		this.book1 = book1;
//		this.book2 = book2;
//	}
//	
//	private Book rentBook;
//	
//	
//	/*
//	<<기능>>
//	  회원정보출력 
//	 */
//	public void memberPrint() {
//		System.out.println("회원번호 : " + memberNo + "\n" + "회원이름 : " + memberName + "\n" + "회원연락처 : " + memberPhone);
//		book1.bookPrint();
//		book2.bookPrint();
//	}
//
//	
//	public int getMemberNo() {
//		return memberNo;
//	}
//
//	public void setMemberNo(int memberNo) {
//		this.memberNo = memberNo;
//	}
//
//	public String getMemberName() {
//		return memberName;
//	}
//
//	public void setMemberName(String memberName) {
//		this.memberName = memberName;
//	}
//
//	public String getMemberPhone() {
//		return memberPhone;
//	}
//
//	public void setMemberPhone(String memberPhone) {
//		this.memberPhone = memberPhone;
//	}
//
//	public Book getBook1() {
//		return book1;
//	}
//
//	public void setBook1(Book book1) {
//		this.book1 = book1;
//	}
//
//	public Book getBook2() {
//		return book2;
//	}
//
//	public void setBook2(Book book2) {
//		this.book2 = book2;
//	}
	
}
