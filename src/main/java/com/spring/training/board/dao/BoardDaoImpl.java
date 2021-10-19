package com.spring.training.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.training.board.dto.BoardDto;

@Repository // Data Access Object(DAO)는 @Repository를 명시하여야 한다.
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert(BoardDto bdto) throws Exception {  // insert("mapper파일의 namespace명.id명" , 매개변수명);
		sqlSession.insert("com.spring.mapper.BoardMapper.insertBoard" , bdto);
	}

	@Override
	public List<BoardDto> selectAll() throws Exception {
		// selectList : 반환데이터가 1개 이상
		// selectOne  : 반환데이터가 1개 
		return sqlSession.selectList("com.spring.mapper.BoardMapper.getAllBoard");
	}

	@Override
	public BoardDto selectOne(int num) throws Exception {
		return sqlSession.selectOne("com.spring.mapper.BoardMapper.getOneBoard" , num);
	}

	@Override
	public BoardDto validateUserCheck(BoardDto bdto) throws Exception {
		return sqlSession.selectOne("com.spring.mapper.BoardMapper.validateUserCheck" , bdto);
	}

	@Override
	public void update(BoardDto bdto) throws Exception {
		sqlSession.update("com.spring.mapper.BoardMapper.updateBoard" , bdto);
	}

	@Override
	public void increaseReadCount(int num) throws Exception {
		sqlSession.update("com.spring.mapper.BoardMapper.increaseReadCount", num);
	}
	
	@Override
	public void delete(int num) throws Exception{
		sqlSession.delete("com.spring.mapper.BoardMapper.deleteBoard",num);
	}

}



