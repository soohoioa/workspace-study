
public class WhileUseChar {

	public static void main(String[] args) {
		/*
		 * 문자 출력 
		 * 자바에서 문자열은 2 바이트를 사용
		 */
		char c1 = 0; // 문자가 랩핑되어 있지 않음 
		while (c1 < 65535) { // 65536 부터는 char 범위 이탈하여 오류뜸
			System.out.print(c1);
			c1++;
			if (c1 % 100 == 0) {
				System.out.print("\n");
			}
		}
		System.out.println();
		
		 /*
		  * - 영문 소문자출력
		  *  a b c d e f g h i j k l m n o p q r s t u v w x y z 
		  */
		 char c2='a';
		 while(c2<='z') {
			 System.out.print(c2+" ");
			 c2++;
		 }
		 System.out.println();
		
		/*
			<< Quiz>>
		  	- 영문 소문자 출력
			 a b c d e 
		     f g h i j 
		     k l m n o 
		     p q r s t 
		     u v w x y 
		     z 
		 */
		char cc = 'a';
		while (cc <= 'z') {
			System.out.print(cc + " ");
			if ((cc - 'a' + 1) % 5 == 0) {
				System.out.print("\n");
			}
			cc++;
		}
		System.out.println();
		
		/*
		 * 한글 출력
		 */
		char han = '가';
		while (han <= '힣') {
			System.out.print(han);
			han++;
			if (han % 100 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		
		/*
		 * 숫자형 문자  (0 ~ 9)
		 */
		char c3 = '0';
		
		while (c3 <= '9') {
			System.out.print(c3 + " ");
			c3++;
		}
		System.out.println();

		
	}

}
