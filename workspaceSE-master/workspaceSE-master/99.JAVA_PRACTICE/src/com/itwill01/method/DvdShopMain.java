package com.itwill01.method;

public class DvdShopMain {

	public static void main(String[] args) {
		/*
		 * Dvd객체생성
		 */
		Dvd d1 = new Dvd();
		Dvd d2 = new Dvd();
		Dvd d3 = new Dvd();
		
		
		/*
		 * Dvd정보대입메쏘드호출
		 */
		d1.info(12, "기생충", "드라마");
		d2.info(34, "어벤져스", "액션");
		d3.info(56, "검사", "공포");
		
		
		/*
		 * Dvd정보출력메쏘드호출
		 */
		d1.hearderPrint();
		d1.print();
		d2.print();
		d3.print();
		

	}

}
