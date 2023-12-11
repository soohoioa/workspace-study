// 아카데미 멤버 출력 
public class AcademyMemberPrint {
	
	/*****case1*****/
	public void academyStudentPrint(AcademyStudent academyStudent) {
		academyStudent.print();
	}
	public void academyGangsaPrint(AcademyGangsa academyGangsa) {
		academyGangsa.print();
	}
	public void academyStaffPrint(AcademyStaff academyStaff) {
		academyStaff.print();
	}
	// 아카데미 객체를 넣어줘야함
	
	
	/*****case2*****/
	public void academyMemberPrint(AcademyMember member) {
		 // 멤버를 다 찍어주는 메소드를 만들면 좀 쉽게 가능
		 // AcademyMember 위치에 Object 를 넣어도 Object 가 상위관계라 가능하지만 비즈니스관계적으로는 안함
		
		member.print();
	}
	
	// case1로 설계하는것보다는 (하나씩 다 찍어줘야함)
	// case2로 설계하는게 낫지 않겠냐 라는것이다(상위캐스팅 가능하니까 )
	
	
}
