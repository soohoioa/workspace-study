package bytestream;

import java.io.FileInputStream;

/*
 * <<입력스트림(InputStream)사용방법>>
 * 1. 데이타 source 선정(파일)
 * 2. 입력스트림(InputStream)객체생성(FileInputStream)
 * 3. 입력스트림(InputStream)으로부터 한바이트씩  읽는다(read)
 * 4. 입력스트림(InputStream)닫는다.(close) 
 */
public class FileInputStreamMain {

	public static void main(String[] args) throws Exception{
		/*
		 public abstract int read()
                  throws IOException
		 Reads the next byte of data from the input stream. 
		 The value byte is returned as an int in the range 0 to 255. 
		 If no byte is available because the end of the stream has been reached, the value -1 is returned. 
		 This method blocks until input data is available, the end of the stream is detected, or an exception is thrown.
		 입력 스트림에서 데이터의 다음 바이트를 읽습니다. 
		 값 byte는 0에서 255 범위의 int로 반환됩니다. 
		 스트림 끝에 도달하여 사용할 수 있는 바이트가 없으면 값 -1이 반환됩니다. 
		 이 메서드는 입력 데이터를 사용할 수 있거나 스트림의 끝이 감지되거나 예외가 발생할 때까지 차단됩니다.
		 */
		FileInputStream fis = new FileInputStream("fileOut.dat");
		int byteCount = 0;
		
		int readByte = fis.read();
		byteCount++;
		System.out.println("1.byte : " + Integer.toBinaryString(readByte)); 
		readByte = fis.read();
		byteCount++;
		System.out.println("2.byte : " + Integer.toBinaryString(readByte));
		readByte = fis.read();
		byteCount++;
		System.out.println("3.byte : " + Integer.toBinaryString(readByte));
		readByte = fis.read();
		byteCount++;
		System.out.println("4.byte : " + Integer.toBinaryString(readByte));
		while (true) {
			readByte = fis.read();
			if(readByte == -1) break;
			byteCount++;
			System.out.println(Integer.toBinaryString(readByte));
		}
		fis.close();
		System.out.println("FileInputStream.read() <-- fileOut.dat : " + byteCount + "바이트 읽음");
		// 앞의 0은 생략되서 출력
	}

}
