package com.spring.board.dao;

import java.util.List;

import com.spring.board.dto.BoardDto;

public interface BoardDao {

	public void insert(BoardDto bdto) throws Exception;
	public List<BoardDto> selectAll() throws Exception;
	public BoardDto selectOne(int num) throws Exception;
	public BoardDto validateUserCheck(BoardDto bdto) throws Exception; //id pw넘어감 제대로됏다면 boardto넘어가 아님,null
	public void update(BoardDto bdto) throws Exception; //리턴없음
	
}
