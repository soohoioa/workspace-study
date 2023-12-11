
public class FinalMethodClassMain {

	public static void main(String[] args) {
		FinalMethodClassChild fmcc1 = new FinalMethodClassChild();
		
		fmcc1.method1();
		fmcc1.method2(); // 상속되어진 child 꺼

		FinalMethodClass fmcc2 = new FinalMethodClassChild();
		fmcc2.method1();
		fmcc2.method2();

		// 상속받는이유 = 부모꺼 쓸려고 그래야 유지보수확장성 높일려고
		
	}

}
