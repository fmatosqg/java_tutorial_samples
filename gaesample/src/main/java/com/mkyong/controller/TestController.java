package com.mkyong.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
  
@Controller
public class TestController {
 
 
	@RequestMapping(value="/test", method = RequestMethod.GET)
	public @ResponseBody String getTest(HttpServletResponse httpRes) {
 
		System.out.println("aaaaa");

//		httpRes.setStatus(404);
		return "tttest";
 
	}
	
	@RequestMapping(value="test/aaa")
	public @ResponseBody
    String getStudent() {
		return "student1";
	}
  
}