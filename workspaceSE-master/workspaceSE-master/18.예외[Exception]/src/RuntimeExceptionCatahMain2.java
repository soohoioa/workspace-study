import javax.swing.JOptionPane;

public class RuntimeExceptionCatahMain2 {
 
	public static void main(String[] args) {
		try {
			System.out.println("stmt1");
			String str = "";
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
			
		} catch (NullPointerException e) {
			System.out.println("---catch start[NullPointerException]---");
			System.out.println("NullPointerException msg : " + e.getMessage());
			System.out.println("---catch end  [NullPointerException]---");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("---catch start[ArrayIndexOutOfBoundsException]---");
			System.out.println("ArrayIndexOutOfBoundsException msg " + e.getMessage());
			System.out.println("---catch end  [ArrayIndexOutOfBoundsException]---");
		}
		
		
		
	}

}
