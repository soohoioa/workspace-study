/*
 * 계좌 객체를 생성하기 위한 클래스(틀, 타입)
 * 
 * 객체모델링 - 객체를 생성할때 어떠한 값들을 넣을까 생각해서 만들기
 */
public class Account {
	
	private int no; 		// 계좌번호
	private String owner; 	// 계좌주 이름
	private int balance; 	// 계좌 잔고
	private double iyul;	// 계좌 이율
	

	/*
	 * 계좌 데이터를 대입하는 메소드
	 */
	public void setAccountData(int no, String owner, int balancs, double iyul) {
		this.no = no; 
		this.owner = owner;
		this.balance = balancs;
		this.iyul = iyul;
	}


	/*
	 * 입금
	 */
	public void deposit(int money) {
		this.balance += money;
	}
	
	
	/*
	 * 출금
	 */
	public void withDraw(int money) throws Exception {
		if(money > this.balance) {
			throw new Exception("잔고가 부족합니다.");
		} else {
			balance = balance-money;
		}
		/* 사용자 정의 Exception은 return보다 효율적인 반환 방법이다.*/
	}
	
	
	/*
	 * 계좌헤더출력
	 */

	public void headerPrint() {
		System.out.println("-----------------------");
		System.out.printf("%s %s %4s %s \n", "번호", "이름", "잔고", "이율");
		System.out.println("-----------------------");	
	}
	
	
	/*
	 * 계좌 객체 정보 출력
	 */
	public void print() {
		System.out.printf("%d %s %8d %.1f \n", this.no, this.owner, this.balance, this.iyul);	
	}

	/* 
	  << getter,setter 메쏘드생성단축키>>
	 ali + shift + s -->> r -->> space + 화살표 
	 */
	
	// setter 
	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}


	public double getIyul() {
		return iyul;
	}


	public void setIyul(double iyul) {
		this.iyul = iyul;
	} 
	

	
	
	
	
	
	
}
