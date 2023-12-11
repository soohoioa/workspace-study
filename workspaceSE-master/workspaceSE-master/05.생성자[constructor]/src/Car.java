
public class Car { // Alt + Shift + r : 클래스안의 구성요소 이름을 모두 한번에 바꿀수있음 . 많이 사용하는 단축키

		private String no; // 차량 번호
		private int inTime; // 입차시간
		private int outTime; // 출차시간
		private int fee; // 주차 요금
		
		
		/*
		 * 생성자 메소드
		 */
		/*
		 * 멤버필드의 기본값을 가진 차 객체 생성
		 */
		public Car() {
			// 생성자는 객체 초기화 용도로 사용한다
			// 기본생성자를 안만들면 나중에 문제 생길수 있으므로 꼭 만들어줘야함 --->> 나중에 추가예정
		}
		/*
		 * 차량번호, 입차시간을 인자(매개변수)로 받아서 멤버필드의 값을 초기화 시키는 생성자
		 */
		public Car(String no, int inTime) {
			this.no = no;
			this.inTime = inTime;
		}
		/*
		 * 차량멤버 데이터를 인자로 받아서 멤버필드의 값을 가진 차 객체 생성
		 */
		public Car(String no, int inTime, int outTime, int fee) {
			this.no = no;
			this.inTime = inTime;
			this.outTime = outTime;
			this.fee = fee;
		}

		
		
		/*
		 * 입차 시 데이터 대입 메소드-> 입차시간과 차번호 라는 데이터값이 2개 들어옴
		 */
		public void setIpChaData (String no, int inTime) {
			this.no = no; // 여기서 this는 생략하면 안된다 왜냐하면 값이 다르기 때문에
			this.inTime = inTime;
		}
		
		
		
		/*
		 * 출차시 출차시간 대입 메소드
		 */
		public void setOutTime(int outTime) {
			this.outTime = outTime;
		}
		
		
		
		/*
		 * 출차시 주차요금 계산
		 */
		public void calculateFee() {
			this.fee = (this.outTime - this.inTime) * 1000;
		}
		public void headerPrint() {
			System.out.printf("-------------------------------------\n");
			System.out.printf("%s %s %s %s \n", "차량번호", "입차시간", "출차시간", "주차요금");
			System.out.printf("-------------------------------------\n");
		}
		public void print() {
			System.out.printf("%7s %8d %8d %9d\n\n", this.no, this.inTime, this.outTime, this.fee);
		}

		
		
		// setter , getter 
		public String getNo() {
			return no;
		}
		public void setNo(String no) {
			this.no = no;
		}
		public int getInTime() {
			return inTime;
		}
		public void setInTime(int inTime) {
			this.inTime = inTime;
		}
		public int getFee() {
			return fee;
		}
		public void setFee(int fee) {
			this.fee = fee;
		}
		public int getOutTime() {
			return outTime;
		}
		

		
}
