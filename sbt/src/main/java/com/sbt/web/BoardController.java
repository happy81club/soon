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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sbt.web.dto.Board;
import com.sbt.web.service.BoardService;

@Controller
public class BoardController {
	
	
	@Autowired
	BoardService boardService;
	
	// �Խñ� �ۼ���
	@RequestMapping(value="user/boardWriter")
	public String boardWriter(@ModelAttribute Board board, Model model) throws Exception {
		
		return "board/boardWriter";
	}
	
	// �Խñ� �ۼ�Proc
	@RequestMapping(value="user/procWriter")
	public String procWriter(@ModelAttribute Board board, Model model) throws Exception {
		
		boardService.procBoardWrite(board);
		
		return "redirect:boardList";
	}
	
	// �Խñ� �󼼺�
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


	// �Խñ� ����Proc
	@RequestMapping(value="user/boardModifiy")
	public String boardModifiy(@ModelAttribute Board board, Model model) throws Exception {
		
		Board view = boardService.selectDetail(board);
		
		if(null != view) {
			model.addAttribute("board", view);
		}
		
		return "board/boardModifiy";
	}

	// �Խñ� ����Proc
	@RequestMapping(value="user/procDelete")
	public String procDelete( @RequestParam(value="articleNumber", required = true, defaultValue = "0") int articleNumber ) throws Exception {
		
		boardService.deleteBoard(articleNumber);
		
		return "redirect:boardList";
	}
	
	// �Խñ� ������
	@RequestMapping(value="user/procModifiy")
	public String procModifiy(@ModelAttribute Board board, 
			                  RedirectAttributes redirectAttr, 
			                  Model model) throws Exception {
		
		board = boardService.procBoardModifiy(board);
		
		redirectAttr.addAttribute("articleNumber", board.getArticleNumber());
		
		return "redirect:boardView";
	}

	// �Խñ� ����Ʈ��
	@RequestMapping(value="user/boardList")
	public String boardList(HttpServletRequest request, Model model) throws Exception {
		
		List<Board> list = new ArrayList<Board>();
		
		list = boardService.listBoard();
		
		model.addAttribute("list", list);
		
		return "board/boardList";
	}
	
	// �Խ��� ����
	@RequestMapping(value="user/boardSample")
	public String boardboardSample(HttpServletRequest request, Model model) throws Exception {
		
		return "board/boardSample";
	}

}
