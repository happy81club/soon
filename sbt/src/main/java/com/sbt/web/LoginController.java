package com.sbt.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	
	@RequestMapping(value="/login")
	public String login(Model model, HttpServletRequest req) {
		model.addAttribute("message", req.getServletContext());
		
		return "login";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, SessionStatus status) throws Exception {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// SessionStatus�� �������� ������̼����� �����Ǵ� @SessionAttributes�� ������ �����Ų��.
		status.isComplete();
		if(status.isComplete() == true) {
			logger.info("���Ǹ���!!!!!!!!!!!!!!!!");
		}
		
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		} 
		
		return "redirect:login";
	}

	

}
