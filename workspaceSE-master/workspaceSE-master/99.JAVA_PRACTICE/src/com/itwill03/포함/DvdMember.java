package com.itwill03.포함;

public class DvdMember {

	/*
	- 캡슐화
	<<속성>>
	회원번호
	회원이름
	전화번호
	빌린dvd
	 */
	private int memNo;
	private String memName;
	private String memPhone;
	private Dvd rentDvd;//빌린dvd
	
	public DvdMember() {
		
	}

	public DvdMember(int memNo, String memName, String memPhone, Dvd rentDvd) {
		super();
		this.memNo = memNo;
		this.memName = memName;
		this.memPhone = memPhone;
		this.rentDvd = rentDvd;
	}
	
	/*
	<<기능>>
	  회원정보출력 
	 */
	public void memPrint() {
		System.out.println("회원번호 : " + memNo + "\n" + "회원이름 : " + memName + "\n" + "전화번호 : " + memPhone);
		this.rentDvd.dvdPrint();
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public Dvd getRentDvd() {
		return rentDvd;
	}

	public void setRentDvd(Dvd rentDvd) {
		this.rentDvd = rentDvd;
	}
	
	
	
}
