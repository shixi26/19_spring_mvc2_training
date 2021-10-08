package com.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.dao.BoardDao;
import com.spring.board.dto.BoardDto;

@Service // 서비스(비즈니스로직)은 @Service를 명시하여야 한다.
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public void insertBoard(BoardDto bdto) throws Exception {
		boardDao.insert(bdto);
	}

	@Override
	public List<BoardDto> getBoardList() throws Exception {
		return boardDao.selectAll();
	}

	@Override
	public BoardDto getOneBoard(int num) throws Exception {
		return boardDao.selectOne(num);
	}

	@Override
	public boolean updateBoard(BoardDto bdto) throws Exception {
		
		boolean isSucceed = false;
		
		if(boardDao.validateUserCheck(bdto) != null) {
		   boardDao.update(bdto);
		   isSucceed = true;
		}; // db조회해서 null이아니면 update실행
		
		return isSucceed;
	}

}



