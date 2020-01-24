package com.sbt.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	@RequestMapping(value="user/boardWriter")
	public String boardWriter(HttpServletRequest request, Model model) throws Exception {
		
		return "board/boardWriter";
	}
	
	@RequestMapping(value="user/boardModifiy")
	public String boardModifiy(HttpServletRequest request, Model model) throws Exception {
		
		return "board/boardModifiy";
	}
	
	@RequestMapping(value="user/boardList")
	public String boardList(HttpServletRequest request, Model model) throws Exception {
		
		return "board/boardList";
	}

}
