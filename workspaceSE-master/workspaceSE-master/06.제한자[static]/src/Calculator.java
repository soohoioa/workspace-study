
public class Calculator {
	/**
	 * 외부에서 생성할수 없다 친구야~~~
	 */
	
	private Calculator() {
		
	}
	
	/*
	 * - add( 두개의 정수를 매개변수로 받아서 더한 결과값을 반환)
	 * - sub( 두개의 정수를 매개변수로 받아서 뺀   결과값을 반환)
	 * - div( 두개의 정수를 매개변수로 받아서 나눈 결과값을 반환)
	 * - mul( 두개의 정수를 매개변수로 받아서 곱한 결과값을 반환)
	 */
	
	public static int add(int a, int b) {
		return a + b;
	}
	public static int sub(int a, int b) {
		return a - b;
	}
	public static int div(int a, int b) {
		return a / b;
	}
	public static int mul(int a, int b) {
		return a * b;
	}
	
	/*	- 객체를 만듬 -> 객체의 속성을 가짐 / 기능만 가지고 있음 멤버가 없으니 this 사용하지않음
		- 객체생성없이 정적메소드를 만드는게 좋다
		- 객체가 구분할필요도 없음 -> 하지만 그때마다 다르다 
		- 타입과 이름은 반드시 붙어있어야하고 
		  public static 은 순서가 바뀌어도 상관없지만 되도록이면 접근제한자가 앞으로 오게해서 만들어야 한다
	*/

}
