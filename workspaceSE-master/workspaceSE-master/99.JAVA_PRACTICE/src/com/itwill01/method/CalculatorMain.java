package com.itwill01.method;
/*
return << 호출한 클래스 (객체) 에게 반환할 값(변수를 쓰면 변수, 리터럴을 쓰면 리터럴, 연산의결과) >>
	- 호출한 곳으로 실행흐름을 반환
	- 호출한 곳으로 데이터 반환
	- 반환할 데이터가 없는 경우에는 (void) return 문이 생략이 가능하다.
	- 반환할 데이터가 있는 경우에는 (int, ...등) return문을  반드시 기술해야한다.
*/
public class CalculatorMain {

	public static void main(String[] args) {
		Calculator calculator=new Calculator();
		
		int result=calculator.add(23,34);
		System.out.println(result);
		
		result=calculator.sub(23,34);
		System.out.println(result);
		
		result=calculator.mul(23,34);
		System.out.println(result);
		
		result=calculator.div(45435,34);
		System.out.println(result);
		
		// 실행흐름반환, 실행흐름과 데이터 같이 반환
		// void는 반환을 안한다 했지만 return result; 은 값을 반환하므로 에러가 발생한다
		// 그래서 void 는 return 을 사용하고 return result;를 사용하고 싶으면 void가 아닌 int 를 써주면 된다.

		

	}

}
