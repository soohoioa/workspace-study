package com.itwill.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.common.DataSource;
import com.itwill.dept.Dept;



public class EmpDao {
	private DataSource dataSource;
	public EmpDao() throws Exception{
		dataSource=new DataSource();
	}
	
	public int insert(Emp emp) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int update(Emp emp) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int delete(int empno) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


	public Emp findByEmpno(int empno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public List<Emp> findByDeptno(int deptno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	// 사원정보(부서정보포함) 한개 반환
	public Emp findEmpWithDeptByEmpno(int empno)throws Exception {
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(EmpSQL.SELECT_EMPNO_WITHDEPT);
		pstmt.setInt(1, empno);
		ResultSet rs=pstmt.executeQuery();
		Emp emp=null;
		if(rs.next()) {
			emp=new Emp(rs.getInt("empno"),
						rs.getString("ename"),
						rs.getString("job"),
						rs.getInt("mgr"),
						rs.getDate("hiredate"),
						rs.getInt("sal"),
						rs.getInt("comm"),
						new Dept(rs.getInt("deptno"),
								 rs.getString("dname"),
								 rs.getString("loc"),
								 null));
		}
		return emp;
	}
	
	//사원정보(부서정보포함) 전체목록 반환
	public List<Emp> findEmpWithDeptByAll()throws Exception {
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(EmpSQL.SELECT_ALLEMP_WITHDEPT);
		
		ResultSet rs=pstmt.executeQuery();
		List<Emp> empList=new ArrayList<Emp>();
		while(rs.next()) {
			empList.add(new Emp(rs.getInt("empno"),
						rs.getString("ename"),
						rs.getString("job"),
						rs.getInt("mgr"),
						rs.getDate("hiredate"),
						rs.getInt("sal"),
						rs.getInt("comm"),
						new Dept(rs.getInt("deptno"),
								 rs.getString("dname"),
								 rs.getString("loc"),
								 null)));
		}
		return empList;
	}

	

}
