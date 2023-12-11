/*
 * 클래스의 구성요소
 *   1.멤버필드(변수)[속성]:객체생성시 속성데이타를 저장할변수
 *   2.멤버메쏘드
 */
// 실행흐름이 없으면 실행되지않음

public class MemberMethod { //현재 여기서는 흐름만 반환하고 있다. 
	int member1; // 멤버필드
	// 메인블록도 메소드
	
	// 실행블록
	void method1(){ // 기능블럭
		System.out.println("\t -- void method1()실행시작 ---");
		System.out.println("\t method1 stmt1");
		System.out.println("\t method1 stmt2");
		System.out.println("\t -- void method1()실행끝   ---");
		return;
		/*
		 << return >>
		 - 모든 메소드 블록의 마지막 실행흐름을 호출한곳으로 반환하여야 한다(되돌려준다)
		 실행흐름을 호출한 곳으로 반환하는 문장이 return문 이다.
		 return문을 만나면 실행흐름이 호출한곳으로 반환(되돌려준다)된다.
		  -->> 여기서는  mm1.method1(); 에서 들어가서 실행이 완료되면 다시 mm1.method1();으로 반환한다
		 return type이 void 인 경우에는 생략이 가능하다.
		 return 문이 생략된 경우에는 컴파일러가 자동으로 return문을 삽입하여준다
		  -->> void 가 아닌경우에는 생략할수없다. 
		 */
	}
	
	
	void method2() { // void는 실행흐름만 반환
		System.out.println("\t -- void method2()실행시작 ---");
		System.out.println("\t method2 stmt1");
		System.out.println("\t method2 stmt2");
		System.out.println("\t -- void method2()실행끝   ---");
		return;
		
	}
	
	/******* 매개변수(parameter)가 있는 메소드의 정의 *******/
	void method3(int count) { //int count 도 로컬변수, 호출하자마자 선언, 호출시 받는 인자이므로 () 안에 선언되어야 함
		System.out.println("\t ---void method3(int count)--- 실행");
		int locaVariable1 = 888; // 메소드 안 로컬변수는 이곳 안에서만 사용가능하다. 
		boolean locaVariable2 = false;
		
		System.out.println("\t method3 메소드블록안에서 선언된 로컬변수1" + locaVariable1);
		System.out.println("\t method3 메소드블록안에서 선언된 로컬변수2" + locaVariable2);
		
		for (int i = 0; i < count; i++) {
		System.out.println("\t void method3(int count) 실행 : 매개변수(parameter) count 값 -> " + count);
		}
		
		System.out.println("\t ---void method3()--- 실행종료후 실행흐름반환");
		return;
	}
	
	void method4(String msg, int count) { // 매개변수 순서데로 넣어야함
		// void method4(String msg, int count) 이것을 메소드의 정의라 함
		// 인자와 인수의 갯수 제한은 없으나 적을수록 좋음
		System.out.println("\t void method4(String msg, int count) -- 실행");
		for(int i = 0; i < count; i++) {
			System.out.println("\t\t" + msg);
		}
		

		System.out.println("\t void method4(String msg, int count) -- 종료후 실행흐름반환");
		return;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
