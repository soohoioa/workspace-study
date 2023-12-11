
public class MemberFieldMain {

	public static void main(String[] args) {
		System.out.println("-- main start --");
		/*
		 * MemberField 사용자 정의 타입 객체의 주소 값을 저장할 참조 변수 선언
		 */
		MemberField mf1;
		
		
		/*
		 * MemberField클래스(틀) 로 객체를 생성한 후에 객체의 주소 값이 
		 * mf1 참조변수에 대입된다. (#100)
		 */
		mf1 = new MemberField();
		
		
		/*
		 * mf1(#100) 주소에 있는 객체의 int 	타입의  멤버필드(멤버변수) MemberField1에 1234 		 값을 대입
		 * mf1(#100) 주소에 있는 객체의 double  타입의  멤버필드(멤버변수) MemberField2에 3.2  		 값을 대입
		 * mf1(#100) 주소에 있는 객체의 boolean 타입의  멤버필드(멤버변수) MemberField3에 true 		 값을 대입
		 * mf1(#100) 주소에 있는 객체의 char	타입의  멤버필드(멤버변수) MemberField4에 'A'  		 값을 대입
		 * mf1(#100) 주소에 있는 객체의 String  타입의  멤버필드(멤버변수) MemberField5에 "김수한무" 값을 대입
		 * 
		 * - 객체의 참조(주소)변수가 가지고 있는 객체의 주소 값 #100 를 사용해서 멤버필드(멤버필드는 독립적으로 존재할수 없음)에 데이터 대입
		 * - 객체의 멤버필드에 접근 방법 
		 * 		- 참조(주소)변수.멤버필드이름 = 값;  ( . 가 예외가 없어서 간략하게 사용불가)
		 * 		- mf1.member1 = 77; 
		 *  	- 주소형 리터럴은 존재하지 않음 , 주소.리터럴은 없음 항상 변수만이 존재한다
		 */
		mf1.memberField1 = 1312; // 타입이 틀리면 에러
		mf1.memberField2 = 3.2;
		mf1.memberField3 = true;
		mf1.memberField4 = 'A';
		mf1.memberField5 = "김수한무";
		
		
		MemberField mf2 = new MemberField();
		mf2.memberField1 = 324234;
		mf2.memberField2 = 3.14159;
		mf2.memberField3 = false;
		mf2.memberField4 = '가';
		mf2.memberField5 = "제임스딘";
		
		
		/*
		 * mf1 객체의 int 	  타입 멤버필드 memberFiled1의 값을 출력
		 * mf1 객체의 double  타입 멤버필드 memberFiled2의 값을 출력
		 * mf1 객체의 boolean 타입 멤버필드 memberFiled3의 값을 출력
		 * mf1 객체의 char 	  타입 멤버필드 memberFiled4의 값을 출력
		 * mf1 객체의 String  타입 멤버필드 memberFiled5의 값을 출력
		 * 
		 * 
		 * - 객체의 참조(주소)변수가 가지고 있는 객체의 주소 값 #100를 사용해서 멤버필드의 값을 출력 
		 * - 객체의 멤버필드에 접근방법
		 * 		1. System.out.println(mf1.memberField1);
		 * 		2. 
		 * 			int tempMember1 = mf1
		 * 			System.out.println(tempMember);
		 */
		
		System.out.println("mf1의 주소값 : " + mf1); // 실제주소값은 알 필요 없지
		
		
		System.out.println(mf1.memberField1 + " " + 
							mf1.memberField2 + " " + 
							mf1.memberField3 + " " + 
							mf1.memberField4 + " " +
							mf1.memberField5);
		
		int tempMember1 /*멤버 변수 아님*/ = mf1.memberField1; /*멤버 변수*/ 
		// 클래스 안에 선언 된 변수는 멤버변수이고 멤버변수는 위치를 보고 판단 
		// 메인블록이 의미하는것은 올라오고 찾고 실행문을 만들어서 호출하는것 9번쨰 얘기하는중 이제 좀 외워야할거같아 하지만 뒤돌아서면 까먹는걸 힣!!!!
		System.out.println(tempMember1);
		
		System.out.println(mf2.memberField1 + " " +
							mf2.memberField2 + " " + 
							mf2.memberField3 + " " + 
							mf2.memberField4 + " " +
							mf2.memberField5);
		
		
		System.out.println("-- main end --");
		
	}

}
