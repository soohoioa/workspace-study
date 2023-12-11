
public class IfUse {

	public static void main(String[] args) {
		
		/*
		 * 짝수, 홀수 파편
		 */
		int no1 = 52;
		
		if (no1 % 2 == 0) {
			System.out.printf("%d 은 짝수입니다.\n",no1);
			// printf 붙이고 %d 숫자, %s 문자 로 사용하면 됨 
			// %와 , 뒤 타입이 일치하지 않으면 에러발생
			// \n 라인 종결자
			
		} else {
			System.out.println(no1 + " 은 홀수입니다.");
		}
		
		/*
		 * 4의 배수 판별
		 */
		int no2 = 4000;
		if (no2 % 4 == 0) {
			System.out.printf("%d 는 4의 배수\n", no2);
		} else {
			System.out.printf("%d 는 4의 배수아님\n", no2);
		}
		
		/*
		 * 점수의 유효성체크
		 */
		int kor = -90;
		if (kor >= 0 && kor <= 100) {
			System.out.printf("%d 는 유효한 점수 입니다.\n", kor);
		} else {
			System.out.printf("%d 는 유효한 점수가 아닙니다.\n", kor);
		}
		
		
		/*
		 * 윤년 여부 출력
		 */
		int year = 2000;
		String msg = ""; 
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			msg = "윤년";
		} else {
			msg = "평년";

		}
		System.out.printf("%d년은 %s 입니다.\n", year,msg);
		
		/*
		 * 문자 판단
		 */
		char c = 'Y';
		if (c >= 'A' && c <= 'Z') {
			System.out.printf("%c 는 알파벳 대문자 입니다.\n", c);
		}
		if (c >= 'a' && c <= 'z') {
			System.out.printf("%c 는 알파벳 소문자 입니다.\n", c);
		}
		if (c >= '0' && c <= '9') {
			System.out.printf("%c 는 숫자형문자 입니다.\n", c);
		}
		
	
		/*
		 Quiz:
		 다음문자는 아이디의 첫글자입니다. 
		 이문자가 아이디의 첫글자로 유효한지판단후출력하세요 
		   - 아이디의첫글자는 알파벳대문자 이거나 소문자이다
		 */
		char idFirstLetter = '6';
		if ((idFirstLetter >= 'A' && idFirstLetter <= 'Z') || (idFirstLetter >= 'a' && idFirstLetter <= 'z') ) {
			System.out.printf( "%c 는 유효한 아이디 첫 문자 입니다.\n", idFirstLetter);
		} else {
			System.out.printf( "%c 는 유효안한 아이디 첫 문자 입니다.\n", idFirstLetter);			
		}
		
		
	}

}
