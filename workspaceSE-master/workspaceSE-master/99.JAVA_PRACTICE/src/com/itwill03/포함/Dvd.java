package com.itwill03.포함;

public class Dvd {

	/*
	 * - 캡슐화하세요
	 * - 생성자를 정의하세요
	 * 
	 * <<속성>>
	 *  번호
		타이틀
		쟝르
	 */
	private int dvdNo;
	private String dvdTitle;
	private String dvdSort;
	
	public Dvd() {
		
	}

	public Dvd(int dvdNo, String dvdTitle, String dvdSort) {
		this.dvdNo = dvdNo;
		this.dvdTitle = dvdTitle;
		this.dvdSort = dvdSort;
	}
	
	
	/* 
	 * <<기능>>
	 *   Dvd정보출력
	 *   
	 */
	public void dvdPrint() {
		System.out.println(this.dvdNo + "\t" + this.dvdTitle + "\t" + this.dvdSort);
	}

	public int getDvdNo() {
		return dvdNo;
	}

	public void setDvdNo(int dvdNo) {
		this.dvdNo = dvdNo;
	}

	public String getDvdTitle() {
		return dvdTitle;
	}

	public void setDvdTitle(String dvdTitle) {
		this.dvdTitle = dvdTitle;
	}

	public String getDvdSort() {
		return dvdSort;
	}

	public void setDvdSort(String dvdSort) {
		this.dvdSort = dvdSort;
	}
	
}
