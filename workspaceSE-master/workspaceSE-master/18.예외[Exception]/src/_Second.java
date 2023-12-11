import java.io.IOException;
import java.net.Socket;

public class _Second {
	public void method2() throws NullPointerException,IOException{
		System.out.println("\t \t Second.method2()실행");
		/***********case1(RuntimeException)***********
		 * 1.JVM 예외상황을 감지하고 예외객체(NullPointerException)생성
		 * 2.JVM은 생성한예외객체를 반환방향으로 던진다.(throw) -> 이 객체가 vm까지 가서 셧다운됨
		 * 3.실행중인쓰레드는 실행을멈추고 호출한곳(반환방향)으로 이동한다. 
		 * 4.JVM은 던져진예외객체의 메세지를 출력한후 쓰레드종료(shut down)
		
			String str = null;
			int length = str.length();
			System.out.println(length); 
			-> 예외가 발생한 지점에서부터 반환이 안되고 셧다운됨 (반환과 방향이 똑같지만 반환은 아님!)
		*/ 
		
		
		/***********case2(RuntimeException)***********
		 * 1.내가예외객체생성
		 * 2.내가 예외객체를 던진다.
		 * 3.실행중인쓰레드는 실행을멈추고 호출한곳(반환방향)으로 이동한다. 
		 * 4.JVM은 던져진예외객체의 메세지를 출력한후 쓰레드종료(shut down)
			boolean isExceptionRaised = true;
			if(isExceptionRaised) {
				NullPointerException exception = new NullPointerException("내가 생성한 예외 객체");
				throw exception;
			} 
			-> 당연히 리턴방향으로 이동하지만 리턴안됨
		 */
		
		/***********case3(비 RuntimeException)***********/
		Socket socket = new Socket("www.naver.com", 80);
		// Unhandled exception type IOException -> 처리되지 않은 예외 유형 IOException
		// IOException이 발생할수 있으므로 메소드에 선언해줘야함
		System.out.println(socket);
		
		
		System.out.println("\t \t Second.method2()반환");
		return;
	}
}
