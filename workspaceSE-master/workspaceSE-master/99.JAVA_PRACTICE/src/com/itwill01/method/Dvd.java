package com.itwill01.method;

public class Dvd {

	/*
	 * <<속성>>
	    Dvd 번호
		Dvd타이틀
		Dvd쟝르
	 * 
	 * <<기능>>
	 *   - Dvd정보대입
	 *   - Dvd정보출력
	 *   
	 */
	
	
	// <<속성>>
	int num;
	String title;
	String gener;
	
	// <<기능>>
	// dvd 정보 대입
	void info (int num, String title, String gener) {
		this.num = num;
		this.title = title;
		this.gener = gener;
	}
	
	// dvd 정보 출력
	void hearderPrint() {
		System.out.printf("---------DVD 출력--------%n");
		System.out.printf("%S %S %S  %n", "DVD번호", "DVD타이틀", "DVD장르");
		System.out.printf("------------------------%n");
	}
	
	void print () {
		System.out.printf("%d, %s, %s %n", this.num, this.title, this.gener);
	}
}
