package dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.common.DataSource;

/*
 * Dao(Data[DataBase] Access Object)객체
 * 		- member(회원) 데이타를 저장하고있는 테이블에
 *        CRUD(Create,Read,Update,Delete)작업을 할수있는 
 *        단위메쏘드를 가지고있는 클래스
 */
public class MemberDao {
	/*
	 * Dao 객체는멤버변수로 Connection을 생성하는 DataSource객체를 가짐
	 */
	private DataSource dataSource;
	
	public MemberDao() throws Exception {
		this.dataSource = new DataSource();
	}
	
	
	public int deleteByMemberId(String memberId) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_DELETE);
		
		pstmt.setString(1, memberId);
		
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		
		return rowCount;
	}
	
	
	public int insert(Member member) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_INSERT);
		
		pstmt.setString(1, member.getM_id());
		pstmt.setString(2, member.getM_password());
		pstmt.setString(3, member.getM_name());
		pstmt.setString(4, member.getM_address());
		pstmt.setInt(5, member.getM_age());
		pstmt.setString(6, member.getM_married());
								
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		
		return rowCount;
	}
	
	public int updateByMemberId(Member member) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_UPDATE);
		
		pstmt.setString(1, member.getM_password());
		pstmt.setString(2, member.getM_name());
		pstmt.setString(3, member.getM_address());
		pstmt.setInt(4, member.getM_age());
		pstmt.setString(5, member.getM_married());
		pstmt.setString(6, member.getM_id());
		
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		
		return rowCount;
	}
	
	
	public Member selectById(String memberId) throws Exception {
		Member member = null;
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_SELECT_BY_ID);
		pstmt.setString(1, memberId);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			member = new Member(rs.getString("m_id"), rs.getString("m_password"), rs.getString("m_name"), 
					rs.getString("m_address"), rs.getInt("m_age"), 
					rs.getString("m_married"), rs.getDate("m_regdate"));
		}
		
		rs.close();
		pstmt.close();
		dataSource.close(con);
		
		return member;
	}
	
	
	public List<Member> selectAll() throws Exception {
		List<Member> memberList = new ArrayList<Member>();
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(MemberSQL.MEMBER_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			memberList.add(new Member(rs.getString("m_id"), rs.getString("m_password"), rs.getString("m_name"), 
					rs.getString("m_address"), rs.getInt("m_age"), 
					rs.getString("m_married"), rs.getDate("m_regdate")
					)
				);
		}
		
		rs.close();
		pstmt.close();
		dataSource.close(con);
		
		return memberList;
		
	}
	
	
	
}
