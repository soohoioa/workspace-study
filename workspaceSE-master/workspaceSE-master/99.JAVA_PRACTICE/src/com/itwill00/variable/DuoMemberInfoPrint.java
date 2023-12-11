package com.itwill00.variable;
public class DuoMemberInfoPrint {

	public static void main(String[] args) {

		int number;
		String name;
		String securityNumber;
		char gender;
		int marry;
		boolean smoke;
		double height;
		char grade;
		char face;
		
		number = 236514;
		name = "홍길동";
		securityNumber = "201212-3495039";
		gender = '남';
		marry = 0;
		smoke = true;
		height = 178.3;
		grade = 'A';
		face = '상';
		
		// 출력예시 1
		System.out.println("*************************"); 
		System.out.println("회원번호 : " + number);
		System.out.println("이    름 : " + name); 
		System.out.println("주민번호 : " + securityNumber); 
		System.out.println("성    별 : " + gender); 
		System.out.println("결혼횟수 : " + marry); 
		System.out.println("흡연여부 : " + smoke); 
		System.out.println("키       : " + height); 
		System.out.println("학    점 : " + grade); 
		System.out.println("용    모 : " + face); 
		System.out.println("*************************"); 
		
		
		// 출력예시 2
		System.out.println("*****************************************************************************************************"); 
		System.out.println("회원번호      이름        주민번호       성별    결혼횟수      흡연여부      키      학점    용모");
		System.out.println("*****************************************************************************************************"); 
		System.out.println(   number + "       " + name + "     " + securityNumber + "    " + gender + "        " + marry + "            " + smoke + "       " + height + "      " + grade + "      " + face);

	}

}
