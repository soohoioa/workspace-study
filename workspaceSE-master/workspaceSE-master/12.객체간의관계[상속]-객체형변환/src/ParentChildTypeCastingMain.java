/*
 객체주소변수의 타입(형)변환 -->> 여기서 클래스는 타입으로 해석한다. 실제객체는 상관없고 객체주소값의 타입만 형변환이 일어남
   1. 상속관계(부모자식관계)에있는 클래스 들에서만 가능하다.
      ex> 자식타입객체의주소를 부모타입객체의 주소로 형변환(주소변경절대안됨,타입만변경)
      ex> 부모타입객체의주소를 자식타입객체의 주소로 형변환(주소변경절대안됨,타입만변경)
        
   2. 자식클래스 타입 객체주소를 부모클래스 타입 객체주소로 형변환 -->> 주소는 그대로 타입만 변경
       - 자동으로 이루어진다(묵시적)
       Child c = new Child();
       Parent pppp = c; 
   3. 부모타입객체의주소를 자식타입객체의 주소로 형변환
       - 원칙적으로는 불가능하다
       - 부모의 탈을쓴 자식객체 는 가능하다.
       Parent p=new Parent();
       Child cccc = p;(X)
    public class Parent{}
    public class Child extends Parent{}
 */

class Parent { // 접근제어자 public 는 붙이면 안됨
	public void method1() {
		System.out.println("Parent.mwthod1()");
	}
	public void method2() {
		System.out.println("Parent.mwthod2()");
	}
	public void method3() {
		System.out.println("Parent.mwthod3()");
	}
}

class Child extends Parent {
	/*
	 public void method3() {
		System.out.println("Parent.mwthod3()");
	 }
	 */
	@Override
	public void method3() {
		System.out.println("Child.method3() --> Parent.method3()를 재정의[오버라이딩]");
	}
	
	public void method4() {
		System.out.println("Child.mwthod4()");
	}
}

public class ParentChildTypeCastingMain {

	public static void main(String[] args) {
		System.out.println("----------< Child >----------");
		Child c1 = new Child();
		c1.method1();
		c1.method2();
		c1.method3(); // Child 객체의 재정의 메소드 호출
		c1.method4();
		
		System.out.println("----------< Child -->> Parent >----------");
		/*
		 * 2. 자식클래스 타입 객체주소를 부모클래스 타입 객체주소로 형변환 -->> 주소는 그대로 타입만 변경
       			- 자동으로 이루어진다(묵시적)
		 */
		Parent p1 = c1; // p1은 Parent 객체타입이라고 확정할수없다.
		if(p1 == c1) {
			System.out.println(p1 + " == " + c1 + "[p1과 c1의 주소가 동일하다]");
		}
		p1.method1();
		p1.method2();
		p1.method3(); // Child 객체의 재정의된 메소드 호출
		// p1.method4(); -->> The method method4() is undefined for the type Parent 
		// 메서드 4()가 부모 유형에 대해 정의되지 않았습니다
		
		
		
		/*
		 * 3. 부모타입객체의주소를 자식타입객체의 주소로 형변환
       			- 자동으로 이루어지지 않는다.(명시적)
       			- 원칙적으로는 불가능하다
       			- 부모의 탈을쓴 자식객체 는 가능하다.
		 */
		Parent p2 = new Parent();
		/*
		  1. compile시 
		  << Type mismatch: cannot convert from Parent to Child >>
		  	 유형 불일치: 부모에서 자식으로 변환할 수 없습니다
		Child c2 = p2;
		*/
		
		/*
		  2. runtime 시
		  << ClassCastException: Parent cannot be cast to Child >>
		 	 ClassCastException: 부모를 자식으로 캐스팅할 수 없습니다
		Child c2 = (Child)p2; // 강제형변환
		*/
		
		/*
		  - 부모의 탈을쓴 자식객체 는 가능하다.
		 */
		Parent p3 = new Child();
		System.out.println("-----Child객체를 Parent타입 변수로 호출-----");
		p3.method1();
		p3.method2();
		p3.method3(); // Child 객체의 재정의된 메소드 호출
		// p3.method4();
		
		Child c3 = (Child)p3; // 강제형변환
		System.out.println("-----Child객체를 Child타입 변수로 호출-----");
		c3.method1();
		c3.method2();
		c3.method3(); // Child 객체의 재정의된 메소드 호출
		c3.method4();
		
		
		
	}

}
