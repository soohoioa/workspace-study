import javax.swing.JOptionPane;

public class RuntimeExceptionCatahMain1 {

	public static void main(String[] args) {
		 
		
		System.out.println("stmt1");
		String str = null;
		try {
			/*
			 * 예외발생 예상코드
			 */
			int length = str.length(); // length()뒤에 ()는 String에 있는 기본메소드여서 붙음
			/*
			 1. 예외상황발생하면  NullPointerException객체생성한후 
			    예외발생 코드를 가지고있는 메쏘드를(메인메쏘드) 호출한곳으로 던진다.(throw)
			 2. 던져진 예외객체는 catch block에 선언된 변수에 대입된다.   
			 3. 현재실행흐름은 예외가발생한곳에서 catch block으로 실행흐름이이동한다.
			 */
			System.out.println("length : " + length);
			
		} catch (NullPointerException exception) {
			System.out.println("---carch start[NullPointerException]---");
			String msg = exception.getMessage();
			System.out.println("NullPointerException ==> msg : " + msg);

			str = "홍길동";
			int length = str.length();
			System.out.println("length : " + length);
			System.out.println("---carch end  [NullPointerException]---");
		}
		
		System.out.println("smtm2");
		try {
			int[] intArray = null;
			intArray = new int[3];
			intArray[3] = 9999;
			/*
			 1. 예외상황발생하면  ArrayIndexOutOfBoundsException객체생성한후 
			    예외발생 코드를 가지고있는 메쏘드를(메인메쏘드) 호출한곳으로 던진다.(throw)
			 2. 던져진 예외객체는 catch block에 선언된 변수에 대입된다.   
			 3. 현재실행흐름은 예외가발생한곳에서 catch block으로 실행흐름이이동한다.
			 */
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("---catch start[ArrayIndexOutOfBoundsException]---");
			System.out.println("ArrayIndexOutOfBoundsException ==> msg : " + e.getMessage());
			JOptionPane.showMessageDialog(null, "호갱님 죄송합니다 프로그램을 종료합니다.");
			System.exit(0);
			
			System.out.println("---catch end  [ArrayIndexOutOfBoundsException]---");
		}
		System.out.println("stmt3");
		
		
		
		
	}

}
