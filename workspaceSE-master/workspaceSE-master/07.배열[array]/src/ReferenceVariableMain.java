
public class ReferenceVariableMain {

	public static void main(String[] args) {
		
		System.out.println("------------ Reference Variable Assign-----------");
		Account account1 = new Account(2351, "김아론", 90000, 3.6);
		Account account2 = account1; // account2 와 account1 은 서로 같은 주소지를 갖고있다
		Account account3 = new Account(8989, "김경호", 89000, 5.6);
		// 객체를 바꾸는건 주소를 바꾸는것
		// 번지는 참조변수의 의미
		
		System.out.println("account1주소 : "+ account1);
		System.out.println("account2주소 : "+ account2);
		
		account1.print();
		account2.print(); // 1, 2 같은주소값을 가짐
		
		account1.setOwner("김야론");
		account1.print();
		account2.print();
		
		
		System.out.println("----- Reference Variable Compare (== , != 만가능) -----"); // 참조변수비교
		if(account1 == account2) { 
			System.out.println("주소값이 동일하다. -->" + account1 + " == " + account2);
		}
		if(account1 != account3) {
			System.out.println("주소값이 동일하지 않는다. -->" + account1 + " != " + account3);
		}
		
		
		System.out.println("----- Reference Variable Swap[주소교환] -----"); // 객체교환 -> 객체 주소값을 교환한다
		Account a1 = new Account(1000, "일천님", 30000, 3.0);
		Account a2 = new Account(2000, "이천님", 80000, 2.0);
		System.out.println("---swap 전---");
		a1.print();
		a2.print();
		
		//교환할려면 임시변수가 필요하다. 여기서 tempAccount는 임시변수
		Account tempAccount = a2;
		a2 = a1;
		a1 = tempAccount;
		
		System.out.println("---swap 후---");
		a1.print();
		a2.print();
		// 주소를 안바꾸고도 가능함 -> 안에 있는 내용을 따로 변수선언후 모두 바꿔야함 -> 멤버가 많을수록 번거로움
		// -> 차라리 주소를 바꾸는게 낫다
		
		
		System.out.println("----- Reference Variable null value -----"); // 참조형변수의 null
		/*
		 * 객체의 경우 초기값이 null 들어간다. 타입없음. 주소값을 가지지 않기 떄문에 이걸로 메소드호출 불가능
		 * null : 객체 주소 리터럴 값 
		 * - 객체주소 초기화의 용도로 사용
		 * - 참조변수의 기본값이기도 하다
		 * - null 주소 사용시 NullPointerException 이 발생
		 */
		Account a = null;
		if( a == null) {
			a = new Account(9090, "구공이", 565678, 1.3624);
		}
		a.print();
		
		
	}

}
