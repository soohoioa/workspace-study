
public class MemberMethodThisMain {

	public static void main(String[] args) {
		MemberMethodThis mmt1 = new MemberMethodThis();
		/*
		mmt1.memberField1=77777;
		mmt1.memberField2='꿈';
		mmt1.memberField3=3.141592;
		*/
		
		
		/*
		mmt1.setMemberField1(777777);
		mmt1.setMemberField2('꿈');
		mmt1.setMemberField3(3.141592);
		*/
		
		// mmt1은 메인블록안에 있어서 void setMemberField1(int memberField1) 이쪽에서 호출을 못하므로
		// this 라는 참조변수를 사용하여 주소값을 가져올수 있다.
		// this.memberField1 = memberField1; 에서 this 는 mmt1이 된다
		// mmt1의 주소가 this 로 들어온다!!!!!!!!!!!!!!!!!!!!!
		// 그래서 this 는 변수이다!!!!!!!!!!!!!!!!!!!!!!
		
		//  MemberMethodThisMain는 왼쪽에 MemberMethodThis 는 오른쪽으로 창 분할해서 보면서 이해하기
		//  ->>메인메소드는 왼쪽 클래스는 오른쪽에 놓고 보기
		
		// 메인에서는 mmt1 으로, 클래스에서는 this 로 표현 하지만 어쨋든 같은말로 쓰인다 
		
		
		mmt1.setMemberField(777777, '꿈', 3.1415920);
		mmt1.print();
		// ---------------------------------
		// 3개를 받아서 한번에 셋팅하고 싶으면
		MemberMethodThis mmt2 = new MemberMethodThis();
		mmt2.setMemberField(88888888, '깸', 1.141592);
		mmt2.print();
		
		/*
		메인메소드에서 System.out.println(mmt2); 찍으면 주소값이 동일하게 나온다
		클래스에서 System.out.println(this); 찍으면 주소값이 동일하게 나온다
		*/
		
		
	}

}
