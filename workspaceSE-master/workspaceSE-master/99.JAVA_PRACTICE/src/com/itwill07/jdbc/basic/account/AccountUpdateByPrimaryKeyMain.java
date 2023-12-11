package com.itwill07.jdbc.basic.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AccountUpdateByPrimaryKeyMain {

	public static void main(String[] args) throws Exception {
		
		/*******데이타베이스 접속정보[182.237.126.19]************/
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper03";
		String password = "jdeveloper03";
		/********************************************************/
		
		String updateSql = "UPDATE account SET account_owner = '홍길동' , account_balance = 123456789 WHERE account_no = 1";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(updateSql);
		
		System.out.println(" >> update row count : " + rowCount);
		
		stmt.close();
		con.close();

	}

}
