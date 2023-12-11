
public class AccountManyNenber {

	public static void main(String[] args) {
		AccountManyMrmber accountManyMrmber = new AccountManyMrmber();
		
		accountManyMrmber.acc0 = new Account(1, "KIM", 30000, 0.3);
		accountManyMrmber.acc1 = new Account(2, "LEE", 45000, 4.2);
		accountManyMrmber.acc2 = new Account(3, "MIN", 78000, 3.8);
		accountManyMrmber.acc3 = new Account(4, "NIM", 92000, 2.9);
		accountManyMrmber.acc4 = new Account(5, "OIM", 81000, 1.7);
		
		accountManyMrmber.length = 5; // -> 작업안됨 그냥 해봄
		
		Account.headerPrint(); //static작업가능
		// 자기자신으로 기반한 작업 안하므로 , 메소드 선언 정적선언으로
		// Account 클래스에서 계좌헤더출력에 static 추가
		
		
		accountManyMrmber.acc0.print();
		accountManyMrmber.acc1.print();
		accountManyMrmber.acc2.print();
		accountManyMrmber.acc3.print();
		accountManyMrmber.acc4.print();
		// for문사용 불가 
		// . . 도트2개는 의존성이 높아짐
		
		
	}

}
