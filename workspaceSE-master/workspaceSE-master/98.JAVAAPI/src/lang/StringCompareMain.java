package lang;

public class StringCompareMain {
	public static void main(String[] args) {
 
		/*
		 * String 객체의 생성
		 * 	1. 생성자 호출(명시적)
		 * 	2. "  "로 생성(암시적)
		 */
		// 상속과 포함 
		// 파이널은 상속받으면 에러. 더이상 내 밑에 자식을 두지 않겠다!!
		// 문자열에서 주소비교는 하지마라 == <<--사용금지
		// String , equals
		
		String name1 = new String("KIM"); // 참조변수
		String name2 = new String("KIM");
		String name3 = "KIM"; // name은 참조변수
		String name4 = "KIM";
		
		/*
		if(name1 == name2) {
			System.out.println("name1 , name2 의 주소는 다르다.");
		}
		if(name3 == name4) {
			System.out.println("name3 , name4 의 주소는 같다.");
		} 
		// 주소비교 필요없고 스트링안에 char value[] 로 비교
		if("KIM" == name3) {
			System.out.println("\"KIM\" , name3 의 주소는 같다.");
		}
		*/
		
		System.out.println("-----String 객체의 내용비교는 반드시 재정의 된 equals메소드를 사용하여야 합니다.-----");
		/*
		 << public boolean equals(String otherString) >>
				Compares this string to the specified object. 
				The result is true if and only if the argument is not null and is a String object that represents the same sequence of characters as this object.
				
			Overrides:
				equals in class Object
		 */
		
		if(name1.equals(name2)) {
			System.out.println("name1객체의 문자열과 name2의 문자열이 동일하다.");
		}
		if(name1.equals(name3)) {
			System.out.println("name1객체의 문자열과 name3의 문자열이 동일하다.");
		}
		if(name1.equals(name4)) {
			System.out.println("name1객체의 문자열과 name4의 문자열이 동일하다.");
		}
		if(name1.equals("KIM")) {
			System.out.println("name1객체의 문자열과 \"KIM\" 객체의 문자열이 동일하다.");
		}
		if("KIM".equals(name4)) {
			System.out.println("\"KIM\"객체의 문자열과 name4 객체의 문자열이 동일하다.");
		}
		
		
		/*
		 public int compareTo(String anotherString)
		 	- the value 0 if the argument string is equal to this string;
		 	- a value less than 0 if this string is lexicographically less than the string argument;
		 	- and a value greater than 0 if this string is lexicographically greater than the string argument.
		 	
		 	- (앞쪽 문자열 유니코드 숫자 - 뒤쪽 문자열 유니코드 숫자) 의 결과를 반환한다.
		 */
		int unicodeGap = "aaa".compareTo("aaa");
		System.out.println(unicodeGap);
		unicodeGap = "aaa".compareTo("aab");
		System.out.println(unicodeGap);
		unicodeGap = "aab".compareTo("aaa");
		System.out.println(unicodeGap);
		
		String irum1 = "홍경호";
		String irum2 = "김경호";
		if(irum1.compareTo(irum2) > 0) {
			System.out.println("irum1, irun2 교환 [오름차순]");
		}
		
		//char value[] 와 char[] value 는 같다.
		
	}
}
