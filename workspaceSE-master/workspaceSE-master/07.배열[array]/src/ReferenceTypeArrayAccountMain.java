
public class ReferenceTypeArrayAccountMain {

	public static void main(String[] args) {
		System.out.println("-----{ }를 사용한 배열객체 생성과 초기화");
		Account acc1 = new Account(1111, "LEE", 560000, 0.8);
		
		
		Account[] accounts = {
				acc1,
				new Account(2222, "KIM", 990000, 3.5),
				new Account(3333, "PARK", 965000, 6.9),
				new Account(4444, "LEE", 342000, 2.9),
				new Account(5555, "CHOI", 738000, 4.8),
				new Account(6666, "SIM", 612900, 9.2),
				new Account(7777, "SOO", 560000, 5.8),
				new Account(8888, "MIN", 123000, 2.2),
				new Account(9999, "JANG", 980000, 8.9)
		};
		
		
		
		System.out.println();
		System.out.println("1.은행총계좌수 : " + accounts.length); // 배열의 멤버수
		
		
		
		System.out.println();
		System.out.println("2.은행계좌 전체출력");
		Account.headerPrint();
		for (int i = 0; i < accounts.length; i++) {
			Account tempAccount = accounts[i];
			tempAccount.print();
			// -->> accounts[i]를 tempAccount 로 대입받아서 tempAccount를 print한다
			// accounts[i].print();
		}
		
		
		
		System.out.println();
		System.out.println("2.은행계좌 전체출력(enhanced for)");
		Account.headerPrint();
		for (Account temAccount:accounts) { // Account temAccount는  for문 안 로컬변수 
			temAccount.print();
		}


		
		System.out.println();
		System.out.println("3.은행계좌들 총잔고");
		int totBalance = 0;
		for (int i = 0; i < accounts.length; i++) {
			totBalance = totBalance + accounts[i].getBalance(); // 캡슐화(private) 되어있어서 .Balance();는 사용 못하므로 get을 이용해서 .getBalance(); 라 작성한다
		}
		System.out.println(">> " + totBalance);
		
		
		
		System.out.println();
		System.out.println("4.은행 계좌들중에서 계좌번호 3333번계좌 한개 찾아서 출력(계좌번호는 중복되지않는다)");
		for (int i = 0; i < accounts.length; i++) {
			if(accounts[i].getNo() == 3333) {
				accounts[i].print();
				break; // 계좌는 중복되지 않는다 하였으므로(한개만 찾는다) 3333을 찾으면 break 문을사용해서 탈츨한다.
			}
		}
		
		
		
		System.out.println();
		System.out.println("5.은행 계좌들중에서 계좌잔고 500000원이상인 VIP계좌 여러개 찾아서 출력[enhanced for]");
		for (Account tempAccount : accounts) {
			if(tempAccount.getBalance() >= 500000) {
				tempAccount.print();
			}
		}
		
		
		
		System.out.println();
		System.out.println("6.은행 계좌들중에서 계좌이율 2.0 이상인 계좌 여러개 찾아서 출력[Quiz]");
		for (int i = 0; i < accounts.length; i++) {
			if(accounts[i].getIyul() >= 2.0) {
				accounts[i].print();
			}
		}
		
		
		System.out.println();
		System.out.println("6-1.은행 계좌들중에서 계좌이율 5.0 이상인 계좌 여러개 찾아서 출력[Quiz]");
		for (Account account : accounts) {
			if(account.getIyul() >= 5.0) {
				account.print();
			}
		}
		
		
		
		// System.out.println("7.은행 계좌들중에서 이름이 KIM인 계좌 여러개 찾아서 출력[String객체배우고난후에]");
		
		
		
		System.out.println();
		System.out.println("8.6666번계좌 3000원입금");
		for (int i = 0; i < accounts.length; i++) {
			if(accounts[i].getNo() == 6666) {
				System.out.println(">> 입금 전");
				accounts[i].print();
				
				accounts[i].deposit(3333); 
				
				System.out.println(">> 입금 후");
				accounts[i].print();
				break; 
			}
		}
		
		
		
		System.out.println();
		System.out.println("9.9999번계좌 3000원출금[Quiz]");
		for (int i = 0; i < accounts.length; i++) {
			if(accounts[i].getNo() == 9999) {
				System.out.println(">> 출금 전");
				accounts[i].print();
				
				accounts[i].withDraw(3000);
				
				System.out.println(">> 출금 후");
				accounts[i].print();
				break; 
			}
		}
		
		
		
		System.out.println();
		System.out.println("9-1.9999번계좌 3000원출금[Quiz]");
		for (Account account : accounts) {
			if(account.getNo() == 9999) {
				account.print();
				account.withDraw(3000);
				account.print();
			}
		}
		
		
		
		System.out.println();
		System.out.println("10.계좌잔고순으로 오름차순정렬");
		System.out.println(">>>>>>>>>> 정렬전 <<<<<<<<<<");
		for (int i = 0; i < accounts.length; i++) {
			accounts[i].print();
		}
		
		// 1회 정렬
		for(int j = 0; j < accounts.length - 1; j++) { // 앞이 작으면 바꾸다 -> 내림차순. 앞이 크면 바꾼다 -> 오름차순
			// 마지막은 비교할 필요가 없으니 -1 을 해주면 된다.
			if(accounts[j].getBalance() > accounts[j + 1].getBalance()) {
				Account tempAccount = accounts[j + 1];
				accounts[j + 1] = accounts[j];
				accounts[j] = tempAccount;
			}
		}
		
		// ------------------------------------------------------------------
		
		// 8회 정렬
		for(int i = 0; i < accounts.length - 1; i++ ) {
			for(int j = 0; j < accounts.length - 1 - i; j++) {
				if(accounts[j].getBalance() > accounts[j + 1].getBalance()) {
				// if(accounts[j].getBalance() - accounts[j + 1].getBalance() > 0) -> 이렇게도 기능함. 앞에서 뒤를 뺸 0보다 큼
					// 주소값 교환.  오름차순이면 > , 내림차순이면 < 
					Account tempAccount = accounts[j + 1];
					accounts[j + 1] = accounts[j];
					accounts[j] = tempAccount;
				}
			}
		}
		
		System.out.println(">>>>>>>>>> 8회 정렬후 <<<<<<<<<<");
		for (int i = 0; i < accounts.length; i++) {
			accounts[i].print();
		}
		
		
		
		System.out.println();
		System.out.println("11.계좌잔고순으로 내림차순정렬[Quiz]");
		for(int i = 0; i < accounts.length - 1; i++ ) {
			for(int j = 0; j < accounts.length - 1 - i; j++) {
				if(accounts[j].getBalance() < accounts[j + 1].getBalance()) {
					Account tempAccount = accounts[j + 1];
					accounts[j + 1] = accounts[j];
					accounts[j] = tempAccount;
				}
			}
		}
		System.out.println(">>>>>>>>>> 내림차순으로 정렬 <<<<<<<<<<");
		for (int i = 0; i < accounts.length; i++) {
			accounts[i].print();
		}
		
		
		
		System.out.println();
		System.out.println("12.계좌번호순으로 오름(내림)차순정렬[Quiz]");
		for(int i = 0; i < accounts.length - 1; i++ ) {
			for(int j = 0; j < accounts.length - 1 - i; j++) {
				if(accounts[j].getNo() > accounts[j + 1].getNo()) {
					Account tempAccount = accounts[j + 1];
					accounts[j + 1] = accounts[j];
					accounts[j] = tempAccount;
				}
			}
		}
		System.out.println(">>>>>>>>>> 계좌번호순으로 오름차순정렬 <<<<<<<<<<");
		for (int i = 0; i < accounts.length; i++) {
			accounts[i].print();
		}
		
		for(int i = 0; i < accounts.length - 1; i++ ) {
			for(int j = 0; j < accounts.length - 1 - i; j++) {
				if(accounts[j].getNo() < accounts[j + 1].getNo()) {
					// 주소값 교환
					Account tempAccount = accounts[j + 1];
					accounts[j + 1] = accounts[j];
					accounts[j] = tempAccount;
				}
			}
		}
		System.out.println(">>>>>>>>>> 계좌번호순으로 내림차순정렬 <<<<<<<<<<");
		for (int i = 0; i < accounts.length; i++) {
			accounts[i].print();
		}
		
		
		
		// System.out.println("13.계좌이름순으로 오름(내림)차순정렬(String 클래스를 배운후에추가)");
		
		
		
		System.out.println();
		System.out.println("14.5555계좌한개 이율을 9.9 로변경");
		for (Account account : accounts) {
			if(account.getNo() == 5555) {
				account.print();
				account.setIyul(9.9);
				account.print();
			}
		}
		
		
		
		System.out.println();
		System.out.println("15.VIP계좌(잔고500000원이상)여러개 잔고 50원 증가");
		for (int i = 0; i < accounts.length; i++) {
			if(accounts[i].getBalance() >= 500000) {
				accounts[i].deposit(50);
			}
		}
		Account.headerPrint();
		for (Account account : accounts) {
			account.print();
		}
		
		
	}

}
