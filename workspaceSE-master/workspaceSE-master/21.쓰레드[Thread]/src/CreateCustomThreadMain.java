/*
 	type A:
	1. Thread 클래스를 상속받는다.
	2. Thread class의 run method를 overriding 한다.
		동사원형:public void run()
	3. Thread 객체를 생성한다.
	4. Thread 객체를통해서 Thread를 시작시킨다.
	
 */
public class CreateCustomThreadMain {

	public static void main(String[] args) {
		
		System.out.println("1. main thread start");
		CreateCustomThread cct = new CreateCustomThread();
		cct.setName("사용자 정의 쓰레드");
		
		System.out.println("2. main thread CreateCustomThread객체.start()메소드 호출전");
		
		cct.start(); // 메인스레드가 실행
		/*
		 <<Thread>> 자바 API 참고 (java.lang -> Thread)
		 
		 public void start()
			- Causes this thread to begin execution; 
				the Java Virtual Machine calls the run method of this thread.
			- The result is that two threads are running concurrently: 
				the current thread (which returns from the call to the start method) 
				and the other thread (which executes its run method).
			
			- 이 스레드가 실행을 시작하도록 합니다.
				JVM(Java Virtual Machine)은 이 스레드의 실행 메소드를 호출합니다.
			- 그 결과 두 개의 스레드가 동시에 실행됩니다.
				현재 스레드(start 메서드 호출에서 반환) 및 다른 스레드(run 메서드를 실행).
		 */
		System.out.println("3. main thread CreateCustomThread객체.start()메소드 호출후");
		
		while(true) {
			System.out.println("4. main thread");
		}
	}

}
