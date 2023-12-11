package lang;
// 오라클에서 클래스를 제공하므로 메인만 만든다
public class MathMain {
 
	public static void main(String[] args) {
		/*
		 * Math 클래스
		 * 	- 수학계산함수를 가지고 있는 클래스
		 * 	- 모든메소드는 static 정적메소드
		 *  - 객체생성이 불가능(생성자 접근 제한자 private) 
		 */
		
		// Math math = new Math();
		// The constructor Math() is not visible 생성자 산술()이 표시되지 않습니다

		double r =  Math.abs(127.421); // 객체가 없다는건 멤버필드 만들지 않음
		System.out.println(r);
		System.out.println(Math.max(999, 888));
		System.out.println(Math.min(999, 888));
		System.out.println(Math.round(33.5555555)); 
		System.out.println(Math.round(33.5555555*10)/10.0); // 연산시형변환
		System.out.println(Math.sqrt(2)); // 루트
		System.out.println(Math.sqrt(3));
		System.out.println(Math.sqrt(4));
		System.out.println(Math.pow(2,31)); 
		
		System.out.println("-------Math.random()-------");
		/*
		 * << public static double random() >> -> double 를 반환한다
		 * Returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0
		 * 0보다 크거나 같고 1.0보다 작은 양수 부호의 이중 값을 반환합니다
		 */
		System.out.println(Math.random());
		System.out.println(Math.random());
		System.out.println(Math.random());
		System.out.println(Math.random());
		
		System.out.println("1 ~ 10 사이의 정수 5개 랜덤 생성");
		System.out.println((int)(Math.random()*10) + 1); // 10을 곱하면 10.0 은 안나오지만 10+1을 하면 10이 나올수 있다
		System.out.println((int)(Math.random()*10) + 1);
		System.out.println((int)(Math.random()*10) + 1);
		System.out.println((int)(Math.random()*10) + 1);
		System.out.println((int)(Math.random()*10) + 1);
		// 0.0 ~ 9.9 까지 (Math.random()*10)
		// 1.0 ~ 10.0 까지 (Math.random()*10) + 1
		
		System.out.println("1 ~ 45 사이의 정수 6개 랜덤 생성");
		System.out.println((int)(Math.random()*45)+1);
		System.out.println((int)(Math.random()*45)+1);
		System.out.println((int)(Math.random()*45)+1);
		System.out.println((int)(Math.random()*45)+1);
		System.out.println((int)(Math.random()*45)+1);
		System.out.println((int)(Math.random()*45)+1);
	
		
	}

}