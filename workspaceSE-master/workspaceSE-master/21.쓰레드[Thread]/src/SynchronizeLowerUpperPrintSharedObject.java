
public class SynchronizeLowerUpperPrintSharedObject {
	
	public synchronized void printLower() { 
		// 동기화블록 이라고도 함.
		System.out.print("a");
		System.out.print("b");
		System.out.print("c");
		System.out.print("d");
		System.out.print("e");
		System.out.print("f");
		System.out.print("g");
		System.out.print("h");
		System.out.print("i");
		System.out.print("j");
		System.out.print("k");
		System.out.print("l");
		System.out.print("m");
		System.out.print("n");
		System.out.print("o");
		System.out.print("p");
		System.out.print("q");
		System.out.print("r");
		System.out.print("s");
		System.out.print("t");
		System.out.print("u");
		System.out.print("v");
		System.out.print("w");
		System.out.print("x");
		System.out.print("y");
		System.out.print("z");
	} 
	// 모든 객체들은 열쇠를 가지고있음
	// 동기화설정을 많이 하면 할수록 느려짐. 블록설정가능 
	public synchronized void printUpper() {
		System.out.print("A");
		System.out.print("B");
		System.out.print("C");
		System.out.print("D");
		System.out.print("E");
		System.out.print("F");
		System.out.print("G");
		System.out.print("H");
		System.out.print("I");
		System.out.print("J");
		System.out.print("K");
		System.out.print("L");
		System.out.print("M");
		System.out.print("N");
		System.out.print("O");
		System.out.print("P");
		System.out.print("Q");
		System.out.print("R");
		System.out.print("S");
		System.out.print("T");
		System.out.print("U");
		System.out.print("V");
		System.out.print("W");
		System.out.print("X");
		System.out.print("Y");
		System.out.print("Z");
		
	}
	
	// 소문자,대문자를 찍기시작하면 끝까지 찍을때까지(메소드가 끝날때까지) 
	// 대부분 같은 일을 하는 작업 
	
}
