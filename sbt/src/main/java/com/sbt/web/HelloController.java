package com.sbt.web;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sbt.web.dto.User;
import com.sbt.web.service.TestService;
import com.sbt.web.service.UserService;

@Controller
@SessionAttributes("loginVO")
public class HelloController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	
	@Autowired
	TestService testService;

	@Autowired
	UserService userService;
	
	
	@RequestMapping(value="/")
	public String home(Principal principal, Model model) {
		
		if(null != principal) {
			
			model.addAttribute("username", principal.getName());
			return "hello";
		}
		
		return "login";
	}
	
	@RequestMapping(value="/hello")
	public String hello(Principal principal, Model model) throws Exception {
		
		logger.info("hello......................................");
		
		User user = new User();
		user.setUsername(principal.getName());
		model.addAttribute("loginVO", user);
		
		model.addAttribute("username", principal.getName());
		
		logger.trace("trace >>" + principal.getName());
		logger.debug("debug >>" + principal.getName()); 
		logger.info("info >>"   + principal.getName());
		logger.warn("warn >>"   + principal.getName());
		logger.error("error >>" + principal.getName());
		
		return "hello";
	}

	@RequestMapping(value="/loginErr")
	public String error(HttpServletRequest request, Model model) throws Exception {
		
		model.addAttribute("username", request.getParameter("username"));
		
		return "loginErr";
	}

	@RequestMapping(value="/home")
	public String home(HttpServletRequest request, Model model) throws Exception {
		
		
		return "home";
	}

}
