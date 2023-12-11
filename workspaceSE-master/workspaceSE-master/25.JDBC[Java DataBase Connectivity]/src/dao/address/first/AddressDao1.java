package dao.address.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 DAO (Data Access Object) 클래스 : 데이터베이스클래스
 	- address 테이블에 CRUD (Create, Read, Update, Delete) 작업을 하는 단위 메소드를 가지고 있는 클래스
 */

public class AddressDao1 {
	/*******데이타베이스 접속정보[182.237.126.19]************/
	private String driverClass = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
	private String user = "jdeveloper03";
	private String password = "jdeveloper03";
	/********************************************************/
	// 공통으로 들어가서 멤버로 빼줌
	
	public void insert() throws Exception {
		String insertsql = "insert into address values(address_no_seq.nextval, '홍길동', '123-3456', '경기도 포천시')";
				
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(insertsql);
		
		System.out.println(" >> insert row count : " + rowCount);		
		
		stmt.close();
		con.close();
	}
	
	public void updateByPrimaryKey() throws Exception { // 기본적으로 pkUpdate pkDalete
		String updateSql = "update address set name = '홍변경' , phone = '888-8888' , address = '서울시 강남구' where no = 1";

		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(updateSql);
		
		System.out.println(" >> update row count : " + rowCount);	
		
		stmt.close();
		con.close();
	}
	
	public void deleteByPrimaryKey() throws Exception {
		String deleteSql = "delete from address where no = 13";
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(deleteSql);
		
		System.out.println(" >> delete row count : " + rowCount);
		
		stmt.close();
		con.close();
	}
	
	public void findByPrimaryKey() throws Exception { // selectByNo 도 no 가 pk 라면 가능.
		String selectSql = "select no, name, phone, address from address where no = 26";

		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();		

		ResultSet rs = stmt.executeQuery(selectSql);		

		if(rs.next()) {
				int no=rs.getInt("no");
				String name=rs.getString("name");
				String phone=rs.getString("phone");
				String address=rs.getString("address");
				System.out.println(no+" "+name+" "+phone+" "+address);
		}else {
			System.out.println(">> 주소록 친구없다~~~");
		}
		rs.close();
		stmt.close();
		con.close();
	}
	
	public void findAll() throws Exception { // selectByPrimaryKey 라고도 작성하지만 대부분 find 를 붙여서 사용함
		String selectSql = "select no, name, phone, address from address";

		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		Statement stmt = con.createStatement();		
		
		ResultSet rs = stmt.executeQuery(selectSql);		

		if(rs.next()) {
			do{
				int no=rs.getInt("no");
				String name=rs.getString("name");
				String phone=rs.getString("phone");
				String address=rs.getString("address");
				System.out.println(no+" "+name+" "+phone+" "+address);
			}while(rs.next());
		}else {
			System.out.println(">> 주소록 친구없다~~~");
		}
		rs.close();
		stmt.close();
		con.close();

	}
	
	
	
	
	
}
