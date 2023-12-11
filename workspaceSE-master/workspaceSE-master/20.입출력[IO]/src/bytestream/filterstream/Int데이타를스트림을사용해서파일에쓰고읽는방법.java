package bytestream.filterstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Int데이타를스트림을사용해서파일에쓰고읽는방법 {

	public static void main(String[] args)  throws Exception {
		
		FileOutputStream fos = new FileOutputStream("intDataWriteRead.dat");

		int witeIntData = 2147483647;

		/*
		        << witeIntData >>
		        01111111|11111111|11111111|11111111
		 *         (1)     (2)       (3)      (4) 
		 *         
		 * >>24 00000000|00000000|00000000|01111111 
		 *                                    (1)
		 * >>16 00000000|00000000|01111111|11111111
		 *                           (1)      (2)
		 * >>8  00000000|01111111|11111111|11111111
		 *                  (1)      (2)      (3)
		 *      01111111|11111111|11111111|11111111
		 *         (1)      (2)      (3)      (4)  
		 */
		fos.write(witeIntData >> 24);
		fos.write(witeIntData >> 16);
		fos.write(witeIntData >> 8);
		fos.write(witeIntData >> 0);

		fos.close();
		System.out.println("writeIntData:" + witeIntData);
		FileInputStream fis = new FileInputStream("intDataWriteRead.dat");
		int readIntData = 0;
		/*
		 * << 24 01111111|00000000|00000000|00000000
		 *          (1)                          
		 * << 16 00000000|11111111|00000000|00000000
		 *                  (2)            
		 * <<  8 00000000|00000000|11111111|00000000
		 * 							  (3)
		 *       00000000|00000000|00000000|11111111
		 *                      				(4)
		 		 << readIntData >>
				 01111111|11111111|11111111|11111111
		 *         (1)      (2)      (3)      (4)  
		 */
		int readByte1 = fis.read() << 24;
		int readByte2 = fis.read() << 16;
		int readByte3 = fis.read() << 8;
		int readByte4 = fis.read() << 0;
		readIntData = readByte1 | readByte2 | readByte3 | readByte4;
		System.out.println("readIntData:" + readIntData);


	}

}
