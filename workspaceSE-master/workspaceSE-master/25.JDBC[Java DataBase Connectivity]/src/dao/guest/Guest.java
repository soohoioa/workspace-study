package dao.guest;
/*
VO(Value Object),DTO(Data Transfer Object)
	- guest 테이블 1개 row의 데이타의 값을 가지는객체
	- guest 테이블 1개 row의 데이타값을 이동(파라메타,리턴데이타)시키기위한객체 
	- guest 테이블의 컬럼과 동일한수의 멤버변수를가지는객체
*/
/*
이름             널?       유형             
-------------- -------- -------------- 
GUEST_NO       NOT NULL NUMBER(10)     
GUEST_NAME              VARCHAR2(50)   
GUEST_DATE              DATE           
GUEST_EMAIL             VARCHAR2(50)   
GUEST_HOMEPAGE          VARCHAR2(50)   
GUEST_TITLE             VARCHAR2(100)  
GUEST_CONTENT           VARCHAR2(4000) 
*/

import java.sql.Date;

public class Guest {
	private int guestNo;
	private String guestName; 
	private Date guestDate;
	private String guestEmail;
	private String guestHomepage;
	private String guestTitle;
	private String guestContent;
	
	public Guest() {
		
	}
	
	public Guest(int guestNo, String guestName, Date guestDate, String guestEmail, String guestHomepage,
			String guestTitle, String guestContent) {
		super();
		this.guestNo = guestNo;
		this.guestName = guestName;
		this.guestDate = guestDate;
		this.guestEmail = guestEmail;
		this.guestHomepage = guestHomepage;
		this.guestTitle = guestTitle;
		this.guestContent = guestContent;
	}
	

	public int getGuestNo() {
		return guestNo;
	}

	public void setGuestNo(int guestNo) {
		this.guestNo = guestNo;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public Date getGuestDate() {
		return guestDate;
	}

	public void setGuestDate(Date guestDate) {
		this.guestDate = guestDate;
	}

	public String getGuestEmail() {
		return guestEmail;
	}

	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}

	public String getGuestHomepage() {
		return guestHomepage;
	}

	public void setGuestHomepage(String guestHomepage) {
		this.guestHomepage = guestHomepage;
	}

	public String getGuestTitle() {
		return guestTitle;
	}

	public void setGuestTitle(String guestTitle) {
		this.guestTitle = guestTitle;
	}

	public String getGuestContent() {
		return guestContent;
	}

	public void setGuestContent(String guestContent) {
		this.guestContent = guestContent;
	}

	@Override
	public String toString() {
		return "Guest [guestNo=" + guestNo + ", guestName=" + guestName + ", guestDate=" + guestDate + ", guestEmail="
				+ guestEmail + ", guestHomepage=" + guestHomepage + ", guestTitle=" + guestTitle + ", guestContent="
				+ guestContent + "]\n";
	}
	
}

