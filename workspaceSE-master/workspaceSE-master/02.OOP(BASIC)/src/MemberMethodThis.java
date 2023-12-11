
public class MemberMethodThis {
	/*
	 * 멤버필드[속성]  
	 */
	int memberField1 = 0;
	char memberField2 = 0;
	double memberField3 = 0.0;
	

	/*
	 * 매개변수를 받아서 memberField1 의 값을 대입하는 메소드 
	 */
	void setMemberField1(int memberField1 /*로컬변수*/) {
		this.memberField1 = memberField1;
		/*
		 * this :
		 *  - self 참조변수
		 *  - void setMemberField1() 메소드가 실행될때 호출주체객체의 주소값을 가진 변수
		 *  - this는 대부분 생략이 가능하다. 
		 *  - setMemberField1() 메소드를 멤버로 가진 객체 주소
		 */
	}

	void setMemberField2(char memberField2) {
		this.memberField2 = memberField2;
	}
	
	
	void setMemberField3(double memberField3) {
		this.memberField3 = memberField3;
	}
	
	
	/*
	 * 1. 객체의 멤버필드에 데이터를 대입
	 */
	void setMemberField(int memberField1, char memberField2, double memberField3) {
		this.memberField1 = memberField1;
		this.memberField2 = memberField2;
		this.memberField3 = memberField3;
	}
	
	/*
	 * 2. 객체의 멤버필드의 내용을 출력하는 메소드
	 */
	void print() {
		/*
		 * this:
		 *   - self참조변수
		 *   - void print()메쏘드가 실행될때 호출주체객체의 주소값
		 *   - this는 생략이가능
		 */
		System.out.println(this.memberField1 + "\t" + this.memberField2 + "\t" + memberField3);
	} // 로컬변수가 없어서 this 를 생략 가능하다.
	
	/*
	메인메소드에서 System.out.println(mmt2); 찍으면 주소값이 동일하게 나온다
	클래스에서 System.out.println(this); 찍으면 주소값이 동일하게 나온다
	*/
	
	
}
