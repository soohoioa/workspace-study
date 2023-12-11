package generic;
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
	
	/**
	 * 기본값으로 초기화 된 계좌 객체 생성
	 */
	public Account() {
		// 생성자는 객체 초기화 용도로 사용한다
		// 기본생성자를 안만들면 나중에 문제 생길수 있으므로 꼭 만들어줘야함 --->> 나중에 추가예정
	}
	
	/**
	 * 인자 값으로 초기화된 계좌 객체 생성
	 * @param no 계좌번호
	 * @param owner 계좌주
	 * @param balance 계좌잔고
	 * @param iyul 계좌이율
	 */
	public Account(int no, String owner, int balance, double iyul) {
		this.no = no;
		this.owner = owner;
		this.balance = balance;
		this.iyul = iyul;
	}



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
	/**
	 * 입금
	 * @param money 입금할돈.  0 보다 큰 수 이어야 한다.
	 */
	public void deposit(int money) {
		this.balance += money;
	}
	
	
	
	/*
	 * 출금
	 */
	/**
	 * 출금
	 * @param money 출금할돈. 
	 */
	public void withDraw(int money) {
		this.balance = this.balance - money;
	}
	
	
	
	/*
	 * 계좌헤더출력
	 */
	/**
	 * 계좌 헤더출력
	 */
	public static void headerPrint() {
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
	 ali + shift + s -->> o -->> space + 화살표 
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

	/*
	@Override
	public String toString() {
		return "Account [no=" + no + ", owner=" + owner + ", balance=" + balance + ", iyul=" + iyul + "]";
	} 
	*/
	
	@Override
	public String toString() {
		return "Account [no=" + no + "]";
	} 
	
	
}
