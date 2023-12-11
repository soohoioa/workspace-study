
public class WhileUse {

	public static void main(String[] args) {
		
		System.out.println("--------i = 0 --------");
		int i = 0; // 반복 횟수 변수 (0으로 초기화)
		// 초기값은 0부터 시작 , 1 은 아주 드물게 있음
		while (i < 10) { // i 는 10 보다 적은 동안 반복하겠다
			System.out.println("smtm1 : i = " + i);
			i++;
		}
		
		System.out.println("--------i = 1 --------");
		i = 1;
		while (i <= 10) { // i 가 10 보다 적가나 같은 동안
			System.out.println("stmt : i = " + i);
			i++;
		}
		
		System.out.println(" >> 1 ~ 10 사이의 정수 출력 (10회)");
		i = 0;
		while (i < 10) {
			System.out.print((i + 1) + " ");
			i++;
		}
		
		System.out.println(); // 라인 종결자
		System.out.print("\n"); // 라인 종결자 
		// 둘중 아무거나 쓰시오
		
		i = 1;
		while (i <= 10) {
			System.out.print(i + " ");
			i++;
		}
		
		System.out.println();
		System.out.println(" >> 1 ~ 10 [홀수]");
		i = 1;
		while (i <= 10) {
			if (i % 2 == 1) {
			System.out.print(i + " ");
		}
			i++;
		}
		
		System.out.println();
		System.out.println(" >> 1 ~ 100 [4의 배수]");
		i = 1;
		while (i <= 100) {
			if (i % 4 == 0) {
				System.out.print(i + " ");
			}
			i++;
		}
		
		System.out.println();
		System.out.println(" 1900년에서 2023년까지 윤년을 출력하세요.");
		int year = 1900;
		while (year <= 2023) {
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				System.out.print(year + "\t" );
			}
			year++;
		}
		
		System.out.println();
		System.out.println(">> 1 ~ 100 사이의 정수합 [누적]");
		int tot = 0; // 누적 합을 가질 변수 선언
		int oddTot = 0; // 홀수 합
		int evenTot = 0; // 짝수 합
		i = 1;
		while (i <= 100) {
			// tot = tot + i;
			tot +=i; // 연산 후 대입 연산자 
			if (i % 2 == 0) {
				evenTot += i;
			} else {
				oddTot += i;
			}
			i++;
		}
		System.out.println(">> 1 ~ 100 사이의 정수합 : " + tot);
		System.out.println(">> 1 ~ 100 사이의 짝수합 : " + evenTot);
		System.out.println(">> 1 ~ 100 사이의 혹수합 : " + oddTot);
		
		
		
		
		
		
		
		
		
		
		
	}

}
