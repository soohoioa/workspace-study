package com.itwill00.variable;

public class StudentScorePrint {

	public static void main(String[] args) {
		/*
		 * 성적관리에서 학생2명 데이타를 담을 변수선언
		 * 	- 번호, 이름, 국어, 영어, 수학, 총점, 평균, 평점(A(90~100),B(80~89),C(70~79),D(60~69),F(0~59)), 석차
		 */
		int no1, no2; // 번호 변수선언
		String name1, name2; // 이름 변수선언
		int kor1, kor2; // 국어 변수선언
		int eng1, eng2; // 영어 변수선언
		int math1, math2; // 수학 변수선언
		int sum1, sum2; // 총점 변수선언
		double avg1, avg2; // 평균 변수선언
		char grade1, grade2; // 평점 변수선언
		int rank1, rank2; // 석차 변수선언
		
		/*
		 * 학생 2명의 기본데이터(번호, 이름, 국어, 영어, 수학) 입력 
		 */
		
		no1 = 1;
		name1 = "김경호";
		kor1 = 42;
		eng1 = 56;
		math1 = 78;
	
		no2 = 2;
		name2 = "김경수";
		kor2 = 45;
		eng2 = 53;
		math2 = 76;
		
		/*
		 * 학생2명의 국어, 영어, 수학점수의 유효성체크
		 *   - 100점이 넘는 수나 음수가 입력되면 메세지를 출력하고 return(프로그램종료)한다.
		 */

		if (!(kor1 >= 0 && kor1 <= 100)) {
			System.out.println("국어점수는 유효한 점수가 아닙니다.");
		} else if (!(eng1 >= 0 && eng1 <= 100)) {
			System.out.println("영어점수는 유효한 점수가 아닙니다.");
		} else if (!(math1 >= 0 && math1 <= 100)) {
			System.out.println("수학점수는 유효한 점수가 아닙니다.");
		} else if (!(kor2 >= 0 && kor2 <= 100)) {
			System.out.println("국어점수는 유효한 점수가 아닙니다.");
		} else if (!(eng2 >= 0 && eng2 <= 100)) {
			System.out.println("영어점수는 유효한 점수가 아닙니다.");
		} else if (!(math2 >= 0 && math2 <= 100)) {
			System.out.println("수학점수는 유효한 점수가 아닙니다.");
			return; 
		}
		
		
		/*
		 * 학생 2명의 기본데이터(번호, 이름, 국어, 영어, 수학)를 이용해서
		 * 총점, 평균, 평점, 계산 후 대입 (석차는 0을 대입)
		 */
		
		// 총점
		sum1 = kor1 + eng1 + math1;
		sum2 = kor2 + eng2 + math2;
		
		// 평균
		avg1 = (double)sum1 / 3;
		avg2 = (double)sum2 / 3;
		
		// 석차
		rank1 = 0;
		rank2 = 0;
		
		// 평점
		grade1 = ' ';
		if (avg1 >= 90) {
			grade1 = 'A';
		} else if (avg1 >= 80) {
			grade1 = 'B';
		} else if (avg1 >= 70) {
			grade1 = 'C';
		} else if (avg1 >= 60) {
			grade1 = 'D';
		} else {
			grade1 = 'F';
		}
		
		grade2 = ' ';
		if (avg2 >= 90) {
			grade2 = 'A';
		} else if (avg2 >= 80) {
			grade2 = 'B';
		} else if (avg2 >= 70) {
			grade2 = 'C';
		} else if (avg2 >= 60) {
			grade2 = 'D';
		} else {
			grade2 = 'F';
		}
		
			
		/*
		- 출력포맷
 		- 평균은 소수점이하 첫째자리까지출력(반올림)
 		- 석차는 구하지마세요
		--------------학생 성적출력-------------------
		학번  이름   국어 영어 수학 총점 평균 평점 석차
		-----------------------------------------------
		 1   김경호   42   56   78   334  34.8  A   0  
		 2   김경수   45   53   76   334  34.8  A   0  
		-----------------------------------------------
		*/
		
		System.out.printf("--------------학생 성적출력-------------------\n");
		System.out.printf("학번  이름   국어 영어 수학 총점 평균 평점 석차\n");
		System.out.printf("-----------------------------------------------\n");
		System.out.printf("%3d %4s %3d %5d %5d %3d   %.1f %2c %3d \n",no1,name1,kor1,eng1,math1,sum1,avg1,grade1,rank1);
		System.out.printf("%3d %4s %3d %5d %5d %3d   %.1f %2c %3d \n",no2,name2,kor2,eng2,math2,sum2,avg2,grade2,rank2);
		
	}

}
