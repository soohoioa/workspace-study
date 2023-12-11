
public class Parent extends Object{
	private int member1;
	private int member2;
	
	public Parent() {
		/*
		 * - 클래스 생성자 첫번째 라인에서는 부모클래스의 생성자가 반드시 호출되어야한다.
		 * - 부모클래스의 생성자 호출을 생략할경우에는 부모클래스 기본생성자가 자동으로 호출된다.
		 */
		super(); // 오브젝트 기본생성자
		System.out.println("1. Object() 기본생성자");
		System.out.println("2. Parent() 기본생성자");
	}
	
	public Parent(int member1, int member2) {
		/*
		 * - 클래스 생성자 첫번째 라인에서는 부모클래스의 생성자가 반드시 호출되어야한다.
		 * - 부모클래스의 생성자 호출을 생략할경우에는 부모클래스 기본생성자가 자동으로 호출된다.
		 * - 매개변수를 가진 부모생성자를 호출할수있다.(명시적으로 호출코드를 기술하여야 한다.)
		 */
		super(); 
		this.member1 = member1;
		this.member2 = member2;
		System.out.println("1. Object() 기본생성자");
		System.out.println("2. Parent(int member1, int member2) 생성자");
	}

	public void method1() {
		System.out.println("Parent.method1()");
	}
	
	public void method2() {
		System.out.println("Parent.method2()");
	}
	
	public void print() {
		System.out.print(this.member1 + "\t" + this.member2 + "\t");
	}

	public int getMember1() {
		return member1;
	}

	public void setMember1(int member1) {
		this.member1 = member1;
	}

	public int getMember2() {
		return member2;
	}

	public void setMember2(int member2) {
		this.member2 = member2;
	}
	
	
}
