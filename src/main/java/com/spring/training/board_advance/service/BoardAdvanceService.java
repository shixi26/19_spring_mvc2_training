package com.spring.training.board_advance.service;

import java.util.List;
import java.util.Map;

import com.spring.training.board_advance.dto.BoardAdvanceDto;

public interface BoardAdvanceService {
	
	//게시글 조회
	public List<BoardAdvanceDto> getSearchBoard(Map<String, Object> searchInfo) throws Exception;
	//게시글 수 조회
	public int getAllBoardCount(Map<String, String> searchCountInfo) throws Exception;
	// 하나의 게시글 조회
	public BoardAdvanceDto getOneBoard(int num) throws Exception;
	// 게시글 저장
	public void insertBoard(BoardAdvanceDto bdto) throws Exception;
	// 대댓 저장
	public void insertReplyBoard(BoardAdvanceDto bdto) throws Exception;
	// 하나의 게시글 수정
	public boolean updateBoard(BoardAdvanceDto bdto) throws Exception;
	// 게시글 삭제
	public boolean deleteBoard(BoardAdvanceDto bdto) throws Exception;
	// 데이터 생성
	public void makeDummyData() throws Exception;
	
}
