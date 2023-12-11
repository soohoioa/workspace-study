package com.itwill01.method;

public class StudentMemberMethodMain {

	public static void main(String[] args) {
		/*
		학생객체생성(3명)
		*/
		Student st1 = new Student();
		Student st2 = new Student();
		Student st3 = new Student();
		
			
		/*
		 학생객체기본데이타(번호, 이름, 국어, 영어, 수학) 대입메쏘드호출(3명)
		 */
		st1.student(1, "김경호", 42, 56, 78);
		st2.student(2, "김경수", 45, 53, 76);
		st3.student(3, "홍길동", 45, 51, 79);
		
		
		/*
		 학생총점,평균,평점 계산 메쏘드 호출(3명)
		 */
		st1.stSum();
		st2.stSum();
		st3.stSum();
		
		st1.stAvg();
		st2.stAvg();
		st3.stAvg();
		
		st1.stGrade();
		st2.stGrade();
		st3.stGrade();
		
		
		/*
		 * 학생데이타 출력메쏘드 호출(3명)
		 */
		st1.headerPrint();
		st1.print();
		st2.print();
		st3.print();
		
		/*
		- 출력포맷
 		- 평균은 소수점이하 첫째자리까지출력(반올림)
 		- 석차는 구하지마세요
		--------------학생 성적출력-------------------
		학번  이름   국어 영어 수학 총점 평균 평점 석차
		-----------------------------------------------
		 1   김경호   42   56   78   334  34.8  A   3  
		 2   김경수   45   53   76   334  34.8  A   2  
		-----------------------------------------------
		*/

	}

}
