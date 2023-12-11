package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCFlowMain {

	public static void main(String[] args) throws Exception {
		/***********데이타베이스 접속정보[localhost]************
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:localhost:1521:xe";
		String user="scott";
		String password="tiger";
		********************************************************/
		
		/*******데이타베이스 접속정보[182.237.126.19]************/
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper03";
		String password = "jdeveloper03";
		/********************************************************/
		
		String selsctsql = "SELECT * FROM dept"; // 자바에서 SQL작성시 ; 사용안함
		
		
		/*
		 1. Driver class loading 
		 	A. Driver Class 객체생성
		 	B. DriverManager 에 드라이버 객체 등록
		 -> 의존성줄이기 위해 이름(String 형태)으로 올림
		 */
		Class.forName(driverClass);
		System.out.println("1.Driver class loading");
		
		/*
		 2. Connection 객체생성
		 	- DB Server와 연결된 객체
		 */
		Connection con = DriverManager.getConnection(url,user,password);
		System.out.println("2.Connection객체생성 : " + con);
		
		/*
		 3. Statement 객체생성
		 	- SQL문 전송 객체 생성
		 */
		Statement stmt = con.createStatement();
		System.out.println("3. Statement 객체생성 : " + stmt);
		
		/*
		 4. SQL문 전송(SELECT)
		 
		 5. ResultSet 객체를 반환 받음(SELECT)
		 	 << ResultSet 객체 >>
		 	 ------------------------------
		 	 DEPTNO	   ENAME	  LOC
		 	 ------------------------------
  (cursor)-> BEFORE FIRST 영역 
		 	 10		ACCOUNTING	NEW YORK
		 	 20		RESEARCH	DALLAS
		 	 30		SALES		CHICAGO
		 	 40		OPERATIONS	BOSTON
		 	 AFTER LAST 영역
		 */
		ResultSet rs = stmt.executeQuery(selsctsql);
		System.out.println("4, 5. ResultSet 객체 얻기(SELECT문 실행결과) : " + rs);
		
		System.out.println("------------------------------");
		System.out.println("DEPTNO	   ENAME	  LOC");
		System.out.println("------------------------------");
		
		while (rs.next()) { // 데이터 존재 여부 확인후 뽑으면 된다.
			int deptno = rs.getInt("deptno"); // 컬럼이름을 적는다.
			String dname = rs.getString("dname");
			String loc= rs.getString("loc");
		
			System.out.println(deptno + "\t" + dname + "\t" + loc);
		}
		
		// int deptno = rs.getInt("deptno"); -> java.sql.SQLException: 마지막 행 다음의 결과 집합
		
		
		System.out.println("------------------------------");
		/*
		 6. 연결객체(resource 해지) close
		 */
		rs.close();
		stmt.close();
		con.close();
		System.out.println("6. 연결객체(resource 해지) close");
		
		
	}

}
