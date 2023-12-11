package com.itwill07.jdbc.basic.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AccountInsertMain {

	public static void main(String[] args) throws Exception {
		
		/*******데이타베이스 접속정보[182.237.126.19]************/
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper03";
		String password = "jdeveloper03";
		/********************************************************/
		
		String insertSql = "INSERT INTO account(account_no, account_owner, account_balance, account_iyul) VALUES(account_no_seq.nextval,'이름', 951951 , 3.5)";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(insertSql);
		
		System.out.println(" >> insert row count : " + rowCount);
		
		stmt.close();
		con.close();
		
	}

}
