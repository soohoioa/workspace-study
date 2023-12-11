/*
		논리연산자
		   - 형태:   ||(Logical OR)논리합 , && (Logical AND)논리곱 ( |,& )
		   - 좌우측의항이 논리형변수(데이타)이다.
           - 결과도 논리형데이타이다.
		    ex> true || false, false && false

*/
public class OperatotLogical {

	public static void main(String[] args) {
		// 영혼없는 예제, 이렇게 쓰이는구나 라고 알고있어야함
		boolean b1, b2, b3, b4;
		boolean result;
		b1 = true;
		b2 = true;
		b3 = false;
		b4 = false;
		
		/*
		 * 논리합(logical or) || 
		 * --> false || false 인경우에만 false를 반환
		 *  ( == 피연산자중 하나만 true 이면 연산결과는 true )
		 */
		result = b1 || b2;
		System.out.println("true || true --> " + result);
		result = b1 || b3;
		System.out.println("true || false --> " + result);
		result = b3 || b1;
		System.out.println("false || true --> " + result);
		result = b3 || b4;
		System.out.println("false || false --> " + result);
		
		/*
		 * 논리곱(logical and) && 
		 * --> true || true 인경우에만 true를 반환
		 *  ( 피연산자 모두가 true 일 경우에만 연산결과가 true )
		 */
		result = b1 && b2;
		System.out.println("true && true --> " + result);
		result = b1 && b3;
		System.out.println("true && false --> " + result);
		result = b3 && b1;
		System.out.println("false && true --> " + result);
		result = b3 && b4;
		System.out.println("false && false --> " + result);
		
		/*
		 * 점수의 유효성 체크 [0 ~ 1200 사이의 정수]
		 * 
		 */
		int kor = 67;
		int eng = 90;
		
		boolean condition1 = kor >= 0;
		boolean condition2 = kor <= 100;
		boolean isValidScore = condition1 && condition2;
		System.out.println("국어점수 유효성 체크 : " + isValidScore);
		// 변수는 적게 선언할수록 좋음 
		
		boolean condition3 = kor >= 90;
		boolean condition4 = eng >= 90;
		
		System.out.println(">> A대학 국어점수가 90점 이상이거나 영어점수가 90점  이상이면 합격");
		boolean isPass1 = condition3 || condition4;
		System.out.println("\tA대학 합격 여부 : " + isPass1);
		System.out.println(">> B대학 국어점수가 90점 이상이고 영어점수가 90점 이상이면 합격");
		boolean isPass2 = condition3 && condition4;
		System.out.println("\tB대학 합격 여부 : " + isPass2);
		
		int math = 73;
		boolean isValidMathScore = math >= 0 && math <= 100; 
		// (math >= 0) && (math <= 100); 도 가능하지만 ( ) 안해도 연산 됨
		System.out.println("수학점수의 유효성 여부 : " + isValidMathScore);
 		boolean isInvalidMathScore = math < 0 || math > 100;
 		System.out.println("수학점수의 유효 하지 않은 여부 : " + isInvalidMathScore);
		
 		
 		
 		System.out.println("----------배수판별----------");
 		
		int number = 12;
 		boolean isMultiple3 = number % 3 == 0;
 		System.out.println("3의 배수 여부 : " + isMultiple3);
 		boolean isMultiple4 = number % 4 == 0;
 		System.out.println("4의 배수 여부 : " + isMultiple4);
		boolean isMultiple34 = isMultiple3 && isMultiple4;
		System.out.println("3 과 4 의 공통배수 (공배수) : " + isMultiple34);
		

		/*
		 * Quiz : 윤년여부판단
		 *    - 4의배수(4로나누어떨어지는수)이면서 100의배수가아닌수(100로나누어떨어지는않는수) 이거나
		 *    - 400의배수(400로나누어떨어지는수)
		 */
		int year = 2023;
		boolean isLeapYear = false;
		System.out.println(year + "의 윤년여부 : " + isLeapYear);
		
		int years = 2023;
		boolean y1 = years % 4 == 0;
		boolean y2 = years % 100 != 0;
		boolean y3 = years % 400 == 0;
		
		boolean years1 = (y1 && y2) || y3;	
		System.out.println( years + " 의 윤년 :" + years1);
		
		
		
		char c = '김';
		boolean isHangul = c >= '가' && c <= '힣'; 
		System.out.println("한글여부 : " + isHangul);
		
		c = 'g';
		boolean isHangul1 = c >= '가' && c <= '힣';
		System.out.println("한글여부 : " + isHangul1);
		
		
		
		/*
		 * Quiz : 아이디의 첫 글자는 영문 대문자 이거나 소문자 이여야한다 
		 */
		char idFirstLetter = '@';
		boolean isValidIdFirstLetter=true;
		System.out.println(idFirstLetter+" 의 적합성여부:"+isValidIdFirstLetter);
		
		char idFirstLetter1 = 'f';
		boolean idFirstLetterr = idFirstLetter1 >= 'A' && idFirstLetter1 <= 'Z' || idFirstLetter1 >= 'a' && idFirstLetter1 <= 'z';
		System.out.println(idFirstLetterr);
			
	}

}
