
public class ControlStopThreadMain {

	public static void main(String[] args) throws Exception{
		
		System.out.println("1. main");
		/*
		ControlStopThread1 cst1 = new ControlStopThread1();
		cst1.setName("download");
		cst1.start();
		
		Thread.sleep(1000);
		cst1.stop();
		*/
		
		/* 사용하지 말라는 메소드 (중간에 멈추는 메소드, 태생적으로 안전하지 않은 메소드임 -> 조건을 줘서 변경해라.)*/
		/* .stop(); --> The method stop() from the type Thread is deprecated  */
		
		ControlStopThread2 cst2 = new ControlStopThread2();
		cst2.start();
		
		Thread.sleep(5000);
		// cst2.stop();
		
		cst2.setPlay(false);
		
		System.out.println("9. main thread jvm return end");
		
	}

}
