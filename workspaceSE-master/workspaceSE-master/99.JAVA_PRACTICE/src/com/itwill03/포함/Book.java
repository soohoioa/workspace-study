package com.itwill03.포함;

public class Book {
	/*
	 * - 캡슐화하세요
	 * - 생성자를 정의하세요
	 * 
	 * <<속성>>
	 *  책번호
	 *  책제목
	 *  책분류
	 *  책설명
	 * 
	 * <<기능>>
	 *   책정보출력
	 *   
	 */
	private int no;
	private String title;
	private String genre;
	private String desc;
	
	public Book() {
		
	}

	public Book(int no, String title, String genre, String desc) {
		super();
		this.no = no;
		this.title = title;
		this.genre = genre;
		this.desc = desc;
	}
	
	public void print() {
		System.out.println("\t"+no+"\t"+title+"\t"+genre+"\t"+desc);
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
	
	
//	private int bookNo; 
//	private String bookTitle; 
//	private String bookSort; 
//	private String bookEx; 
//	
//	
//	public Book() {
//		
//	}
//	
//	public Book(int bookNo, String bookTitle, String bookSort, String bookEx) {
//		this.bookNo = bookNo;
//		this.bookTitle = bookTitle;
//		this.bookSort = bookSort;
//		this.bookEx = bookEx;
//	}
//	
//
//	
//	/* <<기능>>
//	 *   책정보출력
//	 *   
//	 */
//	public void bookPrint() {
//		System.out.println(bookNo + "\t" + bookTitle + "\t" + bookSort + "\t" + bookEx);
//	}
//
//	public int getBookNo() {
//		return bookNo;
//	}
//
//	public void setBookNo(int bookNo) {
//		this.bookNo = bookNo;
//	}
//
//	public String getBookTitle() {
//		return bookTitle;
//	}
//
//	public void setBookTitle(String bookTitle) {
//		this.bookTitle = bookTitle;
//	}
//
//	public String getBookSort() {
//		return bookSort;
//	}
//
//	public void setBookSort(String bookSort) {
//		this.bookSort = bookSort;
//	}
//
//	public String getBookEx() {
//		return bookEx;
//	}
//
//	public void setBookEx(String bookEx) {
//		this.bookEx = bookEx;
//	}
}
