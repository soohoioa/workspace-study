package lang;

public class StringUseMain {

	public static void main(String[] args) {
		 
		// String 은 불변객체
		System.out.println("--------------length-----------------");
		String str1 = "Have a nice day!!!"; // 공백도 포함된다.
		String str2 = "오늘은 금요일 String 클래스를 공부해요.";
		int length1 = str1.length();
		int length2 = str2.length();
		int length3 = "자바가 재미있네요.".length();
		System.out.println(length1);
		System.out.println(length2);
		System.out.println(length3);
		String emptyStr = "";
		System.out.println("empty string length : " + emptyStr.length());
		
		
		System.out.println("--------------null-------------------");
		String id = null;
		// String id = ""; null아님 사이즈제로 char배열이 만들어짐
		if(id == null || id .equals("")) {
			System.out.println("아이디를 입력하세요.");
		}
		
		
		System.out.println("--------------charAt-----------------");
		String userId = "testST$#!3467";
		char firstChar = userId.charAt(0);
		char lastChar = userId.charAt(userId.length() -1); // index는 0부터 시작하므로 -1해줌
		
		System.out.println(">> 아이디는 영문대(소)문자, 숫자로 구성되어야 한다.");
		System.out.println(">> 아이디의 첫 글자는 영문대(소)문자 여야한다.");
		if((firstChar >= 'a' && firstChar <= 'z') || (firstChar >= 'A' && firstChar <= 'Z')) {
			System.out.println(firstChar + "는 아이디 첫글자로 유효합니다.");
		} else {
			System.out.println(firstChar + "는 아이디 첫글자로 유효 안합니다.");
		}
		System.out.println("[Quiz] ----- id 유효성체크 -----");
		boolean isValid = false;
		for (int i = 0; i < userId.length(); i++) {
			char tempChar = userId.charAt(i);
			System.out.print(tempChar + " , ");
		}
		System.out.println();
		if(isValid) {
			System.out.println(userId + "는 유효한 아이디입니다.");
		}else {
			System.out.println(userId + "는 유효안한 아이디입니다.");
		}
		
		
		System.out.println("--------------substring--------------");
		System.out.println("Have a nice day!!!".substring(7)); // 0부터시작, 띄어쓰기 포함. substring하나짜리
		System.out.println("Have a nice day!!!".substring(7, 11)); // 0부터시작, 띄어쓰기 포함. substring두개짜리
		/*
		Parameters:
			beginIndex - the beginning index, inclusive.
			endIndex - the ending index, exclusive.
			시작인덱스는 포함, 마지막 인덱스는 포함하지 않음
		*/
		System.out.println("오늘은 금요일 String 클래스를 공부해요.".substring(4,7));
		System.out.println("오늘은 금요일 String 클래스를 공부해요.".substring(4));
		
		
		System.out.println("---------------indexOf---------------");
		String email = "guard@gmail.com";
		int atSignPosition = email.indexOf("@");
		System.out.println(email.substring(0, atSignPosition));
		System.out.println(email.substring(atSignPosition+1));
		
		
		System.out.println("--------------split------------------");
		String phoneNo = "010-5624-5621";
		String[] phoneNoArray = phoneNo.split("-");
		for (String tempNo : phoneNoArray) {
			System.out.println(tempNo);
		}
		
		
		System.out.println("--------------replace----------------"); // 대체하는 작업
		String str3 = "자바는 객체지향언어 입니다. 우리는 자바를 공부합니다.";
		String result3 = str3.replace('자', '날');
		System.out.println(result3);
		System.out.println(str3.replaceAll("자바", "파이썬"));
		
		
		System.out.println("--------------toUpperCase,toLowerCase"); // 대소문자 일괄 변경
		System.out.println("jAvA".toUpperCase());
		System.out.println("jAvA".toLowerCase());
		System.out.println("equals --> " + "java".equals("JAVA")); //true와 false로 반환
		System.out.println("equalsIgnoreCase --> " + "java".equalsIgnoreCase("JAVA"));
		
		
		System.out.println("--------------startsWith-------------");
		String name = "김수한";
		if(name.startsWith("김")) {
			System.out.println("김씨 인 사람 : " + name);
		}
		String[] names = {"정경호", "김미숙", "최경녀", "김은희", "신명숙"};
		for (int i = 0; i < names.length; i++) {
			if(names[i].startsWith("김")) {
				System.out.println(names[i]);
			}
		}
		/*
		 * Quiz: 김씨를 찾아 새로운 배열에 담아보세요.
		 */
		int count = 0;
		for (String tempName : names) {
			if(tempName.startsWith("김")) {
				count++;
			}
		}
		// String[] kimArray = null;  배열은 생성시 사이즈가 있어야함
		String[] kimArray = new String[count];
		int kimIndex = 0;
		for (String tempName : names) {
			if(tempName.startsWith("김")) {
				kimArray[kimIndex] = tempName;
				kimIndex++;
			}
		}
		System.out.println("----------------kim------------------");
		for (String kimName : kimArray) {
			System.out.println("kimName");
		}
		
		System.out.println("--------------endsWith---------------");
		String[] fileNameArray = {
				"a.jpg", "s.txt", "d.gif", "zz.doc","nn.java"
		};
		for (int i = 0; i < fileNameArray.length; i++) {
			if(fileNameArray[i].endsWith(".gif") || fileNameArray[i].endsWith(".jpg")) {
				System.out.println(fileNameArray[i]);
			}
		}
		
		
		System.out.println("--------------trim-------------------"); // 양쪽 끝 공백제거 , 가운데 공백은 재거하지 않음.
		String id2 = "   guar  d   ";
		System.out.println(id2.length());
		System.out.println(id2.trim().length());
		String chatMessage = "             ";
		if(chatMessage.trim().length() == 0) {
			System.out.println("전송안함");
		}
		

	}

}
