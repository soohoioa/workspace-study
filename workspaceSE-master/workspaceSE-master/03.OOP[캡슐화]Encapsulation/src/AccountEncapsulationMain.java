
public class AccountEncapsulationMain {

	public static void main(String[] args) {
		Account account1 = new Account();
		account1.setAccountData(1111, "KIM", 89000, 2.4);
		/*
		 * account1 8000원 입금
		 */
		account1.deposit(8000);
		account1.headerPrint();
		account1.print();
		
		/*
		 * account1 이율 1% 증가(변경) 
		 */
		// account1.iyul += 1;
		account1.setIyul(account1.getIyul() + 1.0);
		account1.print();
		
		/*
		 * account1 의 잔고 얻기
		 */
		
		int account1Balance = account1.getBalance();
		System.out.println("account1 잔고 : " + account1Balance);
		
		System.out.println("account1 잔고 : " + account1.getBalance());
		
		
		
		
		Account acc1 = new Account();	
		Account acc2 = new Account();	
		Account acc3 = new Account();	
		acc1.setAccountData(100, "CHOI", 890000, 3.5);
		acc2.setAccountData(200, "SIM ", 450000, 2.7);
		acc3.setAccountData(300, "LEE ", 120000, 1.2);
		
		/*
		 * 모든 계좌 잔고 50원 증가
		 */
		acc1.deposit(50);
		acc2.deposit(50);
		acc3.deposit(50);
		
		acc1.headerPrint();
		acc1.print();
		acc2.print();
		acc3.print();
		
		try {
			acc3.withDraw(1000000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			acc3.print();
			// e.printStackTrace();
		}
		
		
		
		
		
	}

}
