package president.korea;

import president.america.Trump;

public class YS {
	
	public int member1;
	protected int member2;
	int member3; //(default)
	private int member4;
	
	
	public void methid1() {
		System.out.println("YS.method1()");
	}
	protected void methid2() {
		System.out.println("YS.method2()");
	}
	void methid3() {
		System.out.println("YS.method3()");
	}
	private void methid4() {
		System.out.println("YS.method4()");
	}
	
	public void access() {
		/***** YS와 같은패키지의 클래스의 멤버 접근 *****/
		// president.korea.DJ dj = new president.korea.DJ();
		// 같은패키지에서는 import 할 필요 없다. import
		DJ dj = new DJ();
		dj.member1 = 1;
		dj.member2 = 2;
		dj.member3 = 3;
		// dj.memer4 = 4; private 이라 접근이 불가능
		dj.methid1();
		dj.methid2();
		dj.methid3();
		// dj.methid4();
		
		// 같은 패키지라면 private 제외 접근가능
		// 다른 패키지라면 public만 접근가능
		
		/***** YS와 다른패키지의 클래스의 멤버 접근 *****/
		Trump trump = new Trump();
		trump.member1 = 1;
		/*
		trump.member2 = 2; 패키지가 달라 접근이 불가능하다.
		trump.member3 = 3; 패키지가 달라 접근이 불가능하다.
		trump.member4 = 4; 패키지도 다르고 private 이라 접근이 불가능 하다.
		*/
		trump.methid1();
		/*
		trump.methid2();
		trump.methid3();
		trump.methid4();
		*/
		

		
		
	}
	
	
}
