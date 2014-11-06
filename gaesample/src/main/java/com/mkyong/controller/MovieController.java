package com.mkyong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
  
@Controller
//@RequestMapping("/movie")
public class MovieController {
 
	//DI via Spring
	String message;
//	
//	public MovieController() {
//		System.out.println("asdsadsad");
//	}
 
	@RequestMapping(value="/movie/{name}", method = RequestMethod.GET)
	public String getMovie(@PathVariable String name) {
 
		System.out.println("qweqeqw");
		
//		model.addAttribute("movie", name);
//		model.addAttribute("message", this.message);
 
		//return to jsp page, configured in mvc-dispatcher-servlet.xml, view resolver
		return "list" + name;
 
	}
 
	public void setMessage(String message) {
		this.message = message;
	}
 
}