package com.spring.training.board_advance.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.training.board_advance.dao.BoardAdvanceDao;
import com.spring.training.board_advance.dto.BoardAdvanceDto;

@Service		
public class BoardAdvanceServiceImpl implements BoardAdvanceService {

	@Inject				
	private BoardAdvanceDao boardAdvanceDao;

	@Override
	public List<BoardAdvanceDto> getSearchBoard(Map<String, Object> searchInfo) throws Exception{
		return boardAdvanceDao.getSearchBoard(searchInfo);
	}
	 
	
	@Override
	public BoardAdvanceDto getOneBoard(int num) throws Exception{
		boardAdvanceDao.increaseReadCount(num);
		return boardAdvanceDao.getOneBoard(num);
	}
	
	
	@Override
	public void insertBoard(BoardAdvanceDto bdto) throws Exception {
		boardAdvanceDao.insertBoard(bdto);
	}
	
	
	@Override
	public boolean updateBoard(BoardAdvanceDto bdto) throws Exception {
		boolean isSuccess = false;
		if (boardAdvanceDao.validateUserCheck(bdto) != null) {
			isSuccess = true;
			boardAdvanceDao.updateBoard(bdto);
		}
		return isSuccess;
	}

	
	@Override
	public boolean deleteBoard(BoardAdvanceDto bdto) throws Exception {
		boolean isSuccess = false;
		if (boardAdvanceDao.validateUserCheck(bdto) != null) {
			boardAdvanceDao.deleteBoard(bdto.getNum());
			isSuccess = true;
		}
		return isSuccess;
	}

	
	@Override
	public void makeDummyData() throws Exception {
		
		Random ran = new Random();
		
		List<BoardAdvanceDto> dummyDataList = new ArrayList<BoardAdvanceDto>();
	
		String[] word = {"가","나","다","라","마","바","사","아","자","차","카","타","파","하"};
		
		BoardAdvanceDto temp = null;
		String writer;
		String password;
		String subject;
		String email;
		String content;
		
		for (int i = 700; i < 900; i++) { // 테스트용 index
			
			writer    = "";
			password  = "1111";
			subject   = "";
			email     = "";
			content   = "";
			for (int j = 0; j < 7; j++) {
				writer  += word[ran.nextInt(word.length)];
				subject += word[ran.nextInt(word.length)];
				content += word[ran.nextInt(word.length)];
				if (j < 4) {
					email += word[ran.nextInt(word.length)];
				}
			}
			email += "@gmail.com";
			
			temp = new BoardAdvanceDto();
			temp.setNum(i);		
			temp.setWriter(writer);
			temp.setEmail(email);
			temp.setSubject(subject);
			temp.setPassword(password);
			temp.setRef(i);
			temp.setReLevel(1);
			temp.setReStep(1);
			temp.setReadCount(0);
			temp.setContent(content);
			
			dummyDataList.add(temp);
			
		}
		
		boardAdvanceDao.makeDummyData(dummyDataList);
		
	}

	
	@Override
	public int getAllBoardCount(Map<String, String> searchCountInfo) throws Exception {
		return boardAdvanceDao.getAllBoardCount(searchCountInfo);
	}

	
	@Override
	public void insertReplyBoard(BoardAdvanceDto bdto) throws Exception {
		boardAdvanceDao.updateBoardReplyStep(bdto);
		boardAdvanceDao.insertReplyBoard(bdto);
	}
	
}
