package com.itwill.board;

import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;




/*
 * 자료실 게시판에서 데이터베이스의 접근을 전담하는 클래스. 
 * BOARD 테이블과의 접근을 담당한다.
 */
@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private BoardRepository boardRepository;
	/**
	 * 새로운 게시물을 추가하는 메써드.
	 * 
	 * @throws Exception
	 */
	@Override
	public Board create(Board board) throws Exception {
		return boardRepository.save(board);
	}
	
	/**
	 * 답글 게시물을 추가하는 메써드
	 */
	@Override
	public Board createReply(Board board) throws Exception {
		return boardRepository.save(board);

	}

	/**
	 * 게시물 리스트를 반환(게시물시작번호,게시물끝번호)
	 */
	@Override
	public Page<Board> findBoardList(Pageable pageable) throws Exception {
		return boardRepository.findAll(pageable);
	}
	@Override
	public Page<Board> findBoardList(Specification<Board> specification, Pageable pageable) throws Exception {
		return boardRepository.findAll(specification,pageable);
	}
	/*
	@Override
	public Page<Board> findByTitleContaining(String title,Pageable pageable) throws Exception {
		return boardRepository.findByTitleContaining(title,pageable);
	}
	@Override
	public Page<Board> findByContentContaining(String content,Pageable pageable) throws Exception {
		return boardRepository.findByContentContaining(content,pageable);
	}
	public Page<Board> findByWriterStartsWith(String writer,Pageable pageable) throws Exception{
		return boardRepository.findByWriterStartsWith(writer, pageable);
	}
	public Page<Board> findByRegdateGreaterThanEqual(LocalDate regDate,Pageable pageable) throws Exception{
		return boardRepository.findByRegdateGreaterThanEqual(regDate, pageable);
	}
	*/

	/**
	 * 답변게시물 존재여부확인메쏘드
	 */
	@Override
	public boolean countReplay(Board board) throws SQLException {
		return boardRepository.existsByGroupnoAndDepthGreaterThanEqualAndStepGreaterThanEqualOrderByStepAscDepthAsc(board.getGroupno(), board.getDepth(), board.getStep());
	}

	/**
	 * 게시물을 삭제하는 메써드.
	 */
	@Override
	public int remove(Long boardNo) throws Exception {
		boardRepository.deleteById(Long.valueOf(boardNo));
		return 0;

	}

	/**
	 * 게시물내용을 수정하는 메써드.
	 */
	@Override
	public Board update(Board board) throws Exception {
		return boardRepository.save(board);
	}

	/**
	 * 게시물 번호에 해당하는 게시물 정보를 반환하는 메써드.
	 */
	@Override
	public Board findBoard(Long boardNo) throws Exception {
		
		return boardRepository.findById(boardNo).get();
	}

	/**
	 * 게시물 조회수를 1 증가.
	 */
	@Override
	public void increaseReadCount(Long boardNo) throws Exception {
		Board findBoard=boardRepository.findById(boardNo).get();
		findBoard.setReadcount(findBoard.getReadcount()+1);
	}

	/**
	 * 게시물 총 건수를 조회, 반환
	 */
	@Override
	public Long getBoardCount() throws Exception {
		return boardRepository.count();
		
	}

	

}
