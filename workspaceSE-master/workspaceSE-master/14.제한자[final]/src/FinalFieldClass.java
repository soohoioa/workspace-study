	/*
	제한자(final)
		1. 클래스앞에 붙일경우
		   상속금지 
	       ex> public final class Test{}
	    2. 멤버메쏘드앞에 붙일경우 -->> 재정의 금지
	       오버라이딩 금지
	       ex> public final void print(){}
	    3. 멤버변수 앞에붙일경우--> 상수
	    -->> 식별자를 대문자사용, 캡슐화X 
	       ex> public final int PORT_NUMBER=80;
	       상수화된다.    
	       변경금지
	*/
public class FinalFieldClass {
	public final int PORT_NUMBER = 80;
	public static final double PI = 3.14159;
	public static final int EARTH_RADIUS = 6400;
	// class변수 만들기위해, 대부분의 경우 final 과 static은 주로 붙어있다.(공용의 의미)
	public final double INCENTIVE_RATE; // 명시적 초기화 요구 
	
	// public final Product product = new product(1, "새우깡");
	// 주소값이 final된다해서 값이 final이 되지는 않는다.
	
	public FinalFieldClass() {
		
		INCENTIVE_RATE = 0.1;
		/*
		 << The final field FianlFieldClass. PORT_NUMBER cannot be assigned >>
		 최종 필드 Final Field Class입니다. PORT_NUMBER를 할당할 수 없습니다
		this.PORT_NUMBER = 88;
		this.PI = 3.24;
		this.EARTH_RADIUS = 8500;
		*/
		System.out.println(INCENTIVE_RATE);
		System.out.println(PORT_NUMBER);
		System.out.println(PI);
		System.out.println(EARTH_RADIUS);
		System.out.println(Math.PI);
		
	}
	
	public FinalFieldClass(double INCENTIVE_RATE) {
		this.INCENTIVE_RATE=INCENTIVE_RATE;
	}
	
}
