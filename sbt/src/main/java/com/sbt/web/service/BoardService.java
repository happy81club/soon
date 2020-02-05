package com.sbt.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbt.web.dto.Board;
import com.sbt.web.mapper.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	BoardMapper boardMapper;
	
	/***
	 * 원글등록
	 * @param board
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public int procBoardWrite(Board board) throws Exception {
		int result = 0;
		
		boardMapper.insertBoardWrite(board);
		int key = boardMapper.selectKey();
		
		board.setArticleNumber(key);
		board.setGroupNumber(key);
		
		result = boardMapper.updateGroupNumber(board);
		
		return result;
	}
	
	/***
	 * 댓글등록
	 * @param board
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public int procBoardComment(Board board) throws Exception {
		int result = 0;
		// 게시글 답글 순서 수정
		boardMapper.updateCommentGroupOrder(board);
        // 게시글 답글 등록
		result = boardMapper.insertComment(board);
		
		return result;
	}
	
	
	public Board procBoardModifiy(Board board) throws Exception {
		
		boardMapper.updateModify(board);
		
		Board result = boardMapper.selectDetail(board);
		
		return result;
	}
	
	public List<Board> listBoard(Board board) throws Exception {
		
		List<Board> list = boardMapper.listBoard(board);
		
		return list;
	}

	public List<Board> listCommnets(Board board) throws Exception {
		
		List<Board> list = boardMapper.listCommnets(board);
		
		return list;
	}
	
	public Board selectDetail(Board board) throws Exception {
		
		Board result =  boardMapper.selectDetail(board);
				
		return result;
	}
	
	public int deleteBoard(int articleNumber) throws Exception {
		return boardMapper.deleteBoard(articleNumber);
	}
	
	public int getNoticeBoardCount(Board board) throws Exception {
		return boardMapper.getNoticeBoardCount(board);
	}
	
	public int insertComment(Board board) throws Exception {
		return boardMapper.insertComment(board);
	}
	
	public int updateCommentGroupOrder(Board board) throws Exception {
		return boardMapper.updateCommentGroupOrder(board);
	}
}
