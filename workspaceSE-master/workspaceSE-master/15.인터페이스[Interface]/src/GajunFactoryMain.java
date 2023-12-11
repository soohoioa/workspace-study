
public class GajunFactoryMain {

	public static void main(String[] args) {
		System.out.println("-----가전제품공장-----");
		GajunTV tv1 = new GajunTV();
		GajunTV tv2 = new GajunTV();
		GajunTV tv3 = new GajunTV();
		
		GajunAudio audio1 = new GajunAudio();
		GajunAudio audio2 = new GajunAudio();
		
		GajunSmartPhone sp1 = new GajunSmartPhone();
		GajunSmartPhone sp2 = new GajunSmartPhone();
		GajunSmartPhone sp3 = new GajunSmartPhone();
		
		GajunOnOff gajun1 = tv1;
		GajunOnOff[] gajunArray = new GajunOnOff[8]; //배열객체는 interface 객체가 아니다., OBject도 가능하지만 잘 사용안함
		gajunArray[0] = tv1;
		gajunArray[1] = tv2;
		gajunArray[2] = tv3;
		gajunArray[3] = audio1;
		gajunArray[4] = audio2;
		gajunArray[5] = sp1;
		gajunArray[6] = sp2;
		gajunArray[7] = sp3;
		
		System.out.println("-----가전제품검사소-----");
		/*
		 * 난 절대로 자식클래스타입(실제구현객체-> 엮이기싫다 -> 상위타입만사용하면 됨)을 사용안할래요. 왜냐하면 엮이기 싫어요..
		 * 난 그래서 부모타입[GajunOnOff, GajunVolume]만 사용할래요..!!
		 * 그래야 가전제품검사 프로그램을 (클래스를 만들어 하위객체와 엮이기 싫다.) 
		 * 한번 만들어서 변경없이 계속 사용할수있으니까요..!!
		 */
		GajunOnOff[] receiveGajunArray = gajunArray;
		for (int i = 0; i < receiveGajunArray.length; i++) {
			System.out.println("-----검사시작-----");
			receiveGajunArray[i].on();
			
			GajunVolume tempGajun = (GajunVolume)receiveGajunArray[i];
			tempGajun.up();
			tempGajun.down();
			
			receiveGajunArray[i].off();
			System.out.println("----검사끝출고----");
		} // 보통은 클래스가 분리되어있음
		
		/*****/
		GajunGumsa gajunGumsa = new GajunGumsa();
		gajunGumsa.setGajuns(gajunArray);
		gajunGumsa.gumsa();
		/*****/
		
	}

}
