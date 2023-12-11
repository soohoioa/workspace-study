
public class IfNested {

	public static void main(String[] args) {
		/*
		 * 평점계산 (A, B, C, D, F) if문 안에 if문
		 */

		int kor = 85;
		char hakjum = 'F';
		System.out.println(" ------------ nested if ------------ ");
		if (kor >= 90 && kor <= 100) {
			// A 학점
			hakjum = 'A';
		} else {
			if (kor >= 80 && kor < 90) {
				// B, C, D, F
				hakjum = 'B';
			} else {
				// C, D, F
				if (kor >= 70 && kor < 80) {
					// C, D, F
					hakjum = 'C';
				} else {
					// D, F
					if (kor >= 60 && kor < 70) {
						hakjum = 'D';
					} else {
						hakjum = 'F';
					}
				}
			}
		}
		System.out.printf("1. 학점은 %c 입니다.\n", hakjum);
		
		
		System.out.println(" ------------ else if ------------ ");
		hakjum = 'A';
		if (kor >= 90 && kor <= 100) {
			hakjum = 'A';
		} else if (kor >= 80 && kor < 90) {
			hakjum = 'B';
		} else if (kor >= 70 && kor < 80) {
			hakjum = 'C';
		} else if (kor >= 60 && kor < 70) {
			hakjum = 'D';
		} else {
			hakjum = 'F';
		}
		System.out.printf("2. 학점은 %c 입니다.\n", hakjum);
		
		

	}

}
