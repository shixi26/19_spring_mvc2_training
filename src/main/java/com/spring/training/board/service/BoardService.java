package com.spring.training.board.service;

import java.util.List;

import com.spring.training.board.dto.BoardDto;

public interface BoardService {
	
	public void insertBoard(BoardDto bdto) throws Exception;
	public List<BoardDto> getBoardList() throws Exception;
	public BoardDto getOneBoard(int num) throws Exception;
	public boolean updateBoard(BoardDto bdto) throws Exception;
	
	public boolean deleteBoard(BoardDto bdto) throws Exception;
	
}
