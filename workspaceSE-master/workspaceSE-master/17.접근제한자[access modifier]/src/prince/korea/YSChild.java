package prince.korea; 

import president.korea.YS;

public class YSChild extends YS{ // 패키지가 다르나 부모자식관계이다.
	//상속관계 있는 멤버들을 사용할수있다. 
	
	public void access2() {
		
		this.member1 = 1;
		this.member2 = 2;
		// this.member3 = 3;
		// this.member4 = 4;
		
		// 패키지가 달라도 사용할수 있는 접근권한
		this.methid1();
		this.methid2();
		
		
		/*
		YS ys = new YS();
		ys.member1 = 1;
		ys.member2 = 2;
		ys.member3 = 3;
		ys.member4 = 4;
		
		ys.methid1();
		ys.methid2();
		ys.methid3();
		ys.methid4();
		*/
	}
	
}
