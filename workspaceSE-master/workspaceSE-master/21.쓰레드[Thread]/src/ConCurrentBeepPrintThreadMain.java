
public class ConCurrentBeepPrintThreadMain {

	public static void main(String[] args) {
		System.out.println("1. main thread start");
		
		System.out.println("2. main thread ConCurrentBeepThread, ConCurrentPrintThread 객체생성");
		ConCurrentBeepThread beepThread = new ConCurrentBeepThread();
		ConCurrentPrintThread printThread = new ConCurrentPrintThread();
		
		System.out.println("3. main thread ConCurrentBeepThread.start(), ConCurrentPrintThread.start() 메소드 호출");
		
		beepThread.start();
		printThread.start();
		
		System.out.println("9. main thread end jvm return");
		
		return;

	}

}
