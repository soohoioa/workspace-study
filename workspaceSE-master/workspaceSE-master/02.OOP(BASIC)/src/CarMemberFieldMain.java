
public class CarMemberFieldMain {

	public static void main(String[] args) {
		/*
		 * 주차 관리 프로그램 시작
		 */
		
		/*
		 * 1. 차량번호 1234 , 차량 12시 입차
		 * 데이터 (차량번호, 시간)
		 */
		Car car1; // 차 객체를 저장할 Car 클래스 타입 변수 선언 
		// ==>> 차 객체의 주소값을 저장할 Car 클래스 타입 참조 변수 선언
		car1 = new Car(); // car클래스를 사용해서 차객체를 생성한 후 car1변수에 대입 
		// ==>> car 클래스를 사용해서 차 객체를 생성한후 차 객체의 주소값이 car1 참조변수에 대입
		
		car1.no = "1234"; // 차 객체(car1) 의 멤버필드(멤버변수) no에 "1234" 값 대입
		car1.inTime = 12; // 차 객체(car1) 의 멤버필드(멤버변수) inTime에 12 값 대입
		
		/*
		 * 2. car1차량 16시 출차 
		 */
		
		/*
		 * 2-1. 출차 시간 대입
		 */
		car1.outTime = 16; // 차 객체(car1) 의 멤버필드(멤버변수) outTime에 "16" 값 대입
		
		/*
		 * 2-2. 주차 요금 계산 
		 */
		car1.fee = (car1.outTime - car1.inTime) * 1000;
		// 차 객체(car1) 의 멤버필드(멤버변수) fee에 차 객체(car1) 의 
		// outTime, inTime 멤버필드(멤버변수)를 사용해서 주차요금 계산 후 대입
		
		/*
		 * 2-3. 주차요금 영수증 출력 (객체정보출력)
		 */
		System.out.printf("-------------------------------------\n");
		System.out.printf("%s %s %s %s \n", "차량번호", "입차시간", "출차시간", "주차요금");
		System.out.printf("-------------------------------------\n");
		System.out.printf("%7s %8d %8d %9d", car1.no, car1.inTime, car1.outTime, car1.fee);
		
		
		// 멤버변수 = 멤버필드 
		// 일반변수 /= 멤버변수
		

	}

}
