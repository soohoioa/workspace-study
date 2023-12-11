
public class FinalMethodClassChild extends FinalMethodClass{

	@Override
	public void method1() {
		System.out.println("FinalMethodClassChild서" + "FinalMethodClass.method1()재정의");
	}
	
	/*
	<< Cannot override the final method from FinalMethodClass >>
	FinalMethodClass에서 최종 메서드를 재정의할 수 없습니다
	public void method2() {
		
	}
	*/
}
