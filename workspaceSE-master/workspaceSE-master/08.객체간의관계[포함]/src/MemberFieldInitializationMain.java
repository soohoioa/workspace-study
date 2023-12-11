
public class MemberFieldInitializationMain {

	public static void main(String[] args) {
		MemberField memberField = new MemberField();
		
		System.out.println("1-1. 인스턴스 멤버필드는 객체생성시 기본 값으로 자동 초기화");
		System.out.println(memberField.member1);
		System.out.println(memberField.member2);
		System.out.println(memberField.member3);
		System.out.println(memberField.member4);
		System.out.println(memberField.member5);
		// 변수는 초기화 하지 않으면 사용할수없기에 값을 초기화해줌
		
		System.out.println("2-1. 인스턴스 멤버필드는 선언시 초기값으로 초기화 할수있다.");
		System.out.println(memberField.member11);
		System.out.println(memberField.member22);
		System.out.println(memberField.member33);
		System.out.println(memberField.member44);
		System.out.println(memberField.member55);
		
		System.out.println("3-1. 생상지 초기화");
		MemberField memberField2 = 
				new MemberField(1, 1.1, '김', false, "문자열1", 2, 2.2, '경', true, "문자열2");
		// The constructor MemberField() is undefined
		// -> 생성자 MemberField()가 정의되지 않았습니다
		System.out.println(memberField2.member1);
		System.out.println(memberField2.member2);
		System.out.println(memberField2.member3);
		System.out.println(memberField2.member4);
		System.out.println(memberField2.member5);		
		System.out.println(memberField2.member11);
		System.out.println(memberField2.member22);
		System.out.println(memberField2.member33);
		System.out.println(memberField2.member44);
		System.out.println(memberField2.member55);
		
	}

}
