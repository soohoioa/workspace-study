/*
제어문
   1. if 문
   
       -형식 : 
       
	      stmt0;
		  if(조건문){
		      //조건문 -->   논리형데이타가 반환되는 연산 혹은 논리형변수(데이타)
			  stmt1;
		   }else{
		      stmt2;
		   }
		   stmt3;

		   조건데이타가 true인경우  stmt0-->stmt1-->stmt3;
		   조건데이타가 false인경우  stmt0-->stmt2-->stmt3;
 */
public class IfTest1 {
	/*
	 * 코드 정렬 : ctrl + shift + f
	 */

	public static void main(String[] args) {
		System.out.println("main block start");
		System.out.println("stmt1");
		boolean condition = true;
		if (condition) {
			/*
			 * true 일때 실행블록
			 */
			System.out.println("stmt2");
			System.out.println("stmt3");
			System.out.println("stmt4");
		}

		System.out.println("stmt5");

		if (condition) {
			// true 일때 실행블록
			System.out.println("stmt6");
			System.out.println("stmt7");
		} else {
			// false 일때 실행블록
			System.out.println("stmt8");
			System.out.println("stmt9");
		}

		System.out.println("stmt10");

		if (condition) // 한줄이면 { } 없어도 가능
			System.out.println("stmt11");
		System.out.println("stmt12");

		if (condition)
			System.out.println("stmt13");
		else
			System.out.println("stmt14");
		System.out.println("stmt15"); // 항상실행
		// true 면 13-15 실행, false면 14-15 싷행 

		System.out.println("main block end");
		return; // 생략가능
		/*
		 * return; - 현재 return문을 실행하는 실행흐름을 호출한곳으로 반환한다. 
		 * - return문 생략가능
		*/
		
		/*
		compile error :  << Unreachable code >>
		System.out.println("after return stmt");
		*/
	}

}
