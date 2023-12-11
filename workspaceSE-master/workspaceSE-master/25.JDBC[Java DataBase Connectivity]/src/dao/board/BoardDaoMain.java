package dao.board;

import dao.address.Address;

public class BoardDaoMain {

	public static void main(String[] args) throws Exception{
		BoardDao boardDao = new BoardDao();
		
		System.out.println("1. INSERT : " + boardDao.insert(new Board(1, "제목3", "내용1", "yyyy/MM/dd", 1))); 
		
		Board findBoard = boardDao.selectByBoardNo(2);
		findBoard.setTitle("변경제목1");
		findBoard.setContent("변경내용이지롱1");
		findBoard.setNo(2);
		
		System.out.println("2. UPDATE : " + boardDao.updateByBoardNo(findBoard));
		
		System.out.println("3. SELECT : " + boardDao.selectByBoardNo(8));
		
		System.out.println("4. selectAll : " + boardDao.selectAll());
		
	}

}