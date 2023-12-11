import java.util.Date;

public class ControlSleepThread extends Thread{
	private boolean isPlay;
	
	public ControlSleepThread() {
		isPlay = true;
	}
	
	@Override
	public void run() {
		
		while(isPlay) {
			try {
				// System.out.println(Thread.currentThread().getName() +  " --> 1초마다 한번씩 시간출력");
		
				Date now =new Date();
				System.out.println(now.toLocaleString());
				/* .toLocaleString() The method toLocaleString() from the type Date is deprecated  */
				Thread.sleep(1000);
				/*
				 public static void sleep(long millis)
                  		throws InterruptedException
				
				Causes the currently executing thread to sleep (temporarily cease execution) for the specified number of milliseconds, 
				subject to the precision and accuracy of system timers and schedulers. 
				The thread does not lose ownership of any monitors.
				 
				 */
				
				
				
				/*
				 * 현재 실행되고 있는 쓰레드를 1000ms동안 실행중지
				 */
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		return;
	}
}
