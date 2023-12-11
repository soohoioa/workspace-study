
public class ControlSleepThreadMain {

	public static void main(String[] args) throws Exception {
		System.out.println("1. main");
		System.out.println("2. main thread 3초간 sleep");
		/*
		 * 현재코드 Thread.sleep(3000);을 실행하는 쓰레드를 3000ms동안 실행을 중지
		 */
		Thread.sleep(3000);
		System.out.println("3. main thread 3초간 sleep후 깨어난 후 실행");
		
		ControlSleepThread cst = new ControlSleepThread();
		cst.setName("clock thread");
		cst.start();
		
		System.out.println("9. main jvm return");
		
		

	}

}
