package com.itwill.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.common.DataSource;
import com.itwill.emp.Emp;

public class DeptDao{
	private DataSource dataSource;
	public DeptDao() throws Exception{
		dataSource=new DataSource();
	}
	public void insert(Dept deparment) throws Exception {
	}
	public Dept selectByNo(int deptno) throws Exception {
		return null;
	}
	public List<Dept> selectByAll() throws Exception {
		return null;
	}
	/*
	 * 부서+사원들
	 */
	public Dept selectDeptWithEmployeesByDeptno(int deptno)throws Exception {
		/*
	  DEPTNO DNAME    LOC   EMPNO    ENAME      JOB     MGR 		HIREDATE    SAL    COMM    DEPTNO
	 ---------- -------------- ------------- ---------- ---------- --------- ---------- ---------- ---
		30	SALES	CHICAGO	7499	ALLEN	SALESMAN	7698	1981/02/20	3546.9		300		30
		30	SALES	CHICAGO	7521	WARD	SALESMAN	7698	1981/02/22	2771.02		500		30
		30	SALES	CHICAGO	7654	MARTIN	SALESMAN	7698	1981/09/28	154.62		1400	30
		30	SALES	CHICAGO	7698	BLAKE	MANAGER		7839	1981/05/01	352.53				30
		30	SALES	CHICAGO	7844	TURNER	SALESMAN	7698	1981/09/08	185.54		0		30
		30	SALES	CHICAGO	7900	JAMES	CLERK		7698	1981/12/03	117.52				30
		 */
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(DeptSQL.SELECT_DEPT_WITH_EMPS_BY_DEPTNO);
		pstmt.setInt(1, deptno);
		ResultSet rs=pstmt.executeQuery();
		Dept dept=null;
		if(rs.next()) {
			dept=new Dept(rs.getInt("deptno"),
					 rs.getString("dname"),
					 rs.getString("loc"),
					 new ArrayList());
			
			do {
				dept.getEmpList().add(
						new Emp(rs.getInt("empno"),
								rs.getString("ename"),
								rs.getString("job"),
								rs.getInt("mgr"),
								rs.getDate("hiredate"),
								rs.getInt("sal"),
								rs.getInt("comm"),
								null)
						);
				
			}while(rs.next());
			
		}
		
	return dept;	
	
		
	}
	
}