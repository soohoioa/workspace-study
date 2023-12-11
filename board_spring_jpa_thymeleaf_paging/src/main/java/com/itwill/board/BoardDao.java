package com.itwill.board;



import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface BoardDao {

	/**
	 * 새로운 게시물을 추가하는 메써드.
	 * @throws Exception 
	 */
	Board create(Board board) throws Exception;

	/**
	 * 답글 게시물을 추가하는 메써드
	 */
	Board createReply(Board board) throws Exception;
	
	/**
	 * 게시물 리스트를 반환(게시물시작번호,게시물끝번호)
	 */
	Page<Board> findBoardList(Pageable pageable) throws Exception;
	/**
	 * 게시물 검색리스트를 반환(게시물시작번호,게시물끝번호)
	 */
	Page<Board> findBoardList(Specification<Board> specification, Pageable pageable) throws Exception;
		
	
	/*
	 * 
	 * 
	 */
	/**
	 * 답변게시물 존재여부확인메쏘드
	 */
	boolean countReplay(Board board) throws SQLException;

	/**
	 * 게시물을 삭제하는 메써드.
	 */
	int remove(Long boardNo) throws Exception;

	/**
	 * 게시물내용을 수정하는 메써드.
	 */
	Board update(Board board) throws Exception;

	/**
	 * 게시물 번호에 해당하는 게시물 정보를 반환하는 메써드.
	 */
	Board findBoard(Long boardNo) throws Exception;

	/**
	 * 게시물 조회수를 1 증가.
	 */
	void increaseReadCount(Long boardNo) throws Exception;

	/**
	 * 게시물 총 건수를 조회, 반환
	 */
	
	Long getBoardCount() throws Exception;

}