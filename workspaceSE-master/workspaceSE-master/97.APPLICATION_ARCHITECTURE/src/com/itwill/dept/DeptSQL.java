package com.itwill.dept;

public class DeptSQL {

	public static final String SELECT_DEPT_BY_DEPTNO = "select * from dept where deptno=?";
	public static final String SELECT_DEPT_WITH_EMPS_BY_DEPTNO = 
			"select * from dept d join emp e on d.deptno=e.deptno where d.deptno=?";
}
