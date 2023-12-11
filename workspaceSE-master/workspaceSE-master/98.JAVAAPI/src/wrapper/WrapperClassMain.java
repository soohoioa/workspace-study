package wrapper;
/* 
- Wrapper 클래스

	자바데이타형은 기본데이타형과 레퍼런스데이타(참조타입)형으로 구분됩니다.
	기본데이타형으로는 int,boolean,double 등이 제공됩니다.
	이런기본 데이타형을 객체로 사용할수있는 방법으로 
	Wrapper 클래스가 제공됩니다.
	Wrapper 클래스는 각종유용한 기능들을 메서드로 제공받을수있다는
	장점이있습니다.
	
	// 퇴근하고싶다. 집에가고싶다
	
	Integer,Boolean,Double,Character,Float,Long,Byte,Short
	
 */
public class WrapperClassMain {

	public static void main(String[] args) {
		System.out.println("---------- Boxing, UnBoxing ----------");
		/* Boxing[기본형 --> Wrapper객체] */
		Character wc1 = new Character('김');
		Integer wi1 = new Integer(1231);
		Double wd1= new Double(3.141592);
		Boolean wb1 = new Boolean(true);
		
		/* UnBoxing[Wrapper객체 --> 기본형] */
		char c1 = wc1.charValue();
		int i1 = wi1.intValue();
		double d1 = wd1.doubleValue();
		boolean b1 = wb1.booleanValue();
		
		System.out.println();
		System.out.println("---------- AutoBoxing, AutoUnBoxing ----------");
		/* Auto Boxing[기본형 --> wrapper객체] */
		Character wc2 = '김'; // 자동으로 객체의 주소값이 들어감
		Integer wi2 = 1231;
		Double wd2 = 3.141592;
		Boolean wb2 = true;
		
		/* Auto UnBoxing[Wrapper객체 --> 기본형] */
		char c2 = wc2;
		int i2 = wi2;
		double d2 = wd2;
		boolean b2 = wb2;
		
		System.out.println();
		System.out.println("---------- AutoBoxing ----------");
		int a = 89;
		int b = 45;
		int c = 78;
		int d = 90;
		int e = 99;
		
		Integer ia = new Integer(a);
		Integer ib = b;
		Integer ic = c;
		Integer id = d;
		Integer ie = e;
		
		System.out.println("---------- 자동형변환 ----------");
		Object oa = ia;
		Object ob = ib;
		Object oc = ic;
		Object od = id;
		Object oe = ie;
		
		System.out.println("---------- Auto Boxing, 자동형변환 ----------");
		Object ooa = 89;
		Object oob = 45;
		Object ooc = 78;
		Object ood = 90;
		Object ooe = 99;
		
		System.out.println("---------- Object[] ----------");
		Object[] scoreArray = new Object[5];
		scoreArray[0] = 89;
		scoreArray[1] = 45;
		scoreArray[2] = 78;
		scoreArray[3] = 90;
		scoreArray[4] = 99;
		
		for(int i = 0; i < scoreArray.length; i++) {
			/*
			Integer tempscore = (Integer)scoreArray[i];
			int score = tempscore.intValue();
			System.out.print(score + " ");
			*/
			int score = (Integer)scoreArray[i];
			System.out.print(score + " ");
		}
		
		System.out.println("---------- XXXXX -----------");
		System.out.println();
		Integer wi11 = new Integer(123); // wi11 과 wi22 는 둘이 서로 다른 참조변수
		Integer wi22 = new Integer(123);
		System.out.println("주소비교(==) : " + (wi11 == wi22));
		System.out.println("equals(기본형멤버필드 값 비교로 재정의 됨): " + (wi11.equals(wi22)));
		// equals() 는 객체간의 값(value)을 비교할 수 있고,  == 은 대상의 주소(reference)를 비교
		// Object의 equals는 주소비교
		// Wrapper내부에서는 주소비교 X. 내용 비교로 재정의 되었음
		
		// System.out.println(wi11 + wi22);
		
		
		
		
		
		
	}

}
