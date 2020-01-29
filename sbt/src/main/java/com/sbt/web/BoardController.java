package com.sbt.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sbt.web.dto.Board;
import com.sbt.web.dto.Criteria;
import com.sbt.web.dto.PageMaker;
import com.sbt.web.dto.User;
import com.sbt.web.service.BoardService;

@Controller
@SessionAttributes("user")
public class BoardController {
	
	
	@Autowired
	BoardService boardService;
	
	
	// 게시글 작성뷰
	@RequestMapping(value="user/boardWriter")
	public String boardWriter(@ModelAttribute Board board, Model model) throws Exception {
		
		return "board/boardWriter";
	}
	
	// 게시글 작성Proc
	@RequestMapping(value="user/procWriter")
	public String procWriter(@ModelAttribute Board board,
			             	 @ModelAttribute User user,
			                 Model model) throws Exception {
		
		try {
			board.setWriter(user.getUsername());
			boardService.procBoardWrite(board);
		}catch (Exception e) {
			model.addAttribute("errMsg", e.getMessage());
			return "error";
		}
		
		return "redirect:boardList";
	}
	
	// 게시글 상세뷰
	@RequestMapping(value="user/boardView")
	public String boardView(@ModelAttribute Board board,
			                @RequestParam(value="articleNumber", required = true, defaultValue = "0") int articleNumber,
			                Model model) throws Exception {
		
		if(articleNumber > 0) {
			board.setArticleNumber(articleNumber);
		}
		
		Board view = boardService.selectDetail(board);
		
		if(null != view) {
			//view.setContent(view.getContent().replace("\r\n", "<br>"));
			
			board.setGroupNumber(view.getGroupNumber());
			board.setGroupOrder(view.getGroupOrder());
			board.setGroupHierarchy(view.getGroupHierarchy());
		}
		
		model.addAttribute("board", view);
		
		return "board/boardView";
	}


	// 게시글 수정Proc
	@RequestMapping(value="user/boardModifiy")
	public String boardModifiy(@ModelAttribute Board board, Model model) throws Exception {
		
		Board view = boardService.selectDetail(board);
		
		if(null != view) {
			model.addAttribute("board", view);
		}
		
		return "board/boardModifiy";
	}

	// 게시글 삭제Proc
	@RequestMapping(value="user/procDelete")
	public String procDelete( @RequestParam(value="articleNumber", required = true, defaultValue = "0") int articleNumber ) throws Exception {
		
		boardService.deleteBoard(articleNumber);
		
		return "redirect:boardList";
	}
	
	// 게시글 수정뷰
	@RequestMapping(value="user/procModifiy")
	public String procModifiy(@ModelAttribute Board board, 
			                  RedirectAttributes redirectAttr, 
			                  Model model) throws Exception {
		
		board = boardService.procBoardModifiy(board);
		
		redirectAttr.addAttribute("articleNumber", board.getArticleNumber());
		
		return "redirect:boardView";
	}

	// 게시글 리스트뷰
	@RequestMapping(value="user/boardList")
	public String boardList(@ModelAttribute Board board,
			                Criteria criteria, 
			                Model model) throws Exception {
		int total = 0;
		List<Board> list = new ArrayList<Board>();
		
		total = boardService.getNoticeBoardCount(board);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(total);
		
		board.setStartPage(criteria.getPageStart());
		board.setPerPageNum(criteria.getPerPageNum());
		list = boardService.listBoard(board);
		
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", pageMaker);
		
		return "board/boardList";
	}
	
	// 게시판 샘플
	@RequestMapping(value="user/boardSample")
	public String boardboardSample(HttpServletRequest request, Model model) throws Exception {
		
		return "board/boardSample";
	}

}
