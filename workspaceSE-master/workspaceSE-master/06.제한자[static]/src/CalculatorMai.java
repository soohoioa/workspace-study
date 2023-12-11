
public class CalculatorMai {

	public static void main(String[] args) {
		System.out.println("-----access non static way-----"); // 에러가 나는 잘못된 접근이다.
//		Calculator calculator=new Calculator();
//		int result=calculator.add(23,34); 
//		System.out.println(result);
//		result=calculator.sub(23,34);
//		System.out.println(result);
//		result=calculator.mul(23,34);
//		System.out.println(result);
//		result=calculator.div(45435,34);
//		System.out.println(result);
		// 이렇게 호출 못하게 할려면 객체생성을 불가능하게함 -> 외부에서 생성자 호출 막음
		// -->> 클래스를 public class Calculator 이 아니라  class Calculator 로 변경하면 에러가 나서 사용할수가 없다.
		
		

		System.out.println("-----access static way-----");
		int result =Calculator.add(12, 23);
		System.out.println(result);
		result =Calculator.sub(12, 23);
		System.out.println(result);
		result =Calculator.div(12, 23);
		System.out.println(result);
		result =Calculator.mul(12, 23);
		System.out.println(result);
		
		// System.out.println(Math.abs(-790));
		// System.out.println(Math.sqrt(2));
		// 옆으로 누르면 static 멤버필드
		
	}

}
