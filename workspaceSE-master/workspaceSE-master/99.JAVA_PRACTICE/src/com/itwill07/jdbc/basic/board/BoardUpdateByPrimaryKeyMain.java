package com.itwill07.jdbc.basic.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BoardUpdateByPrimaryKeyMain {

	public static void main(String[] args) throws Exception {

		/*******데이타베이스 접속정보[182.237.126.19]************/
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper03";
		String password = "jdeveloper03";
		/********************************************************/
		
		String updateSql = "update board set board_title='변경타이틀',board_content='변경content' where board_no=10";
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(updateSql);
		
		System.out.println(" >> update row count : " + rowCount);
		
		stmt.close();
		con.close();
		
		
	}

}
