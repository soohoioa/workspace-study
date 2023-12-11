
public class OverridingChild extends OverridingParent{
	/*
	 * 	public void method1() {
			System.out.println("OverridingParent.method1()");
		}
		<< 부모로부터 상속받은 자식 메소드 method2 >>
		- 숨겨진다.(외부에서 호출 안된다.)
		public void method2() {
			System.out.println("OverridingParent.method2()");
		}
	 */
	
	/*
	 << 자식에서 재정의한 자식 메소드 method2 >>
	 - 자식에서 재정의한 메소드만 호출된다.
	 */
	@Override
	public void method2() {
		System.out.println("----재정의 된 method2 start----");
		// this.method2(); 스택오버플로우 오류 발생
		super.method2(); // 숨겨진 메소드에 다가갈때는 super을 써준다
		/*
		 * super
		 * 	 - this 와 같은 self 참조변수
		 *   - this 와 같은 주소값이다
		 *   - 재정의에 의해서 숨겨진 메소드(멤버)를 호출하때 사용된다
		 */
		System.out.println("OverridingChild.method2() 추가작업");
		System.out.println("----재정의 된 method2 end----");
	}
	public void method3() {
		System.out.println("OverridingChild.method3()");
	}
	
}
