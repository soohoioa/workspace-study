
public class IfTest2 {

	public static void main(String[] args) {
		int x = 21;
		int y = 30;
		
		if(x > y) {
			System.out.println("x > y --> true");
		} else {
			System.out.println("x > y --> false");
			
		}
		
		if (x < y) {
			System.out.println("x < y --> true");
		} else {
			System.out.println("x < y --> false");

		}
		
		if (x == y) {
			System.out.println("x == y --> true");
		}

		if (x != y) {
			System.out.println("x != y --> true");
		}
		System.out.println("---변수의 범위(scope)----");
		
		int kor = 30;
		
		if (kor >= 90) {
			char grade = 'A';
			String msg = "참 잘했어요";
			System.out.println("kor   --> " + kor);
			System.out.println("grade --> " + grade);
			System.out.println("msg   --> " + msg);
		}
		System.out.println("kor   --> " + kor); // grade 와 msg 는 블록 밖에서 서용불가
		// 블록 내에서 선언된 변수는 밖에서 사용불가, 사용하고 싶다면 변수를 밖으로 꺼내면 됨
		/*
		System.out.println("grade --> " + grade);
		System.out.println("msg   --> " + msg);
		*/

	}

}
