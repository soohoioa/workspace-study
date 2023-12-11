
public class ControlStopThread1 extends Thread{ // 유한쓰레드

	@Override
	public void run() {
		
		try {
			for (int i = 1; i <= 100; i++) {
				System.out.println("downloading... [" + i + "%]");
				Thread.sleep(100);
			}
			
		}catch (Exception e) {
			
		}
		System.out.println(Thread.currentThread().getName() + " Thread 가 jvm return thread end");
		return;

		
	}	
	
}
