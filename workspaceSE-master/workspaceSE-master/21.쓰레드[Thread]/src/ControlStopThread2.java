

public class ControlStopThread2 extends Thread{ // 무한쓰레드 
	private boolean isPlay;
	
	public ControlStopThread2() {
		isPlay = true;
	}
	
	
	
	public boolean isPlay() {
		return isPlay;
	}



	public void setPlay(boolean isPlay) {
		this.isPlay = isPlay;
	}



	@Override
	public void run() {
		
		while(isPlay) {
			try {
				System.out.println("-------");
				System.out.println("1. game move");
				Thread.sleep((int)(Math.random() * 1000) +1);
				
				System.out.println("2. game fight");
				Thread.sleep((int)(Math.random() * 1000) +1);
				
				System.out.println("3. game get score!");
				Thread.sleep((int)(Math.random() * 1000) +1);
				
				System.out.println("4. game power up!");
				Thread.sleep((int)(Math.random() * 1000) +1);
				
				System.out.println("5. game score update!");
				
			}catch (Exception e) {
				
			}
		}
		return;
		
	}
	
	
	
}
