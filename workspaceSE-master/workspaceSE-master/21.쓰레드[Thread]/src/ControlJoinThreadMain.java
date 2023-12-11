
public class ControlJoinThreadMain {

	public static void main(String[] args) throws Exception{
		System.out.println("1. main Thread start");
		
		ConCurrentBeepThread bt = new ConCurrentBeepThread();
		ConCurrentPrintThread pt = new ConCurrentPrintThread();
		
		bt.start();
		/*
		 * bt.join() 메소드를 호출한 메인쓰레드를 bt쓰레드가 종료될때까지 중지시킨다.
		 */
		bt.join();
		System.out.println("2. main Thread");
		pt.start();
		pt.join();
		System.out.println("3. main Thread");
		
		System.out.println("9. main Thread jvm return");

	}

}
