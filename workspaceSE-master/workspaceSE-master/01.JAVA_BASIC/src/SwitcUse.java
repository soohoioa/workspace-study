
public class SwitcUse {

	public static void main(String[] args) {
		
		/*
		 * 짝수, 홀수 판별
		 */
		int num = 25;
		
		switch (num % 2) {
		case 0:
			System.out.println("짝수");
			break;
		case 1:
			System.out.println("홀수");
			break;
		}
		/*
		 *  1 ~ 6 사이의 정수발생
		 */
		
		int diceNo = (int)(Math.random() * 6) + 1;
		switch (diceNo) {
		case 1:
			System.out.println("dice number: " + diceNo);
			break;
		case 2:
			System.out.println("dice number: " + diceNo);
			break;
		case 3:
			System.out.println("dice number: " + diceNo);
			break;
		case 4:
			System.out.println("dice number: " + diceNo);
			break;
		case 5:
			System.out.println("dice number: " + diceNo);
			break;
		case 6:
			System.out.println("dice number: " + diceNo);
			break;
		}
		
		/*
		 * 입력되는 키보드 문자열에 따라 게임 캐릭터 이동
		 */
		
		
		/*
		 * Quiz : 대소문자 구분없이 실행되도록 해보시오
		 */
		char direction = 's';
		
		switch (direction) {
		case 'A':
		case 'a':
			System.out.println("move left~");
			break;
		case 'W':
		case 'w':
			System.out.println("move up~");	
			break;
		case 'D':
		case 'd':
			System.out.println("move right~");	
			break;
		case 'X':
		case 'x':
			System.out.println("move downt~");		
			break;
		case 'S':
		case 's':
			System.out.println("move rotate~");			
			break;
		default:
			System.out.println("don`t move");
		}
	
		
	}

}
