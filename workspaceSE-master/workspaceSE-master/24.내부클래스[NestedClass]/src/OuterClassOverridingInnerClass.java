
public class OuterClassOverridingInnerClass {
	
	private int outer_member_field;
	public void outer_member_method() {
		System.out.println("OuterClassOverridingInnerClass.outer_member_method()");
	}
	
	/***** OutClass에서 InnerClass 객체생성사용*****/
	public void outer_inner_class_use() {
		/***** member inner class[CASE1] *****/
		ChildParentFirstConcreteClass childParentFirstConcreteClass1 = new ChildParentFirstConcreteClass();
		ChildParendSecondAbstarctClass childParendSecondAbstarctClass1 = new ChildParendSecondAbstarctClass();
		ChildParentThirdInterfaceClass childParentThirdInterfaceClass1 = new ChildParentThirdInterfaceClass();
		childParentFirstConcreteClass1.method();
		childParendSecondAbstarctClass1.method();
		childParentThirdInterfaceClass1.method();
		
		/***** anonymous inner class[CASE2] *****/
		/*
		 * 특정 클래스의 메소드를 재정의 해야할때
		 * 1. local위치에 이름이 없는 클래스정의
		 * 2. local위치에서 객체를 생성
		 */
		ParentFirstConcreteClass childParentFirstConcreteClass2 = new ParentFirstConcreteClass() {
			
			@Override
			public void method() {
				System.out.println("ParentFirstConcreteClass를 상속받는 " 
						+ "이름없는 로칼 내부 클래스에서 재정의한 method()");
			}
		};
		childParentFirstConcreteClass2.method();
		
		ParentSecondAbstarctClass childParendSecondAbstarctClass2 = new ParentSecondAbstarctClass() { 
			// 이름이 없다는것은 타입이 존재하지 않는다. 
			// -> 타입이 존재하지 않는다는 것은상위타입으로 받을수밖에 없다는 것이다.

			@Override
			public void method() {
				System.out.println("ParentSecondAbstarctClass를 상속받는 " 
						+ "이름없는 로칼 내부 클래스에서 재정의한 method()");	
			}
		};
		childParendSecondAbstarctClass2.method();
		
		ParentThirdInterface childParentThirdInterfaceClass2 = new ParentThirdInterface() {
			
			@Override
			public void method() {
				System.out.println("ParentThirdInterface를 상속(구현)받는 " 
						+ "이름없는 로칼 내부 클래스에서 재정의한 method()");
				
			}
		};
		childParentThirdInterfaceClass2.method();
		
		
		Object objectChild = new Object()/*클래스 인터페이스 추상화 다 가능*/ {
			@Override
			public String toString() {
				
				return "난 재정의한 메소드";
			}
		};
		System.out.println(objectChild.toString());
		// { } 바디, class의 재정의
		
		
	}
	
	public static void main(String[] args) {
		OuterClassOverridingInnerClass outerClass = new OuterClassOverridingInnerClass();
		outerClass.outer_inner_class_use();
		
	}
	
	
	/***** member inner class *****/
	public class ChildParentFirstConcreteClass extends ParentFirstConcreteClass{
		@Override
		public void method() {
			System.out.println("ParentFirstConcreteClass를 상속받는 " 
					+ "ChildParentFirstConcreteClass에서 재정의한 method()");
		}
	}
	
	public class ChildParendSecondAbstarctClass extends ParentSecondAbstarctClass {

		@Override
		public void method() {
			System.out.println("ParentSecondAbstarctClass를 상속받는 " 
					+ "ChildParendSecondAbstarctClass에서 재정의한 method()");
		}
	}
	
	public class ChildParentThirdInterfaceClass implements ParentThirdInterface{

		@Override
		public void method() {
			System.out.println("ParentThirdInterface를 상속(구현)받는 " 
					+ "ChildParentThirdInterfaceClass에서 재정의한 method()");
		}
		
	}
	
	
	
}
