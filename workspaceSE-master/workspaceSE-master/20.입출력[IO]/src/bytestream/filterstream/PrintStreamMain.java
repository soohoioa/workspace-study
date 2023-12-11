package bytestream.filterstream;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamMain {
	public static void main(String[] args) throws Exception {
		PrintStream pout=new PrintStream(new FileOutputStream("printStream.txt"));
		
		pout.println(1234);
		pout.println('김');
		pout.println(true);
		pout.println(3.141592);
		
		pout.println("1234");
		pout.println("김");
		pout.println("true");
		pout.println("3.141592");
		
		System.out.println("----------printStream.print()----------");
		
		
		
		
		
		
		
		/*
		의미 있는듯 없는듯 예제
		pout.print('A');
		pout.print("A");
		pout.print("B");
		pout.print(123);
		pout.print(true);
		pout.print("프린트 스트림");
		pout.println("한줄");
		pout.println("두줄");
		// 여기있는 형식 그대로 텍스트로 출력한다. 
		pout.println();
		
		***********************************************
		pout.println(1234);
		pout.write('1');
		pout.write('2');
		pout.write('3');
		pout.write('4');
		pout.write('\n');
		
		pout.println(true);
		pout.write('t');
		pout.write('r');
		pout.write('u');
		pout.write('e');
		pout.write('\n');
		*/
	
		
		
	}

}
