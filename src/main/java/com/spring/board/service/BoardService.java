package com.spring.board.service;

import java.util.List;

import com.spring.board.dto.BoardDto;

public interface BoardService {
	
	public void insertBoard(BoardDto bdto) throws Exception;
	public List<BoardDto> getBoardList() throws Exception;
	public BoardDto getOneBoard(int num) throws Exception;
	public boolean updateBoard(BoardDto bdto) throws Exception;
	
}
