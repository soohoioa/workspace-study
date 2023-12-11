
public class ReferenceTypeArrayMain {
	public static void main(String[] args) {
		/*
		int a; // int 객체 주소값 
		int[] ia; // int 배열객체의 주소값
		Account acc; // account 객체 주소값
		Account[] accArray; // account 배열객체 주소값
		*/
		
		// Account[] accountArray = new Account(); -> 사용불가
		// << Type mismatch: cannot convert from Account to Account[] >>
		// Account[] accountArray -> 배열타입 
		// new Account(); -> account 타입
		
		Account[] accountArray = new Account[5];
		// System.out.println(accountArray);
		
		accountArray[0] = new Account(1, "KIM", 30000, 0.3);
		accountArray[1] = new Account(2, "LEE", 45000, 4.2);
		accountArray[2] = new Account(3, "MIN", 78000, 3.8);
		accountArray[3] = new Account(4, "NIM", 92000, 2.9);
		accountArray[4] = new Account(5, "OIM", 81000, 1.7);
		
		/*
		System.out.println(accountArray);
		System.out.println("\t" + accountArray[0]);
		System.out.println("\t" + accountArray[1]);
		System.out.println("\t" + accountArray[2]);
		System.out.println("\t" + accountArray[3]);
		System.out.println("\t" + accountArray[4]);
		*/
		
		Account.headerPrint();
		
		accountArray[0].print();
		accountArray[1].print();
		accountArray[2].print();
		accountArray[3].print();
		accountArray[4].print();
		// [] 안에 숫자가 있어서 for가능
		
		System.out.println("---------- for loop ----------");
		for (int i = 0; i < accountArray.length; i++) {
			accountArray[i].print();
		}
		
		
		
		
	}
}
