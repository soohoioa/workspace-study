
public class StaticMain {

	public static void main(String[] args) {
		System.out.println("-----static member access-----");
		
		/*
		 * 정적 멤버 접근
		 * 	- 클래스이름.정적멤버이름 -> 이런식으로 접근한다
		 *  위에서 클래스는 참조변수가 아니다.
		 *  
		 * 인스턴스변수들은 참조변수 있어야함
		 */
		
		Static.static_field = 8888;
		System.out.println(Static.static_field);
		Static.static_field = 9999;
		System.out.println(Static.static_field);
		Static.static_method();
		
		System.out.println();
		
		System.out.println("-----instance member access-----");
		Static static1 = new Static();
		System.out.println(">>> static 객체 주소 : " + static1);
		static1.instance_field = 1111;
		System.out.println("static1.instance_field : " + static1.instance_field);
		static1.instance_method();
		
		System.out.println();

		Static static2 = new Static();
		System.out.println(">>> static2 객체 주소 : " + static2);
		static2.instance_field = 2222;
		System.out.println("static1.instance_field : " + static2.instance_field);
		static2.instance_method();
		
		System.out.println();
		
		System.out.println("-----객체 참조 변수를 사용해서 static member access-----");
		System.out.println(static1.static_field);
		System.out.println(static2.static_field);
		/*
		  The static field Static.static_field should be accessed in a static way
		  정적 필드 Static.static_field는 정적 방법으로 액세스해야 합니다
		*/
		static1.static_method();
		static2.static_method();
		
	}

}
