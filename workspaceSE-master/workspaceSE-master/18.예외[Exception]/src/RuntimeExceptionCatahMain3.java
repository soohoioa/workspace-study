import javax.swing.JOptionPane;

public class RuntimeExceptionCatahMain3 {
 
	public static void main(String[] args) {
		try {
			System.out.println("stmt1");
			String str = null;
			int length = str.length();
			/*
			 1. 예외상황발생하면  NullPointerException객체생성한후 
			    예외발생 코드를 가지고있는 메쏘드를(메인메쏘드) 호출한곳으로 던진다.(throw)
			 2. 던져진 예외객체는 catch block에 선언된 변수의 타입을 검사해서 타입에 일치하는 
			    변수에 대입된다.   
			 3. 현재실행흐름은 예외가발생한곳에서 catch block으로 실행흐름이이동한다.
			 */
			System.out.println("length : " + length);
			System.out.println("smtm2");
			int[] intArray=null;
			intArray=new int[3];
			intArray[3]=9999;
			/*
			 1. 예외상황발생하면  ArrayIndexOutOfBoundsException객체생성한후 
			    예외발생 코드를 가지고있는 메쏘드를(메인메쏘드) 호출한곳으로 던진다.(throw)
			 2. 던져진 예외객체는 catch block에 선언된 변수의 타입을검사해서 타입에일치하는 
			    변수에 대입된다.   
			 3. 현재실행흐름은 예외가발생한곳에서 catch block으로 실행흐름이이동한다.
			 */
			System.out.println("stmt3");
			
		} catch (Exception e) { //현재 발생하는 예외의 상위타입 기술
			JOptionPane.showMessageDialog(null, "고객님 죄송합니다. 빠른 시일내에 정상화 하겠습니다.");
			e.printStackTrace();
		}
		
		
		
	}

}
