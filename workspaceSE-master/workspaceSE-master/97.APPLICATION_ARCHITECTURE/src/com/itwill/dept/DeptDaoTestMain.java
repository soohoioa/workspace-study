package com.itwill.dept;

public class DeptDaoTestMain {

	public static void main(String[] args) throws Exception{
		DeptDao deptDao=new DeptDao();
		//deptDao.insert(deparment);
		//deptDao.selectByNo(deptno);
		//deptDao.selectByAll();
		Dept dept=deptDao.selectDeptWithEmployeesByDeptno(30);
		System.out.println(dept);
	}

}
