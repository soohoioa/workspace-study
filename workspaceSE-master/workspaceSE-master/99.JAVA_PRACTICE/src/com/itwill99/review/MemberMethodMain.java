package com.itwill99.review;

public class MemberMethodMain {

	public static void main(String[] args) {
		
		/*
		 * MemberMethod객체생성
		 */
		MemberMethod memberMethod1 = new MemberMethod();

		
		/*
		 * MemberMethodr객체 method1 호출
		 */
		System.out.println("---method1 호출---");
		memberMethod1.method1();
		
		/*
		 * MemberMethodr객체 method2 호출
		 */
		System.out.println("---method2 호출---");
		memberMethod1.method2();
		/*
		 * MemberMethod객체 method3 호출
		 */
		System.out.println("---method3 호출---");
		memberMethod1.method3(1);
		/*
		 * MemberMethodr객체 method4 호출
		 */
		System.out.println("---method4 호출---");
		memberMethod1.method4("김자바", 2);
		/*
		 * MemberMethodr객체 method5 호출
		 */
		System.out.println("---method5 호출---");
		memberMethod1.method5("김자바", "윤자바", 3);
		

	}

}
