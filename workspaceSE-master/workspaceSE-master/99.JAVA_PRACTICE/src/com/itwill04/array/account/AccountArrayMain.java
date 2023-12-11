package com.itwill04.array.account;

public class AccountArrayMain {

	public static void main(String[] args) {
		System.out.println("-----------배열객체생성 블록{} 초기화-----------");
		Account acc1=new Account(1111, "KIM", 56000, 0.9);
		Account[] accounts= {
				acc1,
				new Account(2222, "LEE", 58900, 0.5),
				new Account(3333, "PARK", 78000, 0.4),
				new Account(4444, "CHOI", 34000, 0.3),
				new Account(5555, "SIM", 66000, 0.7),
				new Account(6666, "HONG", 99000, 1.4),
				new Account(7777, "KIM", 87600, 0.6),
				new Account(8888, "SOO", 12300, 2.3),
				new Account(9999, "MIN", 41200, 4.1)
		};
		
		System.out.println("1.은행총계좌수:"+accounts.length);
		System.out.println("2.은행계좌전체출력");
		Account.headerPrint();
		/*for(Account tempAccount:accounts) {
			tempAccount.print();
		}*/
		for(int i=0;i<accounts.length;i++) {
			accounts[i].print();
		}
		System.out.println("3.은행계좌들 총잔고");
		int totBalance=0;
		for(int i=0;i<accounts.length;i++) {
			totBalance+=accounts[i].getBalance();
		}
		System.out.println(">> "+totBalance);
		System.out.println("4.은행 계좌들중에서 계좌번호 3333번계좌 한개 찾아서 출력(계좌번호는 중복되지않는다)");
		for(int i=0;i<accounts.length;i++) {
			if(accounts[i].getNo()==3333) {
				accounts[i].print();
				break;
			}
		}
		System.out.println("5.은행 계좌들중에서 계좌잔고 50000원이상인 VIP계좌 여러개 찾아서 출력");
		for(int i=0;i<accounts.length;i++) {
			if(accounts[i].getBalance()>=50000) {
				accounts[i].print();
			}
		}
		System.out.println("6.은행 계좌들중에서 계좌이율 2.0 이상인 계좌 여러개 찾아서 출력[Quiz]");
		
		System.out.println("6.은행 계좌들중에서 이름이 KIM인 계좌 여러개 찾아서 출력");
		for(int i=0;i<accounts.length;i++) {
			if(accounts[i].getOwner().equals("KIM")) {
				accounts[i].print();
			}
		}
		
		System.out.println("7.6666번계좌 3000원입금");
		for(int i=0;i<accounts.length;i++) {
			if(accounts[i].getNo()==6666) {
				System.out.println(">>입금전");
				accounts[i].print();
				
				accounts[i].deposit(3000);
				
				System.out.println(">>입금후");
				accounts[i].print();
				
				break;
			}
		}
		System.out.println("8.9999번계좌 3000원출금[Quiz]");
		
		System.out.println("9.계좌잔고순으로 오름차순정렬");
		System.out.println("##############정렬전###############");
		for(int i=0;i<accounts.length;i++) {
			accounts[i].print();
		}
		//8회
		for(int i=0;i<accounts.length-1;i++) {
			for(int j=0;j<accounts.length-1;j++) {
				int balance1 = accounts[j].getBalance();
				int balance2 = accounts[j+1].getBalance();
				if(balance1 > balance2) {
					//주소값 교환
					Account tempAccount = accounts[j];
					accounts[j]=accounts[j+1];
					accounts[j+1]=tempAccount;
				}
			}
		}
		System.out.println("##############w잔고정렬후###############");
		for(int i=0;i<accounts.length;i++) {
			accounts[i].print();
		}
		System.out.println("9.계좌잔고순으로 내림차순정렬");
		System.out.println("9.계좌번호순으로 오름(내림)차순정렬[Quiz]");
		System.out.println("9.계좌이름순으로 오름(내림)차순정렬");
		
		
		System.out.println("##############이름으로정렬후###############");
		for(int i=0;i<accounts.length;i++) {
			accounts[i].print();
		}
		
		System.out.println("10.5555계좌한개 이율을 3.6으로변경");
		for(int i=0;i<accounts.length;i++) {
			if(accounts[i].getNo()==5555) {
				System.out.println(">>변경전");
				accounts[i].print();
				
				accounts[i].setIyul(3.6);
				
				System.out.println(">>변경후");
				accounts[i].print();
				
				
				break;
			}
		}
		System.out.println("11.VIP계좌(잔고50000원이상)여러개 잔고 50원 증가");
		for(int i=0;i<accounts.length;i++) {
			if(accounts[i].getBalance()>=50000) {
				accounts[i].deposit(50);
				accounts[i].print();
			}
		}
		
		
		
		/********************OPTION***********************
		  1. accounts배열 객체에 새로생성한계좌객체 추가 
		  		A. accounts.length+1 개짜리 임시배열생성
		 		B. accounts의 모든계좌객체 임시배열로 이동
				C. 임시배열에 새로운  Account객체추가
		 		D. accounts에 임시배열주소대입
		 
		  2. accounts배열 객체에서 계좌번호 4444번계좌객체삭제
		  	 	A. accounts 에서 8888계좌찾아서 null대입
			 	B. accounts.length-1 개짜리 임시배열생성
			 	C. accounts null이아닌 모든계좌 임시배열로이동
			  	D. accounts 에 임시배열대입 
		 */
		System.out.println("--------------------Account객체추가---------------------");
		/*
		 * 배열크기증가
		 */
		Account[] tempAccounts = new Account[accounts.length + 1];
		for (int i = 0; i < accounts.length; i++) {
			tempAccounts[i] = accounts[i];
		}
		/*
		  마지막인덱스에 Account객체대입
		  Account newAccount = new Account();
		  tempAccounts[accounts.length] = newAccount;
		 */
		Account newAccount = new Account(1112, "NEWACCOUNT", 45000, 3.5);
		tempAccounts[tempAccounts.length - 1] = newAccount;
		
		accounts = tempAccounts;
		
		System.out.println("-------추가후출력----------");
		for(int i=0;i<accounts.length;i++) {
			accounts[i].print();
		}
		System.out.println("----------------4444번 Account객체삭제---------------------");
		
		
		
		
	}

}














