package nogeneric;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListMain {
 
	public static void main(String[] args) {
		
		// 배열에는 .length 가 있지만 ArrayList 에는 .length가 없어서 .size를 사용한다.
		
		Account acc1= new Account(1111, "BING", 33000, 0.3);
		Account acc2= new Account(2222, "KING", 12000, 1.1);
		Account acc3= new Account(3333, "KING", 89000, 5.6);
		Account acc4= new Account(4444, "HING", 45000, 4.8);
		Account acc5= new Account(5555, "PING", 99000, 2.9);
		
		ArrayList accountList = new ArrayList();
		int size = accountList.size();
		System.out.println("#size : " + size);
		// Object[] 을 갖고있다.
		
		System.out.println();
		System.out.println("------1. add[맨 마지막 index에 객체저장]-----");
		accountList.add(acc1);
		// add 부분 : Appends the specified element to the end of this list.
		// 지정된 요소를 이 목록의 끝에 추가합니다.
		System.out.println("#size : " + accountList.size());
		accountList.add(acc2);
		accountList.add(acc3);
		accountList.add(acc4);
		accountList.add(acc5);
		System.out.println("#size : " + accountList.size());
		System.out.println(accountList); // 재정의를 안했기에 주소값으로 표현. (class Account부분 131 - 134 까지 주석) 주석 풀어도 상관없음 알아서 해랴
		
		System.out.println();
		System.out.println("------2. add(index, element) [지정된 index에 객체저장]-----");
		accountList.add(1, new Account(1112, "!NEW", 30000, 3.3));
		// add 부분 : Inserts the specified element at the specified position in this list.
		// 이 목록의 지정된 위치에 지정된 요소를 삽입합니다.
		System.out.println("#size : " + accountList.size());
		System.out.println(accountList);
		
		System.out.println();
		System.out.println("------3. set(index, element) [지정된 index에 객체저장]-----");
		accountList.set(accountList.size() -1, new Account(9999, "NINE", 90000, 9.9));
		// set 부분 : Replaces the element at the specified position in this list with the specified element.
		// 이 목록의 지정된 위치에 있는 요소를 지정된 요소로 바꿉니다.
		System.out.println("#size : " + accountList.size());
		System.out.println(accountList); // 보기 어려워서 번호로만 보이게 만듬. (class Account부분 137 - 140 까지)
		
		System.out.println();
		System.out.println("------4. get(index, element) [지정된 index에 객체참조변수 반환]-----");
		Object  getAccount = (Account)accountList.get(accountList.size()-1);
		// get 부분 : Returns the element at the specified position in this list.
		// 이 목록의 지정된 위치에 있는 요소를 반환합니다.
		System.out.println(getAccount);
		// Object : 최상위클래스. Object 자식
		
		System.out.println();
		System.out.println("------5. remove(index) [지정된 index에 객체삭제]-----");
		Account removeAccount = (Account)accountList.remove(accountList.size()-1);
		// remove 부분 : Removes the element at the specified position in this list. Shifts any subsequent elements to the left (subtracts one from their indices).
		// 이 목록의 지정된 위치에 있는 요소를 제거합니다. 후속 요소를 왼쪽으로 이동합니다(인덱스에서 1을 뺍니다).
		System.out.println(removeAccount);
		System.out.println("#size : " + accountList.size());
		System.out.println(accountList); // 대부분 삭제해도 삭제한 주소값 반환해줌
		
		
		System.out.println();
		System.out.println();
		System.out.println("--- 업무실행---");
		System.out.println("***** 1. 계좌 전체 출력 ***************************");
		Account.headerPrint();
		for(int i = 0; i < accountList.size(); i++) {
			Object account=accountList.get(i);
			Account tempAccount = (Account)accountList.get(i);
			tempAccount.print();
		}
		/*
		밑에 6번과 다른 이유는 1번은 Object로 받아서 다운 캐스팅한거고 (풀어씀)
		6번은 accountList.get(i);으로 바로 받아서 다운캐스팅함.
		*/
		Account.headerPrint();
		for (Object account:accountList) {
			Account acc = (Account)account;
			acc.print();
		}
		
		System.out.println();
		System.out.println("***** 2. 계좌번호 3333번 한개 찾기 ****************");
		for (int i = 0; i < accountList.size(); i++) {
			Account tempAccount = (Account)accountList.get(i);
			if(tempAccount.getNo() == 3333) {
				tempAccount.print();
				break;
			}
		}
		
		System.out.println();
		System.out.println("***** 3. 계좌 주 이름 KING인 계좌 여러개 찾기 *****");
		for (int i = 0; i < accountList.size(); i++) {
			Account tempAccount = (Account)accountList.get(i);
			if(tempAccount.getOwner().equals("KING")) {
				tempAccount.print();
			}
		}
		
		System.out.println();
		System.out.println("***** 4. 계좌번호 4444번 계좌 한개 삭제 ************");
		for (int i = 0; i < accountList.size(); i++) {
			Account tempAccount = (Account)accountList.get(i); // 한개찾는것은 이런부분에서는 불편함
			if(tempAccount.getNo() == 4444) {
				System.out.println(">> 삭제 전 size : " + accountList.size());
				Account removeAcc = (Account)accountList.remove(i);
				removeAcc.print();
				System.out.println(">> 삭제 후 size : " + accountList.size());
				break;
			}
		}
		
		
		System.out.println();
		System.out.println("***** 5. 계좌 주 이름 KING인 계좌 여러개 삭제 *****");
		// 연속적으로 삭제는 주의해서 삭제해야한다. 연속적 삭제시 한번더 검사해줘야하니 인덱스를 재정의해줘야함
		for (int i = 0; i < accountList.size(); i++) {
			if(((Account)accountList.get(i)).getOwner().equals("KING")) {
				Account rAccount = (Account)accountList.remove(i);
				rAccount.print(); //연속적으로 삭제가 안되므로 인덱스를 한번 더 돌려야함
				i--; // 한번 더 돌리는 방법 
			}
		}
		
		
		System.out.println();
		System.out.println("***** 6. 계좌 전체 출력 ***************************");
		Account.headerPrint();
		for(int i = 0; i < accountList.size(); i++) {
			Account tempAccount = (Account)accountList.get(i);
			tempAccount.print();
		}
		
		
		/**********************전체출력[iteration]**************************/
		System.out.println("*****전체출력[iteration]*****");
		Iterator accountIterator =  accountList.iterator(); // 반복자(iterator)를 나에게 달라
		System.out.println(accountIterator); // 인덱스를 사용하지 않음
		
		while(accountIterator.hasNext() ) {
			Account tempAccount = (Account)accountIterator.next();
			tempAccount.print();
		}
		
		accountIterator.next();
		/*
		 Iterator의 장점 : 
		 Iterator는 자바 컬렉션 프레임워크에서 (List, Set, Map, Queue 등) 값을 가져오거나 삭제할 때 공통으로 사용 가능
		 Iterator<데이터타입> iterator명 = 컬렉션.iterator(); 이렇게 정의하고

		-------------------------------------------------------------------------------------------------------
		 while(iterator명.hasNext()) {

			iterator.next();

		} 
		
		이런 방식으로 주로 사용하게 된다
		 
		------------------------------------------------------------------------------------------------------
		 Iterator 관련 메소드 
		 - hasNext()
			→ 다음 요소가 존재하는지 혹은 그렇지 않은지 true/false로 리턴한다. 
			true 이면 다음 요소다 있다는 것이고, false 이면 현재 요소가 마지막이라는 뜻이다.
		 -  next()
		    → 다음 요소를 가져온다.
		 - remove()
		    → next()로 호출된 요소를 제거한다.
		    
		  Iterator에서 내부적으로 호출하는 메서드의 순서가 ① hasNext() → ② next() → ③ remove() 이기 때문

		 
		 */
		
	}

}
