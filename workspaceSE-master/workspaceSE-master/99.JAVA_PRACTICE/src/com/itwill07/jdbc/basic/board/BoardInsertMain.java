package com.itwill07.jdbc.basic.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BoardInsertMain {

	public static void main(String[] args) throws Exception {
		
		/*******데이타베이스 접속정보[182.237.126.19]************/
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper03";
		String password = "jdeveloper03";
		/********************************************************/
		
		String insertsql = "insert into board(board_no,board_title,board_content) values(board_no_seq.nextval,'제목','내용입니다')";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(insertsql);
		
		System.out.println(" >> insert row count : " + rowCount);
		
		stmt.close();
		con.close();
		
		
	}

}
