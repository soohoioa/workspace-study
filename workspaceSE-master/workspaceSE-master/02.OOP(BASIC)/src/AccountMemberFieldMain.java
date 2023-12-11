
public class AccountMemberFieldMain {

	public static void main(String[] args) {
		/**************case1************/
		
		/*
		 * 1. 1111번계좌 8000원 입금
		 */
		
		/*
		 * 1-1. 계좌 객체 생성
		 * 1-2. 계좌 데이터 대입
		 */
		Account acc1 = new Account();
		acc1.no = 1111;
		acc1.owner = "KIM";
		acc1.balance = 10000;
		acc1.iyul = 3.0;
		
		/*
		 * 1-3. 계좌잔고 8000원 증가 -> 입금
		 */
		// 연산 후 대입 연산자를 사용해서 누적계산할수있다
		acc1.balance = acc1.balance+8000;
		
		/*
		 * 2. 1111 계좌정보를 출력
		 */
		System.out.println("-----------------------");
		System.out.printf("%s %s %4s %s \n", "번호", "이름", "잔고", "이율");
		System.out.println("-----------------------");
		System.out.printf("%d %s %8d %.1f \n", acc1.no, acc1.owner, acc1.balance, acc1.iyul);
		
		// %f 는 double 값을 넣는다
		
		
		
		
		/**************case2************/
		
		/*
		 * 1. 은행 모든 계좌의 잔고 50원 증가
		 */
		
		/*
		 * 1-1. 전체계좌 생성
		 * 1-2. 계좌데이터 대입
		 */
		Account a1 = new Account();
		
		a1.no = 1000;
		a1.owner = "KIN";
		a1.balance = 70000;
		a1.iyul = 2.0;
		
		Account a2 = new Account();
		a2.no = 2000;
		a2.owner = "LEE";
		a2.balance = 98000;
		a2.iyul = 3.5;
		
		Account a3 = new Account();
		a3.no = 3000;
		a3.owner = "SIN";
		a3.balance = 34000;
		a3.iyul = 2.8;
		
		/*
		 * 1-3. 모든계좌 잔고 50원 증가
		 */
		a1.balance += 50;
		a2.balance += 50;
		a3.balance += 50;
		
		/*
		 * 2. 은행계좌 전체정보출력 -> 전체 잔액 조회
		 */
		
		System.out.println("-----------------------");
		System.out.printf("%s %s %4s %s \n", "번호", "이름", "잔고", "이율");
		System.out.println("-----------------------");
		System.out.printf("%d %s %8d %.1f \n", a1.no, a1.owner, a1.balance, a1.iyul);
		System.out.printf("%d %s %8d %.1f \n", a2.no, a2.owner, a2.balance, a2.iyul);
		System.out.printf("%d %s %8d %.1f \n", a3.no, a3.owner, a3.balance, a3.iyul);
		
	}

}
