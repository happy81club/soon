package com.sbt.web.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.sbt.web.dto.Board;

@MapperScan
public interface BoardMapper {
	
	/* 원글 Insert  */
	public int insertBoardWrite(Board board) throws Exception;
	
	/* 댓글 Insert */
	public int insertComment(Board board) throws Exception;
	
	/* 원글insert 후 pk값을 select 한 후 group_number 를 변경해준다 */
	public int updateGroupNumber(Board board) throws Exception;
	
	/* 댓글의 그룹순서 update */
	public int updateCommentGroupOrder(Board board) throws Exception; 
	
	/* 게시글 수정 */
	public int updateModify(Board board) throws Exception;
	
	/* pk값 조회(auto-increment value) */
	public int selectKey() throws Exception;
	
	public int procBoardWrite(Board board) throws Exception;

	public Board procBoardModifiy(Board board) throws Exception;
	
	public List<Board> listBoard(Board board) throws Exception;

	public List<Board> listCommnets(Board board) throws Exception;
	
	public Board selectDetail(Board board) throws Exception;
	
	public int deleteBoard(int articleNumber) throws Exception;
	
	public int getNoticeBoardCount(Board board) throws Exception;

	
}
