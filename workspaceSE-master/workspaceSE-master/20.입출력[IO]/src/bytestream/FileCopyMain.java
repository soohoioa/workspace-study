package bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyMain {

	public static void main(String[] args) throws Exception{
		
		long startTime = System.currentTimeMillis();
		
		String originalFileName = "image.jpg";
		String copyFileName = "image_copy_jpg"; // 확장은 같아야함
		FileInputStream fis = new FileInputStream(originalFileName); // 이건 존재해야함
		FileOutputStream fos = new FileOutputStream(copyFileName); // 현재 존재하지 않더라도 만들어짐
		int byteCount = 0;
		int starCount = 0;
		while(true) {
			int readByte = fis.read(); // 1. 한바이트 읽고
			if(readByte == -1) break;
			// System.out.println(Integer.toBinaryString(readByte));
			byteCount++;
			if(byteCount % 1024 == 0) {
				System.out.print("*");
				starCount++;
				if(starCount % 20 == 0) {
					System.out.println();
				}
			}
			fos.write(readByte); // 2. 한바이트 쓰고
		}
		fis.close();
		fos.close();
		System.out.println();
		System.out.println("FileCopy : " + byteCount + "bytes copy!!"); // IO성능에 굉장히 별로임.
		
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		System.out.println(duration + "ms.. ");
		
		
	} // 한바이트씩 옮기면 부하가 많이 생기고 성능저하를 일으킴 
	
	
	
	

	
	
}
