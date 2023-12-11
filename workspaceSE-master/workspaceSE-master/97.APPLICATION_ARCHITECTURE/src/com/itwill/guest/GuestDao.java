package com.itwill.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itwill.common.DataSource;

/*
 * Dao(Data[DataBase] Access Object)객체(클래스)
 *   - guest테이블에 CRUD(Create,Read,Update,Delet)작업을 하는 
 *     단위메쏘드를 가지고있는 객체(클래스)
 */
public class GuestDao {
	private DataSource dataSource;
	public GuestDao() throws Exception{
		dataSource=new DataSource();
	}
	public int insert(Guest guest) throws Exception {
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=
				con.prepareStatement(GuestSQL.GUEST_INSERT);
		/*
		 * 파라메타세팅
		 */
		pstmt.setString(1, guest.getGuest_name());
		pstmt.setString(2, guest.getGuest_email());
		pstmt.setString(3, guest.getGuest_homepage());
		pstmt.setString(4, guest.getGuest_title());
		pstmt.setString(5, guest.getGuest_content());
		
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	public int delete(int guest_no) throws Exception {
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=
				con.prepareStatement(GuestSQL.GUEST_DELETE);
		/*
		 * 파라메타세팅
		 */
		pstmt.setInt(1, guest_no);
		
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	public int update(Guest guest) throws Exception {
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=
				con.prepareStatement(GuestSQL.GUEST_UPDATE);
		/*
		 * 파라메타세팅
		 */
		pstmt.setString(1, guest.getGuest_name());
		pstmt.setString(2, guest.getGuest_email());
		pstmt.setString(3, guest.getGuest_homepage());
		pstmt.setString(4, guest.getGuest_title());
		pstmt.setString(5, guest.getGuest_content());
		pstmt.setInt(6, guest.getGuest_no());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	public Guest findByPrimaryKey(int guest_no) throws Exception {
		Guest findGuest=null;
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(GuestSQL.GUEST_SELECT_BY_NO);
		/*
		 * 파라메타셋팅
		 */
		pstmt.setInt(1, guest_no);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			findGuest=
					new Guest(rs.getInt("guest_no"),
							  rs.getString("guest_name"),
							  rs.getDate("guest_date"),
							  rs.getString("guest_email"),
							  rs.getString("guest_homepage"),
							  rs.getString("guest_title"), 
							  rs.getString("guest_content"));
		}
		
		return findGuest;
	}
	public List<Guest> findAll() throws Exception{
		List<Guest> guestList=new ArrayList<Guest>();
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(GuestSQL.GUEST_SELECT_ALL);
		/*
		 * 파라메타셋팅
		 */
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			Guest guest=
					new Guest(rs.getInt("guest_no"),
							  rs.getString("guest_name"),
							  rs.getDate("guest_date"),
							  rs.getString("guest_email"),
							  rs.getString("guest_homepage"),
							  rs.getString("guest_title"), 
							  rs.getString("guest_content"));
			guestList.add(guest);
		}
		
		return guestList;
	}
	public List<Guest> findByGuestName(String name) throws Exception{
		List<Guest> guestList=new ArrayList<Guest>();
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(GuestSQL.GUEST_SELECT_BY_NAME);
		/*
		 * 파라메타셋팅
		 */
		pstmt.setString(1, name);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			Guest guest=
					new Guest(rs.getInt("guest_no"),
							  rs.getString("guest_name"),
							  rs.getDate("guest_date"),
							  rs.getString("guest_email"),
							  rs.getString("guest_homepage"),
							  rs.getString("guest_title"), 
							  rs.getString("guest_content"));
			guestList.add(guest);
		}
		
		return guestList;
	}
	
	
}













