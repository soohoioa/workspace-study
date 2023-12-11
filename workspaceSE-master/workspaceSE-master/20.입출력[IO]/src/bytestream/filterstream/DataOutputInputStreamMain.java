package bytestream.filterstream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataOutputInputStreamMain {

	public static void main(String[] args) throws Exception{
		/*
		 * 자바의 기본데이터를 출력스트림에 쉽게 쓸수있도록 하는 기능을 제공하는 필터스트림
		 */
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("dataOut.dat"));
		int intData = 2147483647; // 
		dos.writeInt(intData); 
		dos.writeByte(127);
		dos.writeBoolean(false);
		dos.writeChar('가');
		dos.writeDouble(3.141592);
		dos.writeUTF("오늘은 자바 입출력을 공부합니다!!!");
		
		dos.close();
		System.out.println("DataOutputStream.writeXXX() --> dataOut.txt");
		
		
		/*
		 * 자바의 기본데이터를 입력스트림으로부터 쉽게 읽을수 있도록(필터링) 하는 기능을 제공하는 필터스트림
		 */
		DataInputStream dis = new DataInputStream(new FileInputStream("dataOut.dat"));
		System.out.println("DataOutputStream.readXXX <-- dataOut.dat");
		int readInt = dis.readInt();
		System.out.println("readInt : " + readInt);
		System.out.println("readByte : " + dis.readByte());
		System.out.println("readBoolean : " + dis.readBoolean());
		System.out.println("readChar : " + dis.readChar());
		System.out.println("readDouble : " + dis.readDouble());
		System.out.println("readUTF : " + dis.readUTF());
		dis.close();
		
		
	}

} 
