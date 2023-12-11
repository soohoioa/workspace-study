package generic;

public class MyArrayListMain {

	public static void main(String[] args) {
		Account acc1= new Account(1111, "BING", 33000, 0.3);
		Account acc2= new Account(2222, "KING", 12000, 1.1);
		Account acc3= new Account(3333, "YING", 89000, 5.6);
		Account acc4= new Account(4444, "SING", 45000, 4.8);
		Account acc5= new Account(5555, "PING", 99000, 2.9);
		 
		MyArrayList<Account> accountList = new MyArrayList<Account>();
		
		int size = accountList.size();
		System.out.println("#size : " + size);
		accountList.add(acc1);
		System.out.println("#size : " + accountList.size());
		accountList.add(acc2);
		System.out.println("#size : " +  accountList.size());
		accountList.add(acc3);
		System.out.println("#size : " +  accountList.size());
		accountList.add(acc4);
		System.out.println("#size : " +  accountList.size());
		accountList.add(acc5);
		System.out.println("#size : " + accountList.size());
		
		Account getAccount = accountList.get(0);
		System.out.println(getAccount);
		
		
	}

}
