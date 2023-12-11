package com.itwill99.review;

public class MemberFieldMain {

	public static void main(String[] args) {
	
		/*
		 * 1.MemberField객체생성
		 */
		MemberField memberField1 = new MemberField();
		
		
		/*
		 * 2.MemberField객체의 멤버변수4개에 데이타대입
		 */
		memberField1.number = 1;
		memberField1.name = "김자바";
		memberField1.okno = true;
		memberField1.ca = 'A';
		

		/*
		 * 3.MemberField객체의 4개멤버변수내용출력
		 */
		System.out.println(memberField1.number);
		System.out.println(memberField1.name);
		System.out.println(memberField1.okno);
		System.out.println(memberField1.ca);
		

	}

}
