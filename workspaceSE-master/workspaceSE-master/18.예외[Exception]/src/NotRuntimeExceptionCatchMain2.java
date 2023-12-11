import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class NotRuntimeExceptionCatchMain2 {
 
	public static void main(String[] args) {
		try {
			System.out.println("stmt1");
			/*
			 예외 발생 예상 코드(IOException)
			  	1.예외발생시 IOException객체생성 
			    	IOException객체가 던져짐
			  	2.catch블록에서 던져진객체를 잡음(catch 블록에선언된변수에 IOException객체대입)  
			  	3.현재실행흐름이 예외발생코드에서 정지된후 catch블록을실행
			 */
			
			Socket socket = new Socket("www.daum.net",80);
			// Unhandled exception type IOException -> 처리되지 않은 예외 유형 IOException
			System.out.println(socket);
			System.out.println("stmt2");
			/*
			 예외 발생 예상 코드(ClassNotFoundException)
			 	1.예외발생시 ClassNotFoundException객체생성 
			    	ClassNotFoundException객체가 던져짐
			  	2.catch블록에서 던져진객체를 잡음(catch 블록에선언된변수에 ClassNotFoundException객체대입)  
			  	3.현재실행흐름이 예외발생코드에서 정지된후 catch블록을실행
			 */
			Class.forName("AClass"); // 문자열은 의존성이 확 높아짐. 나중에 확인할예정 지금은 생략
			
			/*
			 예외 발생 예상 코드(ArithmaticException[RuntimeException]) 
			 -> 섞여있을꺼라 예상하고 RuntimeException으로 하나 더 작성해봄
			  	1.예외발생시 ArithmeticException객체생성 
			    	ArithmeticException객체가 던져짐
			  	2.catch블록에서 던져진객체를 잡음(catch 블록에선언된변수에 ArithmeticException객체대입)  
			  	3.현재실행흐름이 예외발생코드에서 정지된후 catch블록을실행
			 */
			int resule = 3/0;
			
			System.out.println("stmt3");
		} catch (Exception e) { // 잘 모르는 모든 예외들을 다 걸러줌
			System.err.println("catch Exception msg : " + e.getMessage());
			JOptionPane.showConfirmDialog(null,"애로사항발생 : " + e.getMessage());
		}
		
		/*
		상위타입을 먼저 선언했다면 안된다. 자식부터 부모순으로 작성해야 한다.
		점점 좁은 타입에서 넓은 타입으로 해야 잡을수있다. 처음부터 넓은타입하면 안된다요
		Exception   -> IOException (X)
		IOException -> Exception (O)
		*/
		
		
		
	}

}
