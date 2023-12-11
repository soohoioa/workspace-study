
public class LocalVariableMain {

	public static void main(String[] args) {
		/*
		 * 지역변수 (local variable)
		 * 	- 메소드 블록안에서 선언된변수 (매개변수)
		 * 
		 * 멤버변수 (멤버필드)
		 * 	- 클래스 블록 안에 선언된 변수
		 */
		
		/*
		 * local변수(기본형변수) - 메인블록에서 선언하면 로컬변수
		 */
		int a = 9;
		int b = 10;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
		/*
		 * 모든 변수는 반드시 초기화하여야 사용할수 있다.
		 * 값이 대입되어야 사용할수있다
		 */
		
		
		/*
		 <<1. The local variable tot may not have been initialized  
				-> 로컬 변수 토트가 초기화되지 않았을 수 있습니다>>
		int tot;
		System.out.println(tot);
		*/
		
		
		/*
		 <<2. The local variable tot may not have been initialized  
				-> 로컬 변수 토트가 초기화되지 않았을 수 있습니다>>
		int tot;
		boolean condition = true;
		if(condition) {
			tot = 0;
		}
		System.out.println(tot);
		*/
		
		
		/*
		<<3. The local variable tot may not have been initialized  
				-> 로컬 변수 토트가 초기화되지 않았을 수 있습니다>>
		int tot;
		tot = tot + 1;
		*/

		int tot1;
		tot1= 1;
		System.out.println("tot1 = " + tot1);
		
		int tot2;
		tot2 = 0;
		boolean condition = true;
		if(condition) {
			tot2 = 2;
		} // condition 변수이기에 초기화 작업 필요
		System.out.println("tot2 = " + tot2);
		
		int tot3;
		tot3 = 0;
		tot3 = tot3 +3;
		System.out.println("tot3 = " + tot3);
		
		/*
		 * local변수(참조형변수)
		 */
		/*
		<<1. The local variable order1 may not have been initialized
				- 로컬 변수 순서1이 초기화되지 않았을 수 있습니다>>
		Order order1;
		order1.print(); // order1 지역변수 -> 초기화가 되야함
		*/
		
		Order order1;
		order1 = new Order(1, "아이패드외3종", "2023-06-02", 56000);
		order1.print();
		
		
		/* 
		 <<2. The local variable order2 may not have been initialized
		 		- 로컬 변수 순서2가 초기화되지 않았을 수 있습니다>>
		 		condition2 변수값이 변경될수있으므로
		 		아래문은 else 가 있어 true가 아니면 false 가 나올수있으므로
		Order order2;
		boolean condition2 = true;
		if(condition2) {
			order2 = new Order(2, "바지외4종", "2023-06-02", 23000);
		}
		order2.print();
		*/
		
		Order order2;
		boolean condition2 = true;
		if (condition2) {
			order2 = new Order(20, "TV외2종", "2023-06-02", 56000);
		} else {
			order2 = new Order(tot2, "NOTEBOOK외1종", "2023-06-02", 34000);
		}
		order2.print();
		
		/*
		 * 참조변수 초기화시 기본값
		 * 	- null(참조변수 리터럴)
		 * 	- 주소없다 주소값 -> 초기화 용도로 사용
		 */
		
		Order order3 = null; // 이렇게 초기화를 함
		if (order3 == null) {
			order3 = new Order(3, "시계외2종", "2023-06-02", 80000);
		}
		order3.print();
		// Null pointer access: The variable order3 can only be null at this location
		
		
		
		
	}

}
