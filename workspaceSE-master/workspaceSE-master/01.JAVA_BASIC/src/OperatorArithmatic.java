
public class OperatorArithmatic {
	
	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		int result = 0;
		
		result = a + b ; // 연산자중 가장 낮은 연산자는 = 대입연산자
		System.out.println("a + b --> " + result); 
		result = a - b ;
		System.out.println("a - b --> " + result); 
		result = a * b ;
		System.out.println("a * b --> " + result); 
		
		System.out.println();
		System.out.println("-----연산시의 형변환-----");
		result = a / b ; //형변환
		System.out.println("int result = a / b --> " + result); // int선언으로 계산시 소수점이하는 버리고 정수로만 표현
		double dresult = a / b;
		System.out.println("double dresult = a / b --> " + dresult);
		double dresult2 = (double) a /b ;
		System.out.println("double dresult2 = (double) a /b --> " + dresult2);
		
		
		
		/*
		 * 나머지연산자 
		 * %
		 */
		
		result = a % b;
		System.out.println("a % b --> " + result);
		
		int number = 16;
		result = number % 4;
		System.out.println("result 변수값이 0 이면 4의 배수 : " + result);
				
		int year = 2023;
		result = year % 4; // 0, 1, 2, 3
		System.out.println("2023 % 4 --> " + result);
		result = year % 100;
		System.out.println("2023 % 100 --> " + result);
		result = year % 400;
		System.out.println("2023 % 400 --> " + result);
		
		
		System.out.println();
		System.out.println("---------->> , << (비트연산자) ----------");
		/*
		 * 비트 연산자
		 * << , >> 
		 * 
		 */
		
		int i = 1;
		System.out.println(i);
		result = i << 1;
		System.out.println(result);
		result = i << 2;
		System.out.println(result);
		result = i << 3;
		System.out.println(result);
		result = i << 4;
		System.out.println(result);
		
		/*
		 * int d = 1;       ==> 00000000|00000000|00000000|00000001
		 * result = d << 1; ==> 00000000|00000000|00000000|00000010
		 * result = d << 2; ==> 00000000|00000000|00000000|00000100
		 * result = d << 3; ==> 00000000|00000000|00000000|00001000
		 * result = d << 4; ==> 00000000|00000000|00000000|00010000
		 */
		
		i = 128;
		System.out.println(i);
		result = i >> 1;
		System.out.println(result);
		result = i >> 2;
		System.out.println(result);
		result = i >> 3;
		System.out.println(result);
		result = i >> 4;
		System.out.println(result);
		
		
		System.out.println();
		System.out.println("----------문자연산----------");
		
		char ca = 'A';
		char cz = 'Z';
		
		int numberOfAlphabet = cz - ca + 1; // 10 - 1 하면 9 가 나오기에 +1 해줘야 10 이 나온다
		System.out.println("알파벳 대문자수 : " + numberOfAlphabet );
		
		int numberOfHangunl = '힣' - '가' +1;
		System.out.println("한글 글자수 : " + numberOfHangunl);

		char hangul1 = '가';
		System.out.println(hangul1);
		char hangul2 = '가' + 1;
		System.out.println(hangul2);
		char hangul3 = '가' + 345;
		System.out.println(hangul3);
		
		
		
		
		
		
	}
}
