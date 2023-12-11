package charstream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferedWriterReaderMain {

	public static void main(String[] args) throws Exception{
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("bufferedWriter.txt"));

		bw.write("첫번째줄\n");
		bw.write("두번째줄"); // 라인종결자 리드라인 읽을때 중요함
		bw.newLine();
		bw.write("세번째줄");
		bw.newLine();
		bw.write("네번째줄");
		bw.newLine();
		bw.write("다섯번째줄");
		bw.newLine();
		
		bw.flush(); 
		bw.close();
		
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
