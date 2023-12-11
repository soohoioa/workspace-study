package com.itwill03.포함.배열관계;

public class BookMember {

	/*
	- 캡슐화
	
	<<속성>>
	 회원번호
	 회원이름
	 전화번호
	 빌린책들
	*/
	private int no;
	private String name;
	private String phoneNumber;
	private Book[] books;
	public BookMember() {
		
	}
	public BookMember(int no, String name, String phoneNumber) {
		super();
		this.no = no;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public BookMember(int no, String name, String phoneNumber,  Book[] books) {
		super();
		this.no = no;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.books = books;
	}
	
	
	
	public void setBooks(Book[] books) {
		this.books = books;
	}
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
	public void print() {
		System.out.println(no + "\t" + name + "\t" + phoneNumber);
		if(books != null) {
			System.out.println(">> 빌린책 : ");
			for (Book book : this.books) {
				book.print();
			}
		} else {
			System.out.println(">> 빌린책 없네요");
		}
	}
	
	
	/*
	<<기능>>
	  회원정보출력 
	 */
	
}
