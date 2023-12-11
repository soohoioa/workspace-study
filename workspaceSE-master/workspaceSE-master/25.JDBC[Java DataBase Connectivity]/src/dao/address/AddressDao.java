package dao.address;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.common.DataSource;

/*
 DAO (Data Access Object) 클래스 : 데이터베이스클래스
 	- address 테이블에 CRUD (Create, Read, Update, Delete) 작업을 하는 단위 메소드를 가지고 있는 클래스
 */

public class AddressDao {
	/*
	 * DataSource 객체를 멤버필드로 가진다. (Connection 을 생성하고 해지하는 객체)
	 */
	private DataSource dateSource;
	public AddressDao() throws Exception{ // 생성자 메소드는 객체 초기화
		dateSource = new DataSource();
		
	}
	
	/********************************************************************************************************************/
	
	public int insert(Address insertAddress) throws Exception {
		String insertSql = "insert into address values(address_no_seq.nextval, ?, ?, ?)"; // ? 를 넣을때는 ' ? ' 이렇게 넣으면 에러 발생이므로 그냥 ? 만 사용한다
		Connection con = dateSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(insertSql);
		pstmt.setString(1, insertAddress.getName());
		pstmt.setString(2, insertAddress.getPhone());
		pstmt.setString(3, insertAddress.getAddress());
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dateSource.close(con);
		
		return rowCount;
	}
	
	/********************************************************************************************************************/
	
	public int updateByPrimaryKey(Address updateAddress) throws Exception {
		String updateSql = "update address set name = ? , phone = ? , address = ? where no = ? ";
		Connection con = dateSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(updateSql);
		pstmt.setString(1, updateAddress.getName());
		pstmt.setString(2, updateAddress.getPhone());
		pstmt.setString(3, updateAddress.getAddress());
		pstmt.setInt(4, updateAddress.getNo());
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dateSource.close(con);
		return rowCount;
	}
	
	/********************************************************************************************************************/
	
	public int deleteByPrimaryKey(int no) throws Exception {
		String deleteSql = "delete from address where no = ?";
		
		Connection con = dateSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(deleteSql);
		pstmt.setInt(1, no);
		int rowCount = pstmt.executeUpdate();

		pstmt.close();
		dateSource.close(con);
		return rowCount;
	}
	
	/********************************************************************************************************************/
	
	public Address findByPrimaryKey(int no) throws Exception { // selectByNo 도 no 가 pk 라면 가능.
		Address findAddress = null;
		
		String selectSql = "select no, name, phone, address from address where no = ?";
		
		Connection con = dateSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(selectSql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();		

		if(rs.next()) {
				int number = rs.getInt("no");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				findAddress = new Address(number, name, phone, address);
		}
		rs.close();
		pstmt.close();
		dateSource.close(con);
		return findAddress; // 객체가 만들어지던지 아니면 널이던지 둘중 하나
	}
	
	/********************************************************************************************************************/
	
	//  ArrayList<Address> dto리스트라고도 함
	public ArrayList<Address> findAll() throws Exception {
		// findAll() 은 파라메타가 없어서 안해도 됨. findAll() 주로 검색할때 사용
		ArrayList<Address> addressList = new ArrayList<Address>();
		
		String selectSql = "select no, name, phone, address from address order by no";
		
		Connection con = dateSource.getConnection();
		Statement stmt = con.createStatement();				
		ResultSet rs = stmt.executeQuery(selectSql);		

		while(rs.next()) {
			int no=rs.getInt("no");
			String name=rs.getString("name");
			String phone=rs.getString("phone");
			String address=rs.getString("address");
			Address tempAddress = new Address(no, name, phone, address); 
			addressList.add(tempAddress);
		}
		rs.close();
		stmt.close();
		dateSource.close(con);
		return addressList;
	}

	
}
