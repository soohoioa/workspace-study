
public class SwitchTest {

	public static void main(String[] args) {

		int level = 3; // 게임 레벨 1 ~ 5 사이의 정수

		switch (level) {
		case 1: // 리터럴데이터 : 를 사용
			// 굳이 { } 사용하지 않음
			/* 명령문 기술 위치 */
			System.out.println("초보");
			System.out.println("초보");
			System.out.println("초보");
			System.out.println("초보");
			/* break --> switch block 을 빠져 나간다*/
			break;
		case 2:
			System.out.println("중수");
			break;
		case 3:
		case 4:
		case 5:
			System.out.println("고수[3, 4, 5]");
			break;
		default: // 일치하지 않으면 바로 default문 실행
			System.out.println("레빌은 1 ~ 5 사이의 정수입니다.");
		}

	}

}
