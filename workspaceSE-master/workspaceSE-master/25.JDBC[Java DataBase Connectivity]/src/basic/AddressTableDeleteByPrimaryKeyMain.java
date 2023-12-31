package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddressTableDeleteByPrimaryKeyMain {

	public static void main(String[] args) throws Exception {
		/*******데이타베이스 접속정보[182.237.126.19]************/
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper03";
		String password = "jdeveloper03";
		/********************************************************/
		String deleteSql = "delete from address where no = 13";
		
		/*
		 1.Driver class loading
	     2.Connection 객체생성
		 3.Statement객체생성
		 4.SQL문전송(delete)
		 5.SQL문전송(delete)결과 영향받은행의수 반환
		 6.연결객체해지(resource해지) close
		 */
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(deleteSql);
		
		/*
		Statement 를 사용한 SQL문전송
		int executeUpdate(String sql) throws SQLException
			- Executes the given SQL statement, 
				which may be an INSERT, UPDATE, or DELETE statement 
				or an SQL statement that returns nothing, 
				such as an SQL DDL statement.
		Parameters:
			sql - an SQL Data Manipulation Language (DML) statement, 
				 such as INSERT, UPDATE or DELETE; 
				 or an SQL statement that returns nothing, 
				 such as a DDL statement.
		Returns:
			either (1) the row count for SQL Data Manipulation Language (DML) statements 
			or (2) 0 for SQL statements that return nothing
		 */
		
		System.out.println(" >> delete row count : " + rowCount);
		
		
	}

}
