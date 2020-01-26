package com.sbt.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbt.web.dto.Board;
import com.sbt.web.mapper.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	BoardMapper boardMapper;
	
	public int procBoardWrite(Board board) throws Exception {
		int result = 0;
		
		boardMapper.insertBoardWrite(board);
		int key = boardMapper.selectKey();
		
		board.setArticleNumber(key);
		board.setGroupNumber(key);
		
		result = boardMapper.updateGroupNumber(board);
		
		return result;
	}
	
	public List<Board> listBoard() throws Exception {
		
		List<Board> list = boardMapper.listBoard();
		
		return list;
	}
}
