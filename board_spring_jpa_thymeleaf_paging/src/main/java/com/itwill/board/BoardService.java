package com.itwill.board;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
@Service
public class BoardService {
	@Autowired
	private BoardDao boardDao;
	/*
	 * 게시물삭제
	 */
	public int remove(Long boardno) throws Exception,BoardException{
		Board tempBoard=boardDao.findBoard(boardno);
		boolean rExist=boardDao.countReplay(tempBoard);
		System.out.println("답글존재여부:"+rExist);
		if(boardDao.countReplay(tempBoard)){
			//답글존재
			throw new BoardException("답글이 있는 게시글은 삭제앙돼요!!");
		}else{
			//답글안존재
			return boardDao.remove(tempBoard.getBoardno());
		}
	
	}
	/*
	 * 게시물생성
	 */
	public Board create(Board board)throws Exception{
		return  boardDao.create(board);
	}
	/*
	 * 답글쓰기
	 */
	public Board createReplay(Board board) throws Exception{
		return boardDao.createReply(board);
	}
	/*
	 * 게시물 1개
	 */
	public Board findBoard(Long boardNo)throws Exception{
		Board board=boardDao.findBoard(boardNo);
		return board;
	}
	public void updateHitCount(Long boardNo) throws Exception{
		boardDao.increaseReadCount(boardNo);
	}
	
	public Page<Board> findBoardList(Pageable pageable) throws Exception{
		//3.게시물데이타 얻기
		Page<Board> boardListPage=
				boardDao.findBoardList(pageable);
		return boardListPage;
	}
	
	public Page<Board> findBoardList(Pageable pageable,String serchKeyword,
									 String searchType) throws Exception{
		//게시물검색데이타 얻기
		Specification<Board> specification=null;
		if(searchType!=null) {
            switch (searchType) {
                case "title":    
                	specification=BoardSpecification.containingTitle(serchKeyword);
                    break;
                case "content": 
                	specification=BoardSpecification.containingContent(serchKeyword);
                    break;
                case "writer": 
                	specification=BoardSpecification.startsWithWriter(serchKeyword);
                    break;
                default:
                	specification=BoardSpecification.findAll(0L);
            }
        }
		System.out.println(specification);
		System.out.println(">>>>>>>>"+searchType);
		Page<Board> boardListPage=
				boardDao.findBoardList(specification,pageable);
		return boardListPage;
	}
	
	

	/*
	 * 게시물수정
	 */
	public Board update(Board board) throws Exception {
		return boardDao.update(board);
	}
	
}
