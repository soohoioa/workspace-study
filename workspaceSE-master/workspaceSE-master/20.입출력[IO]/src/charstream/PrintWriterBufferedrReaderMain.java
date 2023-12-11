package charstream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class PrintWriterBufferedrReaderMain { // 최종_마지막_작업.. 이 작업은 좀 알았으면 좋겠다...

	public static void main(String[] args) throws Exception{
		PrintWriter pw = new PrintWriter(new FileWriter("printWriterBufferedReader.txt"));
		pw.println("첫번째줄");
		pw.println("두번째줄");
		pw.println("세번째줄");
		pw.println("네번째줄");
		pw.println("다섯번째줄");
		pw.println("여섯번째줄");
		pw.println("일곱번째줄");
		pw.println("여덟번째줄");
		
		pw.flush(); // close를 안하더라고 flush하면 출력된다. 
		pw.close(); // 닫는작업을 안하면 다 찰때까지 보내지 않으므로 닫아줘야함.
		
		System.out.println("PrintWriter.println() --> printWriterBufferedReader.txt");	
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("printWriterBufferedReader.txt"));
		
		
//		BufferedWriter bw = new BufferedWriter(new FileWriter("bufferedWriter.txt"));
//		bw.write("첫번째줄\n");
//		bw.write("두번째줄"); // 라인종결자 리드라인 읽을때 중요함
//		bw.newLine();
//		bw.write("세번째줄");
//		bw.newLine();
//		bw.write("네번째줄");
//		bw.newLine();
//		bw.write("다섯번째줄");
//		bw.newLine();
//		bw.flush(); 
//		bw.close();
		
		System.out.println("BufferedWriter.write(), BufferedWriter.newLine --> bufferedEriter.txt");
		
		BufferedReader br = new BufferedReader(new FileReader("bufferedWriter.txt"));
		/*
		 public String readLine()
                throws IOException
		 Reads a line of text. 
		 A line is considered to be terminated by any one of a line feed ('\n'), 
		 a carriage return ('\r'),
		 or a carriage return followed immediately by a linefeed(\r\n).
		 
		 Returns:
		 A String containing the contents of the line, 
		 not including any line-termination characters, 
		 or null if the end of the stream has been reached
		 
		 */
		
		String readLine = br.readLine();
		System.out.println("1. readLine : " + readLine);
		readLine = br.readLine();
		System.out.println("2. readLine : " + readLine);
		while (true) {
			readLine = br.readLine();
			if(readLine == null)break;
			System.out.print(readLine + "\n");
		}
		br.close();
		System.out.println("BufferedReader.readLine() <-- bufferedWriter.txt"); // 메소드 알아두면 좋겠다
		
		
	}

}
