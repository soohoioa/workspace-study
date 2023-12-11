package com.itwill.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.itwill.BoardSpringJpaThymeleafPagingApplicationTests;
import com.itwill.board.dto.BoardListPageDto;

class BoardServiceTest  extends BoardSpringJpaThymeleafPagingApplicationTests{
	@Autowired
	BoardService boardService;
	
	@Test
	//@Disabled
	void board_select_page() throws Exception {
		int currentPage=3;	//현재페이지
		int size=10;		//페이지당게시물수
		/*
		PageRequest.of(page, size)
			- page zero-based page index.(요청페이지)
			- size the size of the page to be returned.(페이지당 게시물 수)
		 */
		Pageable pageable=PageRequest.of(currentPage-1,
										size,
										Sort.by("groupno").descending()
										.and(Sort.by("step").ascending())
										);
		
		/*
		BoardListPageDto boardListPage=boardService.findBoardList(pageable);
		for (Board board : boardListPage.getItemList()) {
			System.out.println(board);
		}*/
		
		
		
	}
	void board_select_page2() throws Exception {
		int currentPage=3;	//현재페이지
		int size=10;		//페이지당게시물수
		/*
		PageRequest.of(page, size)
			- page zero-based page index.(요청페이지)
			- size the size of the page to be returned.(페이지당 게시물 수)
		 */
		Pageable pageable=PageRequest.of(currentPage-1,
				size,
				Sort.by("groupno").descending()
				.and(Sort.by("step").ascending())
				);
		
		Page<Board> boardListPage=boardService.findBoardList(pageable);
		
		for (Board board : boardListPage.getContent()) {
			System.out.println(board);
		}
		
		
		
	}
	
}
