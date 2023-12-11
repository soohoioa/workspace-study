package com.itwill03.포함.배열관계;

public class DvdMember {

	/*
	- 캡슐화
	<<속성>>
	회원번호
	회원이름
	전화번호
	빌린dvd들
	 */
	
	/*
	<<기능>>
	  회원정보출력 
	 */
	private int memberNo;
	private String memberName;
	private String memberPhone;
	private Dvd dvd;
	
	public DvdMember() {
		
	}
	
	public DvdMember(int memberNo, String memberName, String memberPhone) {
		super();
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
	}

	public DvdMember(int memberNo, String memberName, String memberPhone, Dvd dvd) {
		super();
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.dvd = dvd;
	}

	public void print() {
		System.out.println(memberNo + "\t" + memberName + "\t" + memberPhone);
		if(dvd != null) {
			System.out.println(">> 빌린 DVD : ");
			dvd.print();
		} else {
			System.out.println(">> 빌린 DVD 없습니다.");
		}
	}

	public Dvd getDvd() {
		return dvd;
	}

	public void setDvd(Dvd dvd) {
		this.dvd = dvd;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	
	
	
	
	
}
