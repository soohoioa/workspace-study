package com.itwill07.jdbc.basic.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountSelectAllMain {

	public static void main(String[] args) throws Exception {
		
		/*******데이타베이스 접속정보[182.237.126.19]************/
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper03";
		String password = "jdeveloper03";
		/********************************************************/
		
		String selectSql = "SELECT * FROM account";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();		
		
		ResultSet rs = stmt.executeQuery(selectSql);
		
		/* --------------------------------
		 * DB타입 		| 자바타입
		 * --------------------------------
		 * number		| int,double(float)
		 * varchar2,char| String
		 * Date			| Date
		 * --------------------------------
		 */
		
		while (rs.next()) {
			int no = rs.getInt("account_no");
			String owner = rs.getString("account_owner");
			int balance = rs.getInt("account_balance");
			String iyul = rs.getString("account_iyul");
			System.out.println(no + "\t" + owner + "\t" + balance + "\t" + iyul);
		}
		
		rs.close();
		stmt.close();
		con.close();
		

	}

}
