package com.itwill07.jdbc.basic.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class BoardSelectByPrimaryKeyMain {

	public static void main(String[] args) throws Exception {
		
		/*******데이타베이스 접속정보[182.237.126.19]************/
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper03";
		String password = "jdeveloper03";
		/********************************************************/
		String selectsql = "select * from board where board_no=2";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();		
		
		ResultSet rs = stmt.executeQuery(selectsql);
		
		while (rs.next()) {
			int no = rs.getInt("board_no");
			String title = rs.getString("board_title");
			String content = rs.getString("board_content");
			Date wday = rs.getDate("board_wday");
			int readCount = rs.getInt("board_read_count");
			System.out.println( no + "\t" + title + "\t" + content + "\t" + wday + "\t" + readCount);
		}
		
		rs.close();
		stmt.close();
		con.close();
		
		
	}

}
