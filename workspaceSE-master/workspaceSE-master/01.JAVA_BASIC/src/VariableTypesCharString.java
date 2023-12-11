
public class VariableTypesCharString {
	
	public static void main(String[] args) {
		/*
		 * 문자형 (한개문자) - 2byte
		 * 	char c1, c2, c3;
		 * 		- 문자형변수 : c1, c2, c3
		 * 		- 문자형리터럴 : 'A', '힣', 'a', '1', '★'
		 */
		
		char c1;
		c1 = 'A';
		char c2 = '가';
		char c3 = '힣';
		char c4 = '1'; // 여기서 1 은 숫자가 아닌 문자형
		char c5 = c1;
		System.out.println("----------char----------");
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);

		
		char munja1, munja2, munja3, munja4, munja5, munja6, munja7, munja8, munja9;
		
		munja1 = 'A';
		/*
		 * 'A' ==> 00000000 | 01000001 |
		 *  65 ==> 00000000 | 00000000 | 00000000 | 01000001
		 */
		munja2 = 65; 
		
		munja3 = '가';
		munja4 = 44032;
		munja5 = 0xAC00; // 16진수로 된 유니코드 값
		munja6 = '\uAC00'; // 
		munja7 ='1';
		munja8 = 49;
		munja9 = '※';
		System.out.println("--------------------");
		System.out.println(munja1);
		System.out.println(munja2);
		System.out.println(munja3);
		System.out.println(munja4);
		System.out.println(munja5);
		System.out.println(munja6);
		System.out.println(munja7);
		System.out.println(munja8);
		System.out.println(munja9);
		
		
		
		System.out.println("---------- 문자열형(String) ----------");
		String str1 = "오늘은";
		String str2 = "금요일";
		String str3 = "연산자를 공부합니다.";

		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		/*
		 * 문자열 결합 연산자 ( + )
		 */
		
		String str4 = str1 + " " + str2 +" " + str3;
		System.out.println(str4);
		
		String name = "홍길동";
		int age = 34;
		char gender = 'M';
		double height = 182.23;
		double weight = 63.8;
		
		String myInfo = name + "    " + age + "       " + gender + "      " + height + "    " + weight;
		
		System.out.println("----------------------------------------------");
		System.out.println(" 이름    나이    성별      키      몸무게");
		System.out.println("----------------------------------------------");
		
		System.out.println(myInfo);
		System.out.println(name + "    " + age + "       " + gender + "      " + height + "    " + weight);
		
		
		
		
		
		
		

	}
}
