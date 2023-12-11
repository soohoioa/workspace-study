package charstream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileWriterReaderMain {

	public static void main(String[] args) throws Exception {
		FileWriter fw = new FileWriter("fileWriter.txt");
		
		fw.write(44356);
		fw.write('A');
		fw.write('김');
		
		for(int i = 0; i< 65536; i++) {
			fw.write(i);
			if(i % 100 == 0) {
				fw.write('\n');
			}
		}
		fw.write("\n");
		fw.write("문자열을 마음대로 사용합니다. !!!!");
		fw.write("\n");
		fw.write("한 라인\n");
		fw.write("두 라인\n");
		fw.write("세 라인\n"); 
		fw.write("네 라인\n"); 
		// 텍스트만 가능. 읽을때 라인 단위로 읽음

		
		/*
		 * 다 채워지지않은 버퍼에 있는 데이터를 출력스트림에 쓴다.
		 */
		fw.flush();
		fw.close();
		System.out.println("FileWriter.write() --> fileWrite.txt");
		
		FileReader fr = new FileReader("fileWriter.txt");
		
		/*
		 public int read()
         		throws IOException
		Reads a single character. 
		This method will block until a character is available, an I/O error occurs, or the end of the stream is reached.
		Subclasses that intend to support efficient single-character input should override this method.

		Returns:
		The character read, as an integer in the range 0 to 65535 (0x00-0xffff), 
		or -1 if the end of the stream has been reached
		 
		 */
		
		
		int charCount = 0;
		int readChar = fr.read();
		charCount++;
		System.out.println("1. readChar : " + (char)readChar);
		readChar = fr.read();
		charCount++;
		System.out.println("2. readChar : " + (char)readChar);
		readChar = fr.read();
		charCount++;
		System.out.println("3. readChar : " + (char)readChar);
		
		while(true) {
			readChar = fr.read();
			if(readChar == -1) break;
			charCount++;
			System.out.print((char)readChar);
		}
		
		
		System.out.println();
		System.out.println(charCount + " 문자 읽음");
		
		// 특정글자제외, 한 라인(라인종결자 나오면) 리드라인작업에서 많이 사용됨
		
		
		
		
		
		
		
		
	}

}
