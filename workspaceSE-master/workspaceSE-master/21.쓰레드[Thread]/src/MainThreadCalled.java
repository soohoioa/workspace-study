
public class MainThreadCalled {
	public void main_thread_called_method1() {
		System.out.println("\tA." + Thread.currentThread() + "쓰레드 실행");
		System.out.println("\tB." + Thread.currentThread() + "쓰레드 반환");
		return;
	}
	
	public void main_thread_called_method2() {
		System.out.println("\t가." + Thread.currentThread() + "쓰레드 실행");
		System.out.println("\t나." + Thread.currentThread() + "쓰레드 반환");
		return;
	}
	
}
