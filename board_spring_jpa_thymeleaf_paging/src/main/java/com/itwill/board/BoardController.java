package com.itwill.board;

import java.time.LocalDate;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.board.dto.BoardListPageDto;

import io.swagger.v3.oas.annotations.Parameter;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;

	@GetMapping("/board_main")
	public String board_main() {
		return "board_main";
	}

	@GetMapping("api/board/list1")
	@ResponseBody
	public Page<Board> api_board_list1(
			@ParameterObject @PageableDefault(page = 0, size = 5) @SortDefault.SortDefaults({
					@SortDefault(sort = "groupno", direction = Direction.DESC),
					@SortDefault(sort = "step", direction = Direction.ASC), }) Pageable pageable) throws Exception {
		Page<Board> boardListPage = boardService.findBoardList(pageable);

		return boardListPage;
	}

	@GetMapping("api/board/list2")
	@ResponseBody
	public BoardListPageDto api_board_list2(
			@ParameterObject @PageableDefault(page = 0, size = 5) @SortDefault.SortDefaults({
					@SortDefault(sort = "groupno", direction = Direction.DESC),
					@SortDefault(sort = "step", direction = Direction.ASC), }) Pageable pageable) throws Exception {
		
		Page<Board> boardListPage = boardService.findBoardList(pageable);
		int blockSize=5;
		BoardListPageDto boardListPageDto = new BoardListPageDto(boardListPage, blockSize);
		return boardListPageDto;
	}
	@ResponseBody
	@GetMapping("api/board/list3")
	public BoardListPageDto api_board_list3( @RequestParam(name="searchKeyword",required = false,defaultValue = "") String searchKeyword,
									    	 @RequestParam(name="searchType",defaultValue = "none") String searchType,
									    	 @Parameter(hidden = true) @PageableDefault(page = 1, size = 5) Pageable p) throws Exception {
		System.out.println(searchKeyword+"--"+searchType);
		
		int page = p.getPageNumber();
		int size = p.getPageSize();
		int blockSize = 5;
		Pageable pageable = PageRequest.of(page - 1, size,
				Sort.by("groupno").descending().and(Sort.by("step").ascending()));
		Page<Board> boardListPage=boardService.findBoardList(pageable,searchKeyword, searchType);
		BoardListPageDto boardListPageDto = new BoardListPageDto(boardListPage, blockSize,searchKeyword,searchType);
		return boardListPageDto;
	}
	@GetMapping("/board_list1")
	public String board_list1(@PageableDefault(page = 1, size = 5) Pageable p, Model model) throws Exception {
		int page = p.getPageNumber();
		int size = p.getPageSize();

		Pageable pageable = PageRequest.of(page - 1, size,
				Sort.by("groupno").descending().and(Sort.by("step").ascending()));

		Page<Board> boardListPage = boardService.findBoardList(pageable);

		model.addAttribute("boardListPage", boardListPage);
		return "board_list1";
	}
	@GetMapping("/board_list2")
	public String board_list2(@PageableDefault(page = 1, size = 5) Pageable p, Model model) throws Exception {
		int page = p.getPageNumber();
		int size = p.getPageSize();
		int blockSize = 5;
		Pageable pageable = PageRequest.of(page - 1, size,
				Sort.by("groupno").descending().and(Sort.by("step").ascending()));

		Page<Board> boardListPage = boardService.findBoardList(pageable);
		BoardListPageDto boardListPageDto = new BoardListPageDto(boardListPage, blockSize);
		model.addAttribute("boardListPageDto", boardListPageDto);
		return "board_list2";
	}
	
	
	@GetMapping("board_list3")
	public String board_list3(  @RequestParam(name="searchKeyword",required = false,defaultValue = "") String searchKeyword,
								@RequestParam(name="searchType",required = false,defaultValue ="none") String searchType,
								@Parameter(hidden = true) @PageableDefault(page = 1, size = 5) Pageable p,Model model) throws Exception {
		int page = p.getPageNumber();
		int size = p.getPageSize();
		int blockSize = 5;
		Pageable pageable = PageRequest.of(page - 1, size,
				Sort.by("groupno").descending().and(Sort.by("step").ascending()));
		Page<Board> boardListPage=boardService.findBoardList(pageable,searchKeyword, searchType);
		BoardListPageDto boardListPageDto = new BoardListPageDto(boardListPage, blockSize,searchKeyword,searchType);
		model.addAttribute("boardListPageDto", boardListPageDto);
		return "board_list3";
	}
	@GetMapping("board_list4")
	public String board_list4(@PageableDefault(page = 1, size =5) Pageable p,Model model) throws Exception {
		int page = p.getPageNumber();
		int size = p.getPageSize();
		int blockSize = 5;
		Pageable pageable = PageRequest.of(page - 1, size,
				Sort.by("groupno").descending().and(Sort.by("step").ascending()));
		Page<Board> boardListPage=boardService.findBoardList(pageable);
		model.addAttribute("boardListPage", boardListPage);
		return "board_list4";
	}
	

}
