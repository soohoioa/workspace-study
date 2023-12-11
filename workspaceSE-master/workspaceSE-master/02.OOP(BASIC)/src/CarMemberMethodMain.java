
public class CarMemberMethodMain {

	public static void main(String[] args) {
		Car car1 = new Car();
		
		
		
		/*
		 * 1. 차량번호 1234 , 차량 12시 입차 
		 * 데이터 (차량번호, 시간)
		 */
		// 입차시 데이터 (번호, 시간) 대입 메소드호출
		car1.setIpChaData("1234", 12);

		/*
		 * 2. car1차량 16시 출차 
		 */
		/*
		 * 2-1. 출차 시간 대입 메소드 호출 
		 */
		car1.setOutTime(16);
		
		/*
		 * 2-2. 주차 요금 계산 메소드 호출
		 */
		car1.calculateFee();
	
		
		/*
		 * 2-3. 주차요금 영수증 출력 메소드 호출
		 */
		
		car1.print();
		
		
		
		
		System.out.println("-----두번째 차량이 들어옴-----");
		
		Car car2 = new Car();
		car2.setIpChaData("7788", 17); 
		// 3시간후
		
		car2.setOutTime(20); // 기능은 적당한 때 호출해줘야 함
		car2.calculateFee();
		// 여기까지 car2는 주차요금까지 계산되어있음
		car2.print(); // -> 이제 영수증을 출력
		
	
		// Car 이라는 클래스(틀) 을 만들었기에 객체는 무한으로 생성이 가능하다.
			
	}

}
