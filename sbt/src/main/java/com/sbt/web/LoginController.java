package com.sbt.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login")
	public String login(Model model, HttpServletRequest req) {
		model.addAttribute("message", req.getServletContext());
		return "login";
	}

	

}
