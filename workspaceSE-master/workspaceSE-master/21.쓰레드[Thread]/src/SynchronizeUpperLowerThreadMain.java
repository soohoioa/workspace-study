
public class SynchronizeUpperLowerThreadMain {

	public static void main(String[] args) {
		
		SynchronizeLowerUpperPrintSharedObject sharedObject = new SynchronizeLowerUpperPrintSharedObject();
		
		SynchronizeUpperThread upperThread1 = new SynchronizeUpperThread(sharedObject); 
		SynchronizeUpperThread upperThread2 = new SynchronizeUpperThread(sharedObject); 
		//SynchronizeLowerThread lowerThread = new SynchronizeLowerThread(sharedObject);
		
		upperThread1.start();
		upperThread2.start();
		//lowerThread.start();
		// 쓰레드 객체 재사용불가. 다시 만들어야함.
		
	}

}
