package com.sbt.web.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.sbt.web.dto.Board;

@MapperScan
public interface BoardMapper {
	
	public int insertBoardWrite(Board board) throws Exception;
	
	public int updateGroupNumber(Board board) throws Exception;

	public int updateModify(Board board) throws Exception;
	
	public int selectKey() throws Exception;
	
	public int procBoardWrite(Board board) throws Exception;

	public Board procBoardModifiy(Board board) throws Exception;
	
	public List<Board> listBoard() throws Exception;
	
	public Board selectDetail(Board board) throws Exception;
	
	public int deleteBoard(int articleNumber) throws Exception;
	
}
