
public class MemberMethodReturn {
	/* 인스턴스 = 객체변수, 객체를 생성해야 사용할수있는 객체변수, 객체메소드
	객체를 선언하지 않고 사용할수있는 메소드 - 스택
	 클래스용도 - 객체찍을때(틀), 타입선언시
	 {클래스 : 틀이에요, 타입이에요} - > !!!!!외우시오!!!!!
	*/

	/*
	  멤버필드 = 멤버변수 같은말이지만 멤버필드라 부른다. 
	  	- 멤버필드 선언시 값을 대입할수있다.
	 */
	
	int memberField1  = 10;
	int memberField2  = 20;
	int memberField3  = 30; 
	
	/*
	  멤버 메소드 
	 */
	
	int method1() {	
		System.out.println("\t -----int method1() 실행-----");
		int result = 1 + 2; 
		System.out.println("\t -----int method1() 실행종료후 실행흐름반환-----");
		/*
		  return << 호출한 클래스 (객체) 에게 반환할 값(변수를 쓰면 변수, 리터럴을 쓰면 리터럴, 연산의결과) >>
		 	- 호출한 곳으로 실행흐름을 반환
		 	- 호출한 곳으로 데이터 반환
		 	- 반환할 데이터가 없는 경우에는 (void) return 문이 생략이 가능하다.
		 	- 반환할 데이터가 있는 경우에는 (int, ...등) return문을  반드시 기술해야한다.
		 */
		return result;
		// 실행흐름반환, 실행흐름과 데이터 같이 반환
		// void는 반환을 안한다 했지만 return result; 은 값을 반환하므로 에러가 발생한다
		// 그래서 void 는 return 을 사용하고 return result;를 사용하고 싶으면 void가 아닌 int 를 써주면 된다.
	}
	
	boolean method2() {
		System.out.println("\t --- boolean method2() 실행");
		boolean isMarried = false;
				// _ 는 되도록이면 사용안하는게 좋음
		System.out.println("\t --- boolean method2() 실행후 boolean데이터와 실행흐름 반환");
		return isMarried;
	}
	
	/*
	 * 두개의 정수를 파라메타로 받아서 더한 결과(정수)를 반환하는 메소드
	 */
	int add(int a, int b) {
		System.out.println("\t --- int add(int a, int b) --- 실행");
		int result = a + b;
		System.out.println("\t --- int add(int a, int b) --- 종료 후 데이터 반환");
		return result;
	}
	
	// 왼쪽이 정의 오른쪽이 호출
	
	/*
	 *  이름을 매개변수로 입력받아서 인사말을 만들어서 문자열로 반환하는 메소드
	 */
	
	String hello(String name) {
		String msg = name + " 님 안녕하세요!!";
		return msg;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
