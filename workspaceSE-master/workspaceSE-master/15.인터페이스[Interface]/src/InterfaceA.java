/*
 인터페이스
    1. 클래스가가진 모든 메쏘드가 추상메쏘드임 (슈퍼인터페이스로 여러개가능하지만 구현되지는않음 -> 인터페이스는 바디가 없어 기능자체가 구현되지는 않음)
    2. 다중상속의 효과를 냄
       (클래스는 불가능하나 인터페이스는가능하다)
   -형식
     * class keyword 대신에 interface 라는 keyword를사용
     * 추상메쏘드앞에 abstract 를 붙히지않는다.
     ex>public interface Test{ 바디존재없음
     		public void method1();
     		public void method2();
        }
   - 사용
       1. interface를 상속(implements)받아서
       2. 추상메쏘드를 재정의(구현)한후 사용한다.
       
       ex> public class TestImpl implements Test{
       			public void method1(){}
     			public void method2(){}
          }
*/


/*
 * interface  keyword 사용
 */
public interface InterfaceA { // 하위객체참조, 상속 상위로 캐스팅
	/*
	 * interface안에 정의된 메소드는 추상메소드여야 한다.
	 * 	- Abstract methods do not specify a body -> 추상 메서드가 바디를 지정하지 않음
	 */
	public void method1(); // abstract 생략 가능
	public abstract void method2();
	
	
	
	
}

















