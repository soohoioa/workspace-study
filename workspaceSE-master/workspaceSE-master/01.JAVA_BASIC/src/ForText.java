	/*
		for문
	     	-형식:
	       	       
	       	for(1;2;3){
		       	//1.반복변수(선언,초기화가능)
		       	//2.반복변수의 조건검사(논리형데이타)
		       	//3.반복변수증,감(++,--)
	       	}
	       
	       ex>
	       	for(int i=0;i<10;i++){
	       	 	stmt1;
	       }
	       
	       ex>무한루프
	       for(;;){
	       	
	       }
	*/


public class ForText {

	public static void main(String[] args) {
		System.out.println("---------while---------");
		int k = 0; 		 // 1. 반복변수 초기화
		while (k < 10) { // 2. 반복변수 비교 (반복조건) 
			System.out.println("k = " + k); // 3. 반복문 실행
			k++;		// 4. 반복변수 증가 (감소) 
		}
		
		System.out.println("---------for i 증가---------");
		for (int i = 0; i < 10; i++) { // 증감연산자 --> 실행문 다음으로 고정
			System.out.println("i = " + i);
		}  // i = 반복을 하기 위한 변수이기에 안에서만 사용
		// i는 안에서 선언되었기에 조건을 만족하고 false 가 실행되면 밖으로 나오면서 사라짐

		System.out.println("---------for i 감소---------");
		for (int i = 10; i > 0; i--) { // 감소연산자 --> 큰수에서 부터 작아짐
			System.out.println("i = " + i); // 감소 -> 비교 -> 실행 
		}
		
		System.out.println(">> 홀수만 출력 [1 ~ 100]");
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 1) {
				System.out.print(i + " ");
			}
		}
		
		System.out.println();
		System.out.println(">> 4의 배수 출력 [1 ~ 100");
		
		for (int i = 1; i <= 100; i++) {
			if (i % 4 == 0) {
				System.out.print(i + " ");
			}
		}
		
		System.out.println();
		System.out.println(">> 3 과 4 의 공통배수 [1 ~ 100]");
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 && i % 4 == 0) {
				System.out.print(i + " ");
			}
		}
		
		System.out.println();
		System.out.println(">> 3 과 4 의 최소공배수 [break문]");
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0 && i % 4 == 0) {
				System.out.print(i + " ");
				break;
				/*
				 break문
				 	1. 반복문에서 사용한다. -> if문에서는 사용안된다.
				 	2. break문 이후의 for 블록코드를 실행하지 않는다.
				 	3. 다음 반복 코드블록도 실행하지 않는다. (반복블록을 빠져나온다)
				 */
			} // end if 
		} // end for loop 
		
		System.out.println();
		System.out.println(">> 4의 배수가 아닌 수 출력 [continue]");
		for (int i = 1; i <= 100; i++) {
			if (i % 4 == 0) {
				/*
				 4 의 배수 조건을 만족하면 continue문이 실행되고
				 현재 실행중인 for블록의 continue문 이후 코드를 실행하지 않고
				 다음횟수의 블록을 실행한다.
				 */
				continue;
				/*
				 0. 반복 블록에서만 사용가능하다.
				 1. continue문 이후의 for 블록 코드를 실행하지 않는다.
				 2. 다음반복을 계속 실행한다 (continue) 
				 */
			}
			System.out.print(i + " ");
		}
		
		System.out.println();
		System.out.println(">> 홀수 짝수 합 [1 ~ 100]");
		
		int oddTot = 0;
		int evenTot = 0;
		for(int i=1; i <= 100; i++) {
			if(i % 2 == 0)
				//짝수누적
				evenTot += i;
			else
				//홀수누적
				oddTot += i;
		}
		System.out.println("짝수합 : "+ evenTot);
		System.out.println("홀수합 : "+ oddTot);
		
		System.out.println();
		System.out.println("------ 문자 출력 ------");
		for (char c = 'a'; c <= 'z'; c++) {
			System.out.print(c);
			if (c == 'z') {
				continue;
			}
			System.out.print(",");
		}
		System.out.println();
	}

}
