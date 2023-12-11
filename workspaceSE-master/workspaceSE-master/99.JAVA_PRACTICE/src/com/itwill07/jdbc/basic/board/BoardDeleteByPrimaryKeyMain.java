package com.itwill07.jdbc.basic.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BoardDeleteByPrimaryKeyMain {

	public static void main(String[] args) throws Exception{
		/*******데이타베이스 접속정보[182.237.126.19]************/
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper03";
		String password = "jdeveloper03";
		/********************************************************/
		
		String deleteSql = "delete board where board_no=1";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(deleteSql);
		
		System.out.println(" >> delete row count : " + rowCount);
		
		stmt.close();
		con.close();
		
	}

}
