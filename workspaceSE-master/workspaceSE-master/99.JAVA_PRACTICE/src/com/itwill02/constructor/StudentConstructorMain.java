package com.itwill02.constructor;

public class StudentConstructorMain {

	public static void main(String[] args) {
		/*
		 학생객체생성(3명)
		  - 1명은 기본생성자사용
			  학생객체기본데이타(번호, 이름, 국어, 영어, 수학) 입력메쏘드호출
		  - 2명은 인자5개 생성자사용
		 */
		Student st1 = new Student();
		st1.setStudentData(1, "윤자바", 66, 44, 97); // 기본생성자를 사용하여 학생 기본데이터 입력 메소드 호출
		Student st2 = new Student(2, "박자바", 87, 79, 66); // 인자5개 생성자를 사용하여 학생 기본데이터 입력 메소드 호출
		Student st3 = new Student(3, "홍자바", 45, 79, 33); // 인자5개 생성자를 사용하여 학생 기본데이터 입력 메소드 호출 
		
		
		
		/*
		 학생총점계산 메쏘드 호출(3명)
		 학생평균계산 메쏘드 호출(3명)
		 학생평점계산 메쏘드 호출(3명)
		 */
		// 총점 (3명)
		st1.calculateTotal(); // st1의 총점 계산 메소드 호출
		st2.calculateTotal(); // st2의 총점 계산 메소드 호출
		st3.calculateTotal(); // st3의 통점 계산 메소드 호출
		
		// 평균 (3명)
		st1.calculateAvg(); // st1의 평균 계산 메소드 호출
		st2.calculateAvg(); // st2의 평균 계산 메소드 호출
		st3.calculateAvg(); // st3의 평균 계산 메소드 호출
		
		// 평점 (3명)
		st1.calculateGrade(); // st1의 평점 계산 메소드 호출
		st2.calculateGrade(); // st2의 평점 계산 메소드 호출
		st3.calculateGrade(); // st3의 평점 계산 메소드 호출
		
		
		
		/*
		 * 학생데이타 출력메쏘드 호출(3명)
		 */
		st1.headerPrint(); // '학생 정보 출력' 헤드 메소드
		st1.print(); // st1 학생데이터 정보 출력 메소드 
		st2.print(); // st2 학생데이터 정보 출력 메소드
		st3.print(); // st3 학생데이터 정보 출력 메소드
		
		
		
		/*
		 * 학생 student1 의 이름변경한후(이름변경메쏘드호출후) student1학생객체출력
		 * 학생 student1 의 총점데이타 반환받은후 메인블록에서출력
		 * 학생 student1 의 학점데이타 반환받은후 메인블록에서출력
		 */
	

		st1.setName("김자바"); // 윤자바 -> 김자바로 이름을 변경
		st1.print(); // st1의 학생객체 출력
		System.out.println("st1의 총점 데이터 : " + st1.getTot()); 
		System.out.println("st1의 학점 데이터 : " + st1.getGrade()); 
	}

}
