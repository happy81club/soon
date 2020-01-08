package com.sbt.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	//@RequestMapping("/hello")
	@RequestMapping(value="/hello")
	public String index(Model model) {
		
		return "hello";
	}

}
