/*
 * 관계(비교)연산자
 *   - 형태: >, <, >=, <=, ==, !=
 *   - 관계연산의 결과값은 논리형데이타(true,false)
 */

public class OperatorRelational {

	public static void main(String[] args) {

		int a = 10;
		int b = 20;
		boolean result = a > b;
		System.out.println("10 > 20 --> " + result);
		result = a < b;
		System.out.println("10 < 20 --> " + result);
		result = a >= b;
		System.out.println("10 >= 20 --> " + result);
		result = a <= b;
		System.out.println("10 < +20 --> " + result);
		result = a == b;
		System.out.println("10 == 20 --> " + result);
		result = a != b;
		System.out.println("10 != 20 --> " + result);
		
		
		
		System.out.println("---------- 문자비교 ----------");
		
		char ca = 'a';
		char cb = 'b';
		result = ca > cb;
		System.out.println(" 'a' > 'b' --> " + result);
		
		char ch1 = '가';
		char ch2 = '나';
		result = ch1 < ch2;
		System.out.println(" '가' < '나' --> " + result);
		
		
		
		
		
		
		
	}

}
