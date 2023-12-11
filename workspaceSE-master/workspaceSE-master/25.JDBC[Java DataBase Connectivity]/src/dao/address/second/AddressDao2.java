package dao.address.second;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 DAO (Data Access Object) 클래스 : 데이터베이스클래스
 	- address 테이블에 CRUD (Create, Read, Update, Delete) 작업을 하는 단위 메소드를 가지고 있는 클래스
 */

public class AddressDao2 {
	
	/*
	 데이터베이스 설정정보를 이용해서 Connection 객체를 생성해서 반환하는 역할을 하는 메소드
	 */
	public Connection getConnection() throws Exception {
		/*******데이타베이스 접속정보[182.237.126.19]************/ 	// 공통으로 들어가서 멤버로 빼줌
		String driverClass = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@182.237.126.19:1521:xe";
		String user = "jdeveloper03";
		String password = "jdeveloper03";
		/********************************************************/
		
		Class.forName(driverClass);
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}
	
	/*
	 Connection 객체를 생성하고 지우는 작업이 많아질수록 속도느려지고 비용도 많이 들어간다. 물론 돈이 많으면 한개씩 작업해서 사용해도 됨ㅋ
	 그래서 Connection 은 예를들어 적은 수(2~3)로 100개의 DAO 와 공유해야한다. -> 적은 수의 Connection 으로 더 많은 메소드를 처리하기 위해서
	 Connection 객체를 미리 생성해서 클래스로 만들고 필요하거나 사용할때마다 주고 다시 받납받는다.
	 */
	
	
	/*
	 Connection 객체를 close 하는 메소드(??)
	 */
	public void close(Connection con) throws Exception {
		con.close(); // 커넥션릴리즈 라고도 씀
	}
	/*
	기반 메소드. 반드시 있어야하는 메소드. 
	public Connection getConnection() throws Exception { }
	public void close(Connection con) throws Exception { }
	*/
	
	public void insert(String name, String phone, String address) throws Exception {
		String insertsql = "insert into address values(address_no_seq.nextval, '"+name+"', '"+phone+"', '"+address+"')";
				// 시퀀스(sequence)는 순서에 따라 나열되는 정수의 목록이라고 정의할 수 있다. 또 유일한 값을 생성해주는 오라클의 객체다. 줄수도 안줄수도있다
				// nextval :자기가 알아서 증가시키겠다. 여기서는 address 클래스 내 no 를 순차적으로 증가시키겠다.
		Connection con = this.getConnection();
		Statement stmt = con.createStatement();
		int rowCount = stmt.executeUpdate(insertsql);
		
		System.out.println(" >> insert row count : " + rowCount);	
		
		stmt.close();
		this.close(con);
	}
	// 데이터베이스 모델링 -> dao작성
	public void updateByPrimaryKey(int no, String name, String phone, String address) throws Exception { // 기본적으로 pkUpdate pkDalete
		String updateSql = "update address set name = ? , phone = ? , address = ? where no = ? ";
		// 업데이트는 모든 컬럼이 다 필요하지만 물론 수정이 불가능한 컬럼도 있음. 하지만 대부분 전체 다 수정함
		// 외워랍! 업데이트는 pk조건으로 모든 필드를 업데이트 왜? 어떤걸 업데이트할지 모르니까.
		Connection con = this.getConnection();
		PreparedStatement pstmt = con.prepareStatement(updateSql);
		pstmt.setString(1, name);
		pstmt.setString(2, phone);
		pstmt.setString(3, address);
		pstmt.setInt(4, no);
		int rowCount = pstmt.executeUpdate();
		
		System.out.println(" >> update row count : " + rowCount);	
		
		pstmt.close();
		this.close(con);
	}
	
	public void deleteByPrimaryKey(int no) throws Exception {
		String deleteSql = "delete from address where no = ?";
		
		Connection con = this.getConnection();
		PreparedStatement pstmt = con.prepareStatement(deleteSql);
		pstmt.setInt(1, no);
		int rowCount = pstmt.executeUpdate();
		
		System.out.println(" >> delete row count : " + rowCount);

		pstmt.close();
		this.close(con);
	}
	
	public void findByPrimaryKey(int no) throws Exception { // selectByNo 도 no 가 pk 라면 가능.
		String selectSql = "select no, name, phone, address from address where no = ?";
		
		Connection con = this.getConnection();
		PreparedStatement pstmt = con.prepareStatement(selectSql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();		

		if(rs.next()) {
				int number = rs.getInt("no");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				System.out.println(number +" "+ name +" "+ phone +" "+ address);
		}else {
			System.out.println(">> 주소록 친구없다~~~");
		}
		rs.close();
		pstmt.close();
		this.close(con);
	}
	
	public void findAll() throws Exception { // selectByPrimaryKey 라고도 작성하지만 대부분 find 를 붙여서 사용함
		// findAll() 은 파라메타가 없어서 안해도 됨.
		// 주로 검색할때 사용
		String selectSql = "select no, name, phone, address from address order by no";
		
		Connection con = this.getConnection();
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
		this.close(con);

	}
	// close 작업시 먼저 시작한 객체가 제일 마지막에 닫혀야한다. 여기서는 con 이 먼저 시작하고 rs가 마지막에 실행되었으므로
	// rs가 먼저 닫히고 마지막으로 con 을 닫아준다
	
	
	/*
	단위메소드로 조합한다 - 실제 업무 구현
	하나하나 분리해서 내가 원하는형체로 만든다 -> 하나의 메소드가 하나의 일만 해야한다
	
	*/
	
	
	
	
	
}
