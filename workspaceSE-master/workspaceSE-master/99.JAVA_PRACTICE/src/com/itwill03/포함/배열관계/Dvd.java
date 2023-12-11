package com.itwill03.포함.배열관계;

public class Dvd {

	/*
	 * - 캡슐화하세요
	 * - 생성자를 정의하세요
	 * 
	 * <<속성>>
	 *  번호
		타이틀
		쟝르
	 * 
	 * <<기능>>
	 *   Dvd정보출력
	 *   
	 */
	
	private int no;
	private String title;
	private String sort;
	
	public Dvd() {
		
	}

	public Dvd(int no, String title, String sort) {
		super();
		this.no = no;
		this.title = title;
		this.sort = sort;
	}
	
	public void print() {
		System.out.println(no + "\t" + title + "\t" + sort);
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

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	
	
	
	
	
	
}
