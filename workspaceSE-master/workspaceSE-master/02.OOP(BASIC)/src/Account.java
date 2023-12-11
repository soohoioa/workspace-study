/*
 * 계좌 객체를 생성하기 위한 클래스(틀, 타입)
 * 
 * 객체모델링 - 객체를 생성할때 어떠한 값들을 넣을까 생각해서 만들기
 */
public class Account {
	
	/*
	 * 1. 속성 [멤버필드(멤버변수)]
	 */
	int no; 		// 계좌번호
	String owner; 	// 계좌주 이름
	int balance; 	// 계좌 잔고
	double iyul;	// 계좌 이율
	
	
	/*
	 * 2. 행위 [멤버메소드]
	 */
	
	/*
	 * 계좌 데이터를 대입하는 메소드
	 */
	void setAccountData(int no, String owner, int balancs, double iyul) {
		this.no = no; 
		this.owner = owner;
		this.balance = balancs;
		this.iyul = iyul;
	}

	
	
	
	/*
	 * 입금
	 */
	void deposit(int money) {
		this.balance += money;
		// 여기서 this 는 생략가능
	}
	
	// 외부에 제공하는 기능을 가지고 있는 이라고도 함
	// 자기자신도 호출가능 하지만 아직 안함
	
	
	
	/*
	 * 출금
	 */
	void withDraw(int money) {
		this.balance = this.balance - money;
		// this.balance -= money;
		// 여기서 this 는 생략가능
	}
	
	
	
	/*
	 * 계좌헤더출력
	 */

	void headerPrint() {
		System.out.println("-----------------------");
		System.out.printf("%s %s %4s %s \n", "번호", "이름", "잔고", "이율");
		System.out.println("-----------------------");	
	}
	// 이 메소드는 메모리 많이 잡아먹는 메소드
	
	
	
	/*
	 * 계좌 객체 정보 출력
	 */
	void print() {
		System.out.printf("%d %s %8d %.1f \n", this.no, this.owner, this.balance, this.iyul);	
	} 
	
	
	
	// 여기서 this 는 생략가능
	// System.out.printf("%d %s %8d %.1f \n", .no, .owner, .balance, .iyul);
	// 이런식으로 생략가능하다. 
	// 하나의 메소드안에 모든작업을 다하면 불편함
	// 메소드는 단위기능(쪼개질수없는)만 담아야함
	

	
	
}
