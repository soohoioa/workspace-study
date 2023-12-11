package com.itwill.board;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import oracle.jdbc.proxy.annotation.Post;


public interface BoardRepository extends JpaRepository<Board, Long>,JpaSpecificationExecutor<Board> {
	//Page<Board> findAll(Pageable pageable);
	Page<Board> findByTitleContaining(String title,Pageable pageable);
	Page<Board> findByContentContaining(String content,Pageable pageable);
	Page<Board> findByWriterStartsWith(String writer,Pageable pageable);
	Page<Board> findByRegdateGreaterThanEqual(LocalDate date, Pageable pageable);
	
	List<Board> findByStepGreaterThanAndGroupno(Long step,Long groupNo);
	List<Board> findByBoardnoGreaterThanEqualOrderByGroupnoDescStepAsc(Long boardNo);
	//Page<Board> findByBoardnoGreaterThanEqualOrderByGroupnoDescStepAsc(Long boardNo,Pageable pageable);
	Boolean existsByGroupnoAndDepthGreaterThanEqualAndStepGreaterThanEqualOrderByStepAscDepthAsc(Long groupNo,Long depth,Long step);
}

