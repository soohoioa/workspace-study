
public class InterfaceABImplMain {

	public static void main(String[] args) {
		System.out.println("-----InterfaceABImpl-----");
		InterfaceABImpl abImpl = new InterfaceABImpl(); //상속관계를 맺는것보다는 의존성줄이기 위해 상위타입참조하는것이 낫다
		abImpl.method1();
		abImpl.method2();
		abImpl.method3();
		abImpl.method4();
		
		System.out.println("-----InterfaceA-----");
		InterfaceA ia = abImpl;
		ia.method1();
		ia.method2();
		/*
		ia.method3();
		ia.method4();
		*/
		
		System.out.println("-----InterfaceB-----");
		InterfaceB ib = abImpl;
		/*
		ib.method1();
		ib.method2();
		*/
		ib.method3();
		ib.method4();

		System.out.println("-----InterfaceA <--> InterfaceB-----");
		System.out.println(abImpl);
		System.out.println(ia);
		System.out.println(ib);
		System.out.println();
		InterfaceA ia2 = new InterfaceABImpl();
		ia2.method1();
		ia2.method2();
		/*
		ia2.method3();
		ia2.method4();
		*/
		InterfaceB ib2 = (InterfaceB)ia2; // 상위타입끼리, 캐스팅가능
		// InterfaceA 와 InterfaceB - 관계는 없지만 같은부모를 받고있다. 부모도 부모끼리관계 없음(부모-자식 가능, 부모-부모,자식-자식 불가능)
		/*
		ib2.method1();
		ib2.method2();
		*/
		ib2.method3();
		ib2.method4();
		
		// 부모가 여러개라 상속받는게 서로 다름

	}

}
