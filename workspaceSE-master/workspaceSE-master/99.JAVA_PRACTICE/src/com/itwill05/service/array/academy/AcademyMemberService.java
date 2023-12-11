package com.itwill05.service.array.academy;
/* 
 * AcademyMember들의 업무처리클래스
 *  Create
 *  Read
 *  Update
 *  Delete
 */
// 멤버타입,메쏘드이름,메쏘드인자,메쏘드 반환타입에 하위객체의 참조가 이루어지지않도록 작성
// 유지보수,확장성을위해서 하위객체의 의존성을 발생시키지 않도록 작성

public class AcademyMemberService {
	private AcademyMember[] members;

	public AcademyMemberService() {
		members = new AcademyMember[9];
		members[0] = new AcademyStudent(1, "KIM", "자바");
		members[1] = new AcademyStudent(2, "LEE", "리눅스");
		members[2] = new AcademyStudent(3, "KIM", "자바");
		members[3] = new AcademyStudent(4, "LEE", "IOT");
		members[4] = new AcademyGangsa(5, "CHOI", "프로그래밍");
		members[5] = new AcademyGangsa(6, "KIM", "DB");
		members[6] = new AcademyGangsa(7, "DIM", "OS");
		members[7] = new AcademyStaff(8, "AIM", "영업");
		members[8] = new AcademyStaff(9, "QIM", "생산");

	}

	/*
	 * 1.AcademyMember 전체출력
	 */
	public void print() {
		for (int i = 0; i < members.length; i++) {
			members[i].print();
		}
	}
	
	/*
	 * 2-1.번호 1 번 AcademyMember 객체 참조변수반환해줘
	 */
	
	public AcademyMember findByNo(int no) {
		int array = 0;
		for (int i = 0; i < this.members.length; i++) {
			if(this.members[i].getNo() == no) {
				array = i;
				break;
			}
		}
		return members[array];
	}
	
	/*
	 * 2-2.이름 KIM 인 AcademyMember 배열객체 참조변수반환해줘
	 */
	public AcademyMember findByName(String name) {
		int array = 0;
		for (int i = 0; i < members.length; i++) {
			if(this.members[i].getName().equals(name)) {
				array = i;
				break;
			}
		}
		return members[array];
	}

	
	
	/*
	 * 3.AcademyMember 중에서 AcademyStudent객체들 모두반환해줘 [ AcademyMember[] 객체주소반환 ]
	 * 3.AcademyMember 중에서 AcademyStaff객체들 모두반환해줘 [ AcademyMember[] 객체주소반환 ]
	 * 3.AcademyMember 중에서 AcademyGangsa객체들 모두반환해줘 [ AcademyMember[] 객체주소반환 ]
	 */
	private AcademyMember[] GetStudent() {
		int array = 0;
		int[] order = new int[this.members.length];
		for (int i = 0; i < this.members.length; i++) {
			if(this.members[i] instanceof AcademyStudent) {
				array = array +1;
				order[array] = i;
			}
		}
		AcademyMember[] temp = new AcademyStudent[array];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = this.members[order[i]];
		}
		return temp;
	}
	
	private AcademyMember[] GetStaff() {
		int array = 0;
		int[] order = new int[this.members.length];
		for (int i = 0; i < this.members.length; i++) {
			if(this.members[i] instanceof AcademyStaff) {
				array = array + 1;
				order[array] = i;
			}
		}
		AcademyMember[] temp = new AcademyStaff[array];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = this.members[order[i]];
		}
		return temp;
	}
	
	private AcademyMember[] GetGangsa() {
		int array = 0;
		int[] order = new int[this.members.length];
		for (int i = 0; i < this.members.length; i++) {
			if(this.members[i] instanceof AcademyGangsa) {
				array = array + 1;
				order[array] = i;
			}
		}
		AcademyMember[] temp = new AcademyGangsa[array];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = this.members[order[i]];
		}
		return temp;
	}
	
	public AcademyMember[] GetMember(int order) {
		AcademyMember[] temp = null;
		int count = 0;
		if ( order == 1) {
			for (int i = 0; i < this.members.length; i++) {
				if(this.members[i] instanceof AcademyStudent) {
					count = count + 1;
					if ( count > 0 ) {
						temp = this.GetStudent();
						break;
					}
				}
			}
		}
		if ( order == 2) {
			for (int i = 0; i < this.members.length; i++) {
				if(this.members[i] instanceof AcademyStaff) {
					count = count + 1;
					if ( count > 0 ) {
						temp = this.GetStaff();
						break;
					}
				}
			}
		}
		if ( order == 3) {
			for (int i = 0; i < this.members.length; i++) {
				if(this.members[i] instanceof AcademyGangsa) {
					count = count + 1;
					if ( count > 0 ) {
						temp = this.GetGangsa();
						break;
					}
				}
			}
		}
		return temp;
	}



	/*
	 * 4.AcademyMember 중에서 자바반인   AcademyStudent 객체들 배열참조변수반환해줘 
	 * 4.AcademyMember 중에서 영업부서인 AcademyStaff   객체들 배열참조변수반환해줘 
	 * 4.AcademyMember 중에서 자바과목인 AcademyGangsa  객체들 배열참조변수반환해줘
	 */

	/*
	 * 5.AcademyMember 중에서 자바반인   AcademyStudent 객체들 배열참조변수반환해줘[OPTION]
	 * 5.AcademyMember 중에서 영업부서인 AcademyStaff   객체들 배열참조변수반환해줘[OPTION] 
	 * 5.AcademyMember 중에서 자바과목인 AcademyGangsa  객체들 배열참조변수반환해줘[OPTION]
	 */
}
