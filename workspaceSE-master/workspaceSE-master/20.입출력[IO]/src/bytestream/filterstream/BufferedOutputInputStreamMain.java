package bytestream.filterstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferedOutputInputStreamMain {

	public static void main(String[] args) throws Exception{
		/*******************BufferedOutputStream***********************/
		FileOutputStream fis = new FileOutputStream("bufferedOut.dat");
		BufferedOutputStream bos = new BufferedOutputStream(fis);
		
		bos.write(0);
		bos.write(1);
		bos.write(2);
		bos.write(3);
		bos.write(4);
		bos.write(2147483647);	
		for(int i = 0; i < 256; i++) {
			bos.write(i);
		}
		bos.close();
		System.out.println("BufferedOutputStream.write() --> bufferedOut.dat" );
		
		
		/*******************BufferedInputStream***********************/
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("bufferedOut.dat"));
		
		int readByte = bis.read();
		System.out.println("1.byte : " + readByte);
		readByte = bis.read();
		System.out.println("2.byte : " + readByte);
		readByte = bis.read();
		System.out.println("3.byte : " + readByte);	
		readByte = bis.read();
		System.out.println("4.byte : " + readByte);
		// stream chainning 이라고도 함
		
		while(true) {
			readByte = bis.read();
			if(readByte== -1) break;
			System.out.println(Integer.toBinaryString(readByte));
		}
		bis.close();
		System.out.println();
		System.out.println("BufferedInputStream.read() <-- bufferedOut.dat");
		
		
		
		
		
		
		
		
	}

}
