package bytestream.filterstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferedOutputInputStreamFileCopyMain {

	public static void main(String[] args) throws Exception{
		long startTime = System.currentTimeMillis();
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("image.jpg"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("image_copy_jpg"));
		
		int byteCount = 0;
		int starCount = 0;
		while(true) {
			int readByte = bis.read();
			if(readByte == -1) break;
			byteCount++;
			if(byteCount % 1024 == 0) {
				System.out.print("*");
				starCount++;
				if(starCount % 20 == 0) {
					System.out.println();
				}
			}
			bos.write(readByte);
		}
		bis.close();
		bos.close();
		
		System.out.println();
		System.out.println("BufferedOutputInputStreamCopy : " + byteCount + "bytes copy");
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		System.out.println(duration + "ms.. ");
	}
}
