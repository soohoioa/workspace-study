
public class EncapsulationMain {

	public static void main(String[] args) {
		 Encapsulation  encapsulation = new  Encapsulation();
		 /*
		  *  Encapsulation 객체멤버필드에 데이터 대입
		  */
		 /*
		 encapsulation.memberField1 = 123;
		 // The field Encapsulation.memberField1 is not visible
		 // 참조변수에서 멤버접근자로 접근이 불가능
		 encapsulation.memberField2 = true;
		 encapsulation.memberField3 = '김';
		 encapsulation.memberField4 = 1.3421;
		 */
		 encapsulation.setMemberField1(123);
		 encapsulation.setMemberField2(false);
		 encapsulation.setMemberField3('김');
		 encapsulation.setMemberField4(1.3421);
		 
		 
		 /*
		  *  Encapsulation 객체멤버필드 데이터 출력
		  */
		 /*
		 System.out.println(encapsulation.memberField1);
		 System.out.println(encapsulation.memberField2);
		 System.out.println(encapsulation.memberField3);
		 System.out.println(encapsulation.memberField4);
		 */
		 // temp : 임시변수
		int tempMemberField1 = encapsulation.getMemberField1();
		 System.out.println(tempMemberField1);
		 System.out.println(encapsulation.getMemberField2());
		 System.out.println(encapsulation.getMemberField3());
		 System.out.println(encapsulation.getMemberField4());
		 
		 /**encapsulation 객체멤버들 출력***/
		 encapsulation.print();
		 // 구성요소중 행위만 사용하게 됨
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	}

}
