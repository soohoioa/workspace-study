package com.itwill01.method;

public class Book {

	/*
	 * 
	 * <<속성>>
	 *  책번호
	 *  책제목
	 *  책분류
	 *  책설명
	 * 
	 * <<기능>>
	 *   
	 *   - 책정보출력
	 *   - 책정보대입
	 *   
	 */
	
	// <<속성>>
	int number; // 책 번호
	String name; // 책 제목
	int sort; // 책 분류
	String ex; // 책 설명
	
	// <<기능>>
	
	// - 책 정보대입
	void info (int number, String name, int sort, String ex) {
		this.number = number;
		this.name = name;
		this.sort = sort;
		this.ex = ex;
	}
	
	// - 책 정보 출력
	void headerPrint() {
		System.out.printf("---------- 책 정보를 출력합니다 ----------%n");
		System.out.printf("%s %5s %5s %5s %n", "책번호", "책제목", "책분류", "책설명");
		System.out.printf("------------------------------------------%n");
	}
	
	void print () {
		System.out.printf("%3d %8s %5d %7s %n", 
				this.number, this.name, this.sort, this.ex);
	}
	
}
