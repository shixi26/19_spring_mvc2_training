package com.spring.training.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.training.board.dao.BoardDao;
import com.spring.training.board.dto.BoardDto;

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
		boardDao.increaseReadCount(num);
		return boardDao.selectOne(num);
	}

	@Override
	public boolean updateBoard(BoardDto bdto) throws Exception {
		
		boolean isSucceed = false; 
		
		if (boardDao.validateUserCheck(bdto) != null) {
			boardDao.update(bdto);
			isSucceed = true;
		}
		
		return isSucceed;
		
	}

	@Override
	public boolean deleteBoard(BoardDto bdto) throws Exception {
		
		boolean isSucceed = false;
		
		if (boardDao.validateUserCheck(bdto) != null) {
			boardDao.delete(bdto.getNum());
			isSucceed = true;
		}
		
		return isSucceed;
		
	}
	
}



