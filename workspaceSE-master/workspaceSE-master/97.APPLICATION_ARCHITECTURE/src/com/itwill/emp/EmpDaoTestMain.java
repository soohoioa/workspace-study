package com.itwill.emp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpDaoTestMain {

	public static void main(String[] args)throws Exception {
		EmpDao empDao=new EmpDao();
		System.out.println("------------findEmpWithDeptByEmpno(7499)--------------");
		Emp emp =empDao.findEmpWithDeptByEmpno(7499);
		System.out.println(emp);
		System.out.println(emp.getDept());
		System.out.println("------------findEmpWithDeptByAll----------------------");
		List<Emp> empList=empDao.findEmpWithDeptByAll();
		System.out.println(empList);
	}

}
