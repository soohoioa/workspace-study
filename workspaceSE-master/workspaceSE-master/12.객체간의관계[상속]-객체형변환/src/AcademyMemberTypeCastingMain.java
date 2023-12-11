
public class AcademyMemberTypeCastingMain {

	public static void main(String[] args) {
		/*
		 public class AcademyStudent extends AcademyMember{}
		 public class AcademyGangsa extends AcademyMember{}
		 public class AcademyStaff extends AcademyMember{}
		 
		 AcademyMember의 자식타입객체(AcademyStudent, AcademyGangsa, AcademyStaff)들은
		 AcademyMember 타입 변수에 대입 가능(참조 가능)
		 */
		AcademyStudent st1 = new AcademyStudent(1, "KIM", "ANDROID");
		AcademyMember m1 = st1;
		AcademyMember m2 = new AcademyStudent(2, "LEE", "JAVA");
		AcademyMember m3 = new AcademyStudent(3, "JIM", "OFFICE");
		
		
		AcademyMember m4 = new AcademyGangsa(4, "박강사", "보안");
		AcademyMember m5 = new AcademyGangsa(5, "정강사", "빅데이터");
		
		AcademyMember m6 = new AcademyStaff(6, "박원장", "원장");
		AcademyMember m7 = new AcademyStaff(7, "나대리", "교무");

		/***** AcademyMember에 정의되지 않은 메소드가 호출 불가능 ***
		String ban = m1.getBan();
		*************************************************************/
		
		/***** AcademyMember에 정의된 메소드중 재정의 된 메소드 호출 가능 ***
		 	- AcademyMember 타입에 정의된 print 메소드를 호출하면
		 	- AcademyMember의 자식타입객체의 재정의 된 print 메소드가 호출된다.
		*********************************************************************/
		m1.print();
		
		System.out.println("-----AcademyMember 들 전체출력-----");
		m1.print();
		m2.print();
		m3.print();
		m4.print();
		m5.print();
		m6.print();
		m7.print();
		
	}

}
