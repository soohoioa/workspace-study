
public class VariableTypes {

	public static void main(String[] args) {
		/*
		 * 논리형
		 *  1. 논리형변수타입(boolean)
		 *  	boolean b1;
		 *  	boolean b2;
		 *  	- 논리형변수 : b1, b2
		 *  	- 논리형이터럴 / 논리형데이터 : true, false
		 */
		boolean bool1;
		boolean bool2;
		boolean bool3;
		boolean bool4;
		bool1 = true;
		bool2 = false;
		bool3 = true;
		bool4 = bool3;
		System.out.println("----------boolean----------");
		System.out.println(bool1);
		System.out.println(bool2);
		System.out.println(bool3);
		System.out.println(bool4);
		
		// true = false;

		
		// 리터럴은 그 자체로 데이터라 담을수 없음
		// 리터럴은 기존적으로 상수의 성격을 가짐
		// 형변환 숫자에서 가능
		// 작은 자료형에서 큰 자료형으로 형 변환은 자동으로 이루어짐
		
		
		/*
		 숫자형
		 
		 1. 정수형변수타입(byte, short, int, long)
		 		 		int kor;
		 				int eng;
		 				int math;
		 
		 	- 정수형변수 : kor, eng, math
		 	- 정수형리터럴 / 정수형데이터 : 10, 23, -90, 23432423 (int)
		 */
		
		byte b1 = 3;
		byte b2 = -128; // 바이트 가장 작은 값
		byte b3 = 127; // 바이트 가장 큰 값
		byte b4 = 0b01111111;
		
		/*
		 << Type mismatch: cannot convert from int to byte >>
		 byte b5 = 128;
		 
		int i = 3;
		byte b5 = i; 
		변수라서 안됨, 
		예외적인 경우 정수형 리터럴 데이터가 정수형 보다 작은 타입
		*/
		
		System.out.println("----------byte----------");
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		
		
		
		short s1 = 734;
		short s2 = -32768; // short 가장 작은 값
		short s3 = 32767; // short 가장 큰 값
		short s4 = 0b111111111111111;
		
		/*
		<< Type mismatch: cannot convert from int to short >>
		short s5 = 32768;

		i = 734;
		short s6 = i; 오른쪽이 작고 왼쪽이 크면 들어가지만 그 반대는 불가 
		*/
		
		System.out.println("----------short----------");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
		
		
		int i1, i2, i3, i4, i5, i6;
		i1 = 88; 
		i2 = 99;
		i3 = 2147483647; // 양수의 최대값
		i4 = 0b01111111111111111111111111111111;
		i5 = i1;
		i6 = i2; 
		System.out.println("----------int----------");
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println(i4);
		System.out.println(i5);
		System.out.println(i6);
		
		
		
		long l1 = 232;
		/*
		 *  The literal 2147483648 of type int is out of range 
		 *  정수형 리터럴은 4바이트를 넘어가는 데이터 표현 불가
		 *  리터럴을 잡을 기본 저장소 4바이트
		 */
		long l2 = 2147483648L;
		// 대소문자 상관없지만 되도록이면 대문자L 표현
		System.out.println("----------long----------");
		System.out.println(l1);
		System.out.println(l2);
		
		
		
		
		
		/*
		 2. 실수형변수타입(float, double)
					float avg;
					double height;
		 
		 	- 실수형변수 : avg, height
		 	- 실수형리터럴 / 실수형데이터 : 1.23 , 78.25 , 100. (double)
		 */
		
		
		float f1, f2, f3;
		f1 = 0.1F;
		f2 = 3.14F;
		f3 = 10000.0F;
		System.out.println("-----------float------------");
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);
		
		double d1, d2, d3;
		d1 = 3.141592;
		d2 = 12345678912345678912345678.0;
		d3 = 1.2345678912345678912345678;
		System.out.println("-----------double------------");
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
		
		
	}

}
