package dao.board;
/*
 * Dao(Data[DataBase] Access Object)객체
 * 	- board(게시판) 데이타를 저장하고있는 테이블에
 *        CRUD(Create,Read,Update,Delete)작업을 할수있는 
 *        단위메쏘드를 가지고있는 클래스
 */

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.common.DataSource;

public class BoardDao {
/*
 * insert
 * selectAll
 * selectByBoardNo
 * deleteByBoardNo
 * updateByBoardNo
 */
	private DataSource dataSource;
	public BoardDao() throws Exception {
		this.dataSource = new DataSource();
	}
	
	
	public int insert(Board insertBoard) throws Exception {
		String insertSql = "insert into board(board_no,board_title,board_content) values(board_no_seq.nextval, ?, ?)";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(insertSql);
		
		pstmt.setString(1, insertBoard.getTitle());
		pstmt.setString(2, insertBoard.getContent());
		
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		
		return rowCount;
	} 	

	
	public int updateByBoardNo(Board updateBoard) throws Exception {
		String updateSql = "update board set board_title=?, board_content=? where board_no= ?";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(updateSql);
		
		pstmt.setString(1, updateBoard.getTitle());
		pstmt.setString(2, updateBoard.getContent());
		pstmt.setInt(3, updateBoard.getNo());
		
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	
	
	public int deleteByBoardNo(Board updateBoard) throws Exception {
		String deleteSql = "delete board where board_no=?";
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(deleteSql);
		pstmt.setInt(1, updateBoard.getNo());
		
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	
	
	public Board selectByBoardNo(int no) throws Exception {
		
		Board findBoard = null;
		
		String selectSql = "select * from board where board_no=?";
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(selectSql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();	
		
		if(rs.next()) {
			int board_no = rs.getInt("board_no");
			String board_title = rs.getString("board_title");
			String board_content = rs.getString("board_content");
			Date board_wday = rs.getDate("board_wday");
			int board_read_count = rs.getInt("board_read_count");
			findBoard = new Board(board_no, board_title, board_content, board_content, board_read_count);
		}
		rs.close();
		pstmt.close();
		dataSource.close(con);
		
		return findBoard;
	}
	
	
	/*
	 * (X) rs.getDate("board_wday");
	 * (O) rs.getString("board_wday");
	 */
	
	
	public ArrayList<Board> selectAll() throws Exception {
		ArrayList<Board> boardList = new ArrayList<Board>();
		
		String selectSql = "select * from board";
		
		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();				
		ResultSet rs = stmt.executeQuery(selectSql);
		
		while(rs.next()) {
			int board_no = rs.getInt("board_no");
			String board_title = rs.getString("board_title");
			String board_content = rs.getString("board_content");
			Date board_wday = rs.getDate("board_wday");
			int board_read_count = rs.getInt("board_read_count");
			Board tempBoard = new Board(board_no, board_title, board_content, board_content, board_read_count);
			boardList.add(tempBoard);
		}
		
		rs.close();
		stmt.close();
		dataSource.close(con);
		
		return boardList;
	}

	
}