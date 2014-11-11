package com.mkyong.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fmatos.gaeSample.downloader.AbstractRssDownloader;
import com.fmatos.gaeSample.downloader.Album;
import com.fmatos.gaeSample.downloader.JPLDownloader;
  
@Controller
public class TestController {
 
 
	@RequestMapping(value="/test", method = RequestMethod.GET)
	public @ResponseBody String getTest(HttpServletResponse httpRes) {
 
		System.out.println("aaaaa");

		return "tttest";
 
	}
	
	@RequestMapping(value="test/aaa")
	public @ResponseBody
    String getStudent() {
		return "student1";
	}
	
	@RequestMapping(value="test/nasa")
	public @ResponseBody
    String getImageNasa()  {
		
		AbstractRssDownloader downloader = new JPLDownloader();
		return downloader.getRandomPhotoUrl();
	}
	
	@RequestMapping(value="test/ttt", produces={"application/json"})
	public @ResponseBody
    String getImageTtt()  {
		
		AbstractRssDownloader downloader = new JPLDownloader();
		return downloader.getRandomPhotoUrl();
	}
	
	@RequestMapping(value="test/list", produces={"application/json"})
	public 
	@ResponseBody Album 
	getImageList()  {
		
		AbstractRssDownloader downloader = new JPLDownloader();

		return downloader.getRandomAlbum();
	}
	
	
	

}