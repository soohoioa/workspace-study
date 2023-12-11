package com.itwill.dept;

import java.util.List;

import com.itwill.emp.Emp;

/**
 * 특정 테이블과 동일한 속성을 가지는
 * OR-Mapping 클래스 (Object Relation)
 * DTO(Data Transfer Object)
 * @author 
 * 
이름     널?       유형           
------ -------- ------------ 
DEPTNO NOT NULL NUMBER(2)    
DNAME           VARCHAR2(14) 
LOC             VARCHAR2(13) 
 * 
 */
public class Dept {
	private int deptno;
	private String dname;
	private String loc;
	private List<Emp> empList;
	public Dept() {
		// TODO Auto-generated constructor stub
	}
	public Dept(int deptno, String dname, String loc, List<Emp> empList) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
		this.empList = empList;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public List<Emp> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + ", empList=" + empList + "]";
	}
	
}
