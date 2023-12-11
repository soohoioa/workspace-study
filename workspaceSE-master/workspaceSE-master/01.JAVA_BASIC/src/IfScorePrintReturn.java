
public class IfScorePrintReturn {

	public static void main(String[] args) {
		
		/*
		 * 점수 유효성 체크
		 */
		int kor = -90;
		if (!(kor >= 0 && kor <= 100)) { // 점수 반전
			// 유효하지 않은 점수
			System.out.println(kor + " 은 유효한 점수가 아닙니다.");
			return; // 리턴을 적으면 아래 if문을 실행하지 않고 다시 처음으로 돌아감
			// 만약 리턴이 여기 없고 마지막 문단에 있다면 끝까지 실행후 종료
		}

		/***** 유효한 점수 *****/
		/*
		 * 학점계산
		 */
		char hakjum = ' ';
		if (kor >= 90) {
			hakjum = 'A';
		} else if (kor >= 80) {
			hakjum = 'B';
		} else if (kor >= 70) {
			hakjum = 'C';
		} else if (kor >= 60) {
			hakjum = 'D';
		} else {
			hakjum = 'F';
		}
		System.out.println("학점은 " + hakjum + " 입니다.");
		// return 
	}

}
