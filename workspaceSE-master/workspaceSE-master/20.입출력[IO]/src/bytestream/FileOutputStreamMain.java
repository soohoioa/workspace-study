package bytestream;

import java.io.FileOutputStream;

import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;

/*
 * <<출력스트림(OutputStream)사용방법>>
 * 1. 데이타 목적지(target,destination) 선정(파일)
 * 2. 출력스트림(OutputStream)객체생성(FileOutputStream)
 * 3. 출력스트림(OutputStream)에 한바이트씩 쓴다(write)
 * 4. 출력스트림(OutputStream)닫는다.(close) 
 */
public class FileOutputStreamMain {

	public static void main(String[] args) throws Exception{
		/*
		 public abstract void write(int b)
                    throws IOException
		 Writes the specified byte to this output stream.
		 The general contract for write is that one byte is written to the output stream. 
		 The byte to be written is the eight low-order bits of the argument b. 
		 The 24 high-order bits of b are ignored.
		 이 출력 스트림에 지정된 바이트를 씁니다. 
		 쓰기에 대한 일반적인 계약은 1바이트가 출력 스트림에 기록된다는 것입니다. 
		 쓰여질 바이트는 인수 b의 하위 8비트입니다.
		 b의 상위 24비트는 무시됩니다.
		 */
		FileOutputStream fos = new FileOutputStream("fileOut.dat");
		// OutputStream 기본생성자가 없어서 인자를 넣어줘야함 - 파일 이름을 넣어줘야함
		// Unhandled exception type FileNotFoundException -> throws Exception 작성
		fos.write(0b00000000000000000000000000000000);
		fos.write(1);
		fos.write(2);
		fos.write(3);
		fos.write(4);
		fos.write(0b00000000000000000000000011111111);
		
		for (int i = 0; i <256; i++) {
			fos.write(i);
		} // 255 넘으면 잘라서 사용
		fos.close();
		
		System.out.println("FileOutputStream.write() --> fileOut.dat");
		
		
		
		
		
	}

}
