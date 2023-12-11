
public class AcademyMemberArrayMain {

	public static void main(String[] args) {
		AcademyStudent[] students = new AcademyStudent[3];
		AcademyGangsa[] gangsas = new AcademyGangsa[2];
		AcademyStaff[] staffs = new AcademyStaff[2];
		
		
		students[0] = new AcademyStudent(1, "KIM", "JAVA");
		students[1] = new AcademyStudent(2, "LEE", "IOS");
		students[2] = new AcademyStudent(3, "PARK", "CLOUDE");
		
		gangsas[0] = new AcademyGangsa(4, "김강사", "JAVA");
		gangsas[1] = new AcademyGangsa(5, "정강사", "안드로이드");
		
		staffs[0]=new AcademyStaff(6, "천상용", "마케팅");
		staffs[1]=new AcademyStaff(7, "김나영", "회계");
		
		System.out.println("----------AcademyMember전체출력----------");
		System.out.println("----------Student[for]----------");
		for (int i = 0; i < students.length; i++) {
			AcademyStudent academyStudent = students[i];
			academyStudent.studentPrint();
		}
		
		System.out.println("----------Student[enhanced for]----------");
		for (AcademyStudent academyStudent : students) {
			academyStudent.studentPrint();
		}
		
		System.out.println("----------Gangsa----------");
		for (AcademyGangsa academyGangsa : gangsas) {
			academyGangsa.gangsaPrint();
		}
		System.out.println("----------Staff----------");
		for (AcademyStaff academyStaff : staffs) {
			academyStaff.staffPrint();
		}
		
		
		
		
		
		
		
		
		
		
	}

}
