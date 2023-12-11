
public class ConstructorMain {

	public static void main(String[] args) {
		System.out.println("--------------c1---------------");
		/*
		<< new Constructor();>>
		   1. Constructor 클래스로객체생성
		   2. 생성자메쏘드(블록) 호출
		   3. 생성된 객체의 주소를 반환
		 */
		Constructor c1 = 
				new Constructor(); 
		System.out.println("c1:"+c1);
		// public Constructor() 기본(디폴트)생성자 호출:Constructor@15db9742
		// c1:Constructor@15db9742
		c1.print();
		Constructor c2=
				new Constructor(7777, 8888);
		c2.print();
		

	}

}
