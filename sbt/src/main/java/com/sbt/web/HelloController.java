package com.sbt.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sbt.web.dto.Test;
import com.sbt.web.service.TestService;

@Controller
public class HelloController {
	
	@Autowired
	TestService testService;
	
	@RequestMapping(value="/")
	public String home(Model model) {
		
		return "home";
	}
	
	@RequestMapping(value="/hello")
	public String hello(Model model) {
		
		try {
			
			List<Test> test = testService.getAll();
			
			for (Test test1 : test) {
				System.out.println(test1.getName());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "hello";
	}

}
