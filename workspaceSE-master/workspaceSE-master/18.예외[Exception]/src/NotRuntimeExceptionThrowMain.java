import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class NotRuntimeExceptionThrowMain {
 
	public static void main(String[] args) throws Exception /* throws UnknownHostException, IOException, ClassNotFoundException*/ {
		
		System.out.println("stmt1");
		/*
		 * 예외 발생 예상 코드(IOException)
		 */
		Socket socket = new Socket("www.daum.net",80);
		// Unhandled exception type IOException -> 처리되지 않은 예외 유형 IOException
		System.out.println(socket);
		System.out.println("stmt2");
		/*
		 * 예외 발생 예상 코드(ClassNotFoundException)
		 */
		Class.forName("AClass"); // 문자열은 의존성이 확 줄어듬 나중에 볼 내용
		
		/*
		 * 예외 발생 예상 코드(ArithmaticException[RuntimeException]) 
		 * -> 섞여있을꺼라 예상하고 RuntimeException으로 하나 더 작성해봄
		 */
		int resule = 3/0;
		
		System.out.println("stmt3");

	}

}
