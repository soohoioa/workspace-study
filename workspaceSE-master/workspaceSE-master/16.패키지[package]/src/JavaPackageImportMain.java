/*
 import java.lang.*; -> 모든 클래스에는 이 부분이 대부분 생략되어있음.
 
 import java.lang.String;
 import java.lang.Object;
 
 java.lang package 에 있는 클래스는 import 구문이 생략가능
 */


public class JavaPackageImportMain {

	public static void main(String[] args) {
		System.out.println("-----java.lang package -----");
		java.lang.String str1 = "임포트";
		String str2 = "홍길동";
		Object obj = new Object();
		System.out.println(Math.random());
			
		
		
	}

}
