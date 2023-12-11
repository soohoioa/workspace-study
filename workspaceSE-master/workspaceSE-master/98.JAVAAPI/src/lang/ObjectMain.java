package lang;

public class ObjectMain {

	public static void main(String[] args) {
		/*
		 Object 클래스는 클래스 계층 루트입니다. 
		 모든 클래스는 슈퍼 클래스로서 Object를 가집니다. 
		 배열을 포함한 모든 객체는 이 클래스의 메서드를 구현합니다.
		 
		 Class Object is the root of the class hierarchy. 
		 Every class has Object as a superclass. 
		 All objects, including arrays, implement the methods of this class.
		 */ 
		
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = o1;
		
		/*
		 <<Object>>
		 public String toString()
		 	- Returns a string representation of the object.
		 */
		String str1 = o1.toString();
		System.out.println(str1);
		System.out.println(o2.toString());
		System.out.println(o2);
		
		/*
		 <<Object>>
		 public boolean equals(Object obj)
		 	- Indicates whether some other object is "equal to" this one.
		 	- 주소가 동일한지 비교
		 Parameters:
			obj - the reference object with which to compare.
		 Returns:
			true if this object is the same as the obj argument; false otherwise.
		 */
		if(o1.equals(o2)) {
			System.out.println("o1 과 o2 의 주소가 동일하다.[equals]");
		} else {
			System.out.println("o1 과 o2 의 주소가 동일하지 않다.[equals]");
		}
		if(o1.equals(o3)) {
			System.out.println("o1 과 o3 의 주소가 동일하다.[equals]");
		} else {
			System.out.println("o1 과 o3 의 주소가 동일하지 않다.[equals]");
		} // equals 재정의해서 사용
		
		
		if(o1 == o2) {
			System.out.println("o1 과 o2 의 주소가 동일하다.[==비교연산자]");
		} else {
			System.out.println("o1 과 o2 의 주소가 동일하지 않다.[==]");
		}
		if(o1 == o3) {
			System.out.println("o1 과 o3 의 주소가 동일하다.[==]");
		} else {
			System.out.println("o1 과 o3 의 주소가 동일하지 않다.[==]");
		}
		System.out.println("----------ObjectChild----------");
		ObjectChild oc1 = new ObjectChild();
		ObjectChild oc2 = new ObjectChild();
		ObjectChild oc3 = oc1;
		System.out.println("-----재정의된 equlas-----");
		if(oc1.equals(oc3)) {
			System.out.println("oc1 과 oc3 주소가 동일하다.");
		} else {
			System.out.println("oc1 과 oc3 주소가 동일하지 않다.");
		}
		
		System.out.println("-----재정의된 toString-----");
		System.out.println(oc1.toString());
		System.out.println(oc2);
		System.out.println(oc3);
		
		
		
	}

}
