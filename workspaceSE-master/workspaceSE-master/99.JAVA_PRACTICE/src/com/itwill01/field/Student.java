package com.itwill01.field;
/*
 * 성적처리를위해 필요한 학생객체를 만들기위한클래스정의(틀,타입)
 */
public class Student {

	/*
	 * 1.멤버필드(변수)선언:속성
	 *   -번호,이름,국어,영어,수학,총점,평균,평점(A,B,C,D,F),석차
	 *    를 저장할 멤버필드(변수) 선언
	 */
	
	int no; // 번호
	String name; // 이름
	int kor;  // 국어
	int eng;  // 영어
	int math; // 수학 
	int tot; // 총점
	double avg; // 평균
	char grade; // 평점(A,B,C,D,F) 
	int rank; // 석차
	
}
