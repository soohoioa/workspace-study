package dao.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.common.DataSource;

/*
 * Dao(Data[DataBase] Access Object)객체(클래스)
 *   - guest테이블에 CRUD(Create,Read,Update,Delet)작업을 하는 
 *     단위메쏘드를 가지고있는 객체(클래스)
 */
public class GuestDao {
	/*
	 * Connection 생성 해지 객체
	 */
	private DataSource dataSource;
	
	public GuestDao() throws Exception {
		this.dataSource = new DataSource();
	}
	
	
	// 가독성좋게 pk적고컬럼명
	// GuestSQL 에서 작성하고 여기에 땡겨씀. GuestSQL 으로 sql을 따로 작성하면 코드는 간단해지지만 클래스는 많아짐.ㅋ
	
	public int insert(Guest guest) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_INSERT);
		pstmt.setString(1, guest.getGuestName());
		pstmt.setString(2, guest.getGuestEmail());
		pstmt.setString(3, guest.getGuestHomepage());
		pstmt.setString(4, guest.getGuestTitle());
		pstmt.setString(5, guest.getGuestContent());
		
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		
		return rowCount;
	} // 일반화 시켜서 이야기하면 dto / insert 는 무조건 dto
	
	
	
	public int deleteByGuestNo(int guestNo) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_DELETE);
		pstmt.setInt(1, guestNo);
		
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);

		return rowCount;
	}
	
	
	
	public int updateByGuestNo(Guest guest) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_UPDATE);
		pstmt.setString(1, guest.getGuestName());
		pstmt.setString(2, guest.getGuestEmail());
		pstmt.setString(3, guest.getGuestHomepage());
		pstmt.setString(4, guest.getGuestTitle());
		pstmt.setString(5, guest.getGuestContent());
		pstmt.setInt(6, guest.getGuestNo()); 
		// 한개가 부족한 이유는 date 는 수정을 안하기때문이다.
		
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);

		return rowCount;
	}
	
	
	
	public Guest findByGuestNo(int guestNo) throws Exception {
		Guest guest = null; // 반환객체초기화

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_SELECT_BY_NO);
		pstmt.setInt(1, guestNo);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) { 
			guest = new Guest(rs.getInt("guest_no"), rs.getString("guest_name"), rs.getDate("guest_date"), 
					rs.getString("guest_email"), rs.getString("guest_homepage"), 
					rs.getString("guest_title"), rs.getString("guest_content"));
		}
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return guest; // 반환해라
	}
	
	
	
	public List<Guest> findByAll() throws Exception { // dto 컬렉션 사용 ArrayList<Guest>
		
		List<Guest> guestList = new ArrayList<Guest>();
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			guestList.add( new Guest(rs.getInt("guest_no"), rs.getString("guest_name"), rs.getDate("guest_date"), 
							rs.getString("guest_email"), rs.getString("guest_homepage"), 
							rs.getString("guest_title"), rs.getString("guest_content")
							)
					);
		} 
				
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return guestList;
	}
	
	
	// Connection 을 닫으면 prepareStatement 도 자동으로 닫히지만 되도록이면 다 닫아주는게 좋다.
	// 단, 모두 사용했을때 닫아줘야한다. 미리 닫으면 안되용

	
}
