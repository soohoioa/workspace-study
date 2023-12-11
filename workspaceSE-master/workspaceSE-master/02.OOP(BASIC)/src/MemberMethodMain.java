
public class MemberMethodMain {

	public static void main(String[] args) {
		System.out.println("main block start");
		MemberMethod mm1 = new MemberMethod();
		mm1.member1 = 123;
		System.out.println("main stmt1");
		/*
		 * mm1은 참조변수
		 * . 는 연산자
		 * method1() 메소드이름
		 * 멤버 메소드 실행 (호출)
		 * 	- 형식 : 참조변수.메소드이름:식별자();
		 *  - main 실행흐름 mm1주소에 있는 객체의
		 *    method1 이라는 이름의 메소드(실행코드 여러개를 가지고 있는 실행블록 : 실행코드블록)보낸다. 
		 */
		mm1.method1(); // 호출하는 놈
		System.out.println("main stmt2");
		mm1.method2();
		System.out.println("main stmt3");
		mm1.method2();
		System.out.println("main stmt4");
		mm1.method3(3);
		/* mm1.method3();
		 * The method method3(int) in the type MemberMethod is not applicable for the arguments ()*/
		System.out.println("main stmt5");
		mm1.method3(5);
		System.out.println("main stmt6");
		mm1.method4("안녕하세요!!", 3);
		System.out.println("main stmt7");
		mm1.method4("오전수업 끝 식사 맛있게 하세요!!", 10);
		
		
		System.out.println("main block end");
		// 실행흐름 순으로 메세지를 전달 하고 전달 받음
		
		return;
		
		
		
	}

}
