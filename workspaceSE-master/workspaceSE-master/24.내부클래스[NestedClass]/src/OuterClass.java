
public class OuterClass {
	
	/* 
	 * 인스턴스 멤버 필드 
	 */
	public int outer_member_field = 8888;
	
	/* 
	 * 인스턴스 멤버 메소드 
	 */
	public void outer_member_method() {
		System.out.println("OuterClass.member_method()");
	}
	
	/***** OUterClass 에서 InnerClass 객체생성 사용 *****/
	public void outer_inner_class_ise() {
		InnerClass ic = new InnerClass(); // 객체생성
		// OuterClass.InnerClass ic =this.new InnerClass(); 
		
		ic.inner_member_field=31232;
		ic.inner_member_method();
		System.out.println(ic);
		System.out.println(ic.inner_member_field);
	}
	
	
	/* 인스턴스 멤버 클래스(nested class, inner class) -> 외우기
	 * 	  - 작성이유 : 내부클래스에서 외부클래스의 멤버 접근을 손쉽게 하기위해서 작성
	 */
	
	public class InnerClass{ // -> 만약이게 외부로 만들어졌다면 멤버필드나 멤버메소드에 접근이 어려움
		public int inner_member_field = 3333;
		public void inner_member_method() {
			System.out.println("InnerClass.inner_member_method()");
			// 독립적인 클래스가 아니고 Outer에 속해있다
		}
		
		/***** 내부클래스에서 외부클래스의 멤버접근 *****/
		public void inner_outer_member_access() { // -> 멤버변수 이름과 멤버메소드 이름을 작성하면 알아서 찾는다.
			
			System.out.println(InnerClass.this.inner_member_field); 
			//클래스 안에 클래스. 내부에서 외부 접근은 클래스 이름 작성
			InnerClass.this.inner_member_method();
			
			
			System.out.println(OuterClass.this.outer_member_field);
			OuterClass.this.outer_member_method();
			// 위 아래 차이점 :  클래스.this 모두 생략함
			System.out.println(outer_member_field);
			outer_member_method();
			// 클래스이름.this 로 작성해야 가능하고 this만 사용시 오류발생
			// 만약this만 사용할경우 public class InnerClass (코드20줄) 여기를 참조하므로 오류발생.
			

		}

		
	}
	

}
