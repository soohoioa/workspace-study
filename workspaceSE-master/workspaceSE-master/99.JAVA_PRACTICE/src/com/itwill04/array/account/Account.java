package com.itwill04.array.account;

public class Account {
	/*
	 * 1.속성[멤버필드]
	 */
	private int no;			//계좌번호
	private String owner;	//계좌주이름
	private int balance;	//잔고
	private double iyul;    //이율
	
	
	/*
	 * 2.생성자메쏘드(오버로딩)
	 */
	public Account() {
		
	}
	public Account(int no, String owner, int balance, double iyul) {
		
		this.no = no;
		this.owner = owner;
		this.balance = balance;
		this.iyul = iyul;
	}
	/*
	 * 3. 멤버메쏘드[기능](계좌 객체가 가지고있는 기능 )
	 */
	
	/*
	 * 계좌데이타를 대입하는메쏘드
	 */
	public void setAccountData(int no,String owner,int balance,double iyul) {
		this.no=no;
		this.owner=owner;
		this.balance=balance;
		this.iyul=iyul;
	}
	
	/*
	 * 입금
	 */
	public void deposit(int m) {
		this.balance+=m;
	}
	/*
	 * 출금
	 */
	public void withDraw(int m) {
		this.balance-=m;
	}
	/*
	 * 계좌헤더출력메쏘드(?????)
	 */
	public static void headerPrint() {
		System.out.println("--------------------------");
		System.out.printf("%s %5s %4s %4s \n","번호","이름","잔고","이율");
		System.out.println("--------------------------");
	}
	/*
	 * 계좌객체정보출력
	 */
	public void print() {
		System.out.printf("%4d %6s %8d %5.2f \n",this.no,this.owner,this.balance,this.iyul);
	}
	//getter,setter

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














