package charstream;

import java.io.FileReader;
import java.io.FileWriter;

public class FileWriterReaderCopyMain {

	public static void main(String[] args) throws Exception{
		
		FileReader fr =new FileReader("데미안.txt");
		FileWriter fw = new FileWriter("데미안[복사].txt"); 
		
		int lineCount = 0;
		
		while(true) {
			int readChar = fr.read();
			if(readChar == -1)break;
			// System.out.print((char)readChar);
			if(readChar == '.') {
				fw.write(readChar);
				fw.write("\n");
			} else if(readChar == '-') {
				fw.write(readChar);
				fw.write(" page");
			} else if(readChar == '\n'){
				lineCount++;
				fw.write(readChar);
			} else {
				fw.write(readChar);
				
			}
			
		}
		
		fw.flush();
		fw.close();
		fr.close();
		System.out.println("----------FileWriterReaderCopy [" + lineCount + "] ----------");
		
	}

}
