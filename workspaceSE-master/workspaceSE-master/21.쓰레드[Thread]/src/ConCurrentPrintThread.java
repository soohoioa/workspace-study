
public class ConCurrentPrintThread extends Thread{
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("띵!");
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return;
	}
}