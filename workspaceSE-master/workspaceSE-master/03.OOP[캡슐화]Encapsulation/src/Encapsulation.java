	/* OOP 의 클래스 설계(작성) 기법 
	 *   1. 캡슐화 Encapsulation
	 *   2. 상속성
	 *   3. 다형성(오버로딩,오바라이딩,객체형변환)
	 */

	/*
	 * 1. 캡슐화 [Encapsulation]
	 *    - 외부클래스(객체)에서 멤버변수에 접근을 막고
	 *      멤버 메쏘드에만 접근할수있도록 클래스를 설계하는방법
	 *      // -->> 외부클래스에서 멤버변수 사용 못하게 만들겠다. 
	 *    - 구현 : 멤버변수의   접근제한자를 private 
	 * 			   멤버메소드의 접근제한자는 public 으로한다. 
	 * 
	 *             public ==> 어떤 외부클래스(객체) 에서든지 접근가능 // -> 지금은 메인(Main) 에서 접근하는것
	 *             private==> 어떤 외부클래스에서든지 접근불가능
	 *             // -> 메인이 붙은 클래스는 메인클래스다
	 *             // -> 지금 여기서 외부클래스는 메인(Main) 클래스라 생각하기
	 */
public class Encapsulation { // 캡슐화 되어있다. 외부에서는 절대 접근이 불가능
	
	private int memberField1;
	private boolean memberField2;
	private char memberField3;
	private double memberField4;
	
	
	// setter 메소드
	 public void setMemberField1(int memberField1) {
		this.memberField1 = memberField1;
	}
	// 멤버메소드를 통해서만 객체를 사용해라 
	public void setMemberField2(boolean memberField2) {
		this.memberField2 = memberField2;
	}
	public void setMemberField3(char memberField3) {
		this.memberField3 = memberField3;
	}
	public void setMemberField4(double memberField4) {
		this.memberField4 = memberField4;
	}
	
	
	// getter 매소드
	public int getMemberField1 () {
		return this.memberField1;
	}
	public boolean getMemberField2() {
		return memberField2; // 여기는 this 가 생략되어 있음
	}
	public char getMemberField3() {
		return memberField3;
	}
	public double getMemberField4() {
		return memberField4;
	}
	
	
	
	public void print() {
		System.out.println(this.memberField1 + "\t" + this.memberField2 + "\t" 
				+ this.memberField3 + "\t" + this.memberField4);
		
	}
	
	 
	 
	 
	 
	 
}
