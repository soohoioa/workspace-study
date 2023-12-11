
/**
 * 주차장에서 차 객체를 생성할클래스
 * @author ITWILL
 * @version 0.1 메이저 / 마이너
 */

public class Car { 

		private String no; // 차량 번호
		private int inTime; // 입차시간
		private int outTime; // 출차시간
		private int fee; // 주차 요금
		
		
		/*
		 * 입차 시 데이터 대입 메소드-> 입차시간과 차번호 라는 데이터값이 2개 들어옴
		 */
		/**
		 * 입차시 데이터 대입 메소드
		 * @param no 차량번호
		 * @param inTime 입차시간 
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
		/**
		 * 주차 요금 계산
		 */
		public void calculateFee() {
			this.fee = (this.outTime - this.inTime) * 1000;
		}
		/**
		 * 차량 정보 출력 
		 */
		public void print() {
			System.out.printf("-------------------------------------\n");
			System.out.printf("%s %s %s %s \n", "차량번호", "입차시간", "출차시간", "주차요금");
			System.out.printf("-------------------------------------\n");
			System.out.printf("%7s %8d %8d %9d\n\n", this.no, this.inTime, this.outTime, this.fee);
		}

		
		// setter
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
		/**
		 * 
		 * @return 주차요금
		 */
		public int getFee() {
			return fee; 
		}

		public void setFee(int fee) {
			this.fee = fee;
		}

		public int getOutTime() {
			return outTime;
		}
		

		
		
		
		
		
		// 틀보고 객체를 상상해서 호출
		// 틀로는객체를 무한으로 생성할수있다 
		
		
}
