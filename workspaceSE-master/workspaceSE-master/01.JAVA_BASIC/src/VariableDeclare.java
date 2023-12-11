public class VariableDeclare {
/*
	값(데이타)
		- 문자  : 김 , A , z
		- 문자열: "김경호", "JAMES" , "Student"
		- 숫자  : 1, 2 , 3 , 3.14159
*/
/*
	변수의선언
       - 의미:JVM 에게메모리를할당해달라고 요청하는작업
	   - 형태:
	        데이타타입 이름(식별자);
	         ex> int number;

	   - 변수식별자규직(클래스이름,변수이름,메쏘드이름)
	   - 영문이나,한글로시작
	   - 특수문자사용불가(_,$ 는 사용가능)
	   - 키워드 사용금지
*/
	
	public static void main(String[] args) {
		int score1; // 변수의 선언
		score1 = 100; // 변수의 값(정수형리터럴)을 대입
		System.out.println(score1); // 변수값을 출력
		score1 = 89;
		System.out.println(score1);
		
		int score2 = 90;
		System.out.println(score2);
		
		score2 = 99;
		System.out.println(score2);
		
		int _number = 333;
		int $number = 444;
		int 번호 = 555;
		System.out.println(_number);
		System.out.println($number);
		System.out.println(번호);
		
		int kor,eng,math;
		kor = 90;
		eng = 89;
		math = 99;
		System.out.println(kor);
		System.out.println(eng);
		System.out.println(math);
		
		/*
		<< Duplicate local variable kor >>
		중복 변수 선언
		int kor = 99; 
		*/
		
		/*
		<< history cannot be resolved to a variable >>
		history = 80;
		 */
		
		/*
		int 7up;
		int my-score;
		int your score;
		*/
		
		String name;
		name = "김숙현";
		System.out.println(name);
		
		// ctrl + F11 : 실행
		// F2 : 이름변경
		// sysout + ctrl + space : 자동완성
		// ctrl + Alt + up/down : 한줄 복사
		// 리터럴 literal : 소스코드 내에서 직접 입력된 값 
		// = 대입연산자 : 오른쪽의 값을 왼쪽의 변수에 저장
		// 변수는 블록 내 어디서든 선언할수 있지만 
		// 변수는 자신이 선언된 위치로부터 자신이 속한 블록 내부에서만 사용할수 있다
		// int 4바이트
	}

}
