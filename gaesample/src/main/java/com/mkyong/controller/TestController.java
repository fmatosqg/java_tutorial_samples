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

//		httpRes.setStatus(404);
		return "tttest";
 
	}
	
	@RequestMapping(value="test/aaa")
	public @ResponseBody
    String getStudent() {
		return "student1";
	}
  
//	@RequestMapping(value="test/image")
//	public @ResponseBody 
//    String getImage() throws DownloaderException {
//		
//		ImageDownloader downloader = new NasaPictureOfTheDayDownloader();
////		return downloader.getRandomPhotoUrl(null);
//		return downloader.getDownloaderName();
//			
//	}
	
//	@RequestMapping(value="test/9gag")
//	public @ResponseBody
//    String getImagePinterest() throws DownloaderException {
//		
//		ImageDownloader downloader = new NineGagDownloader();
//		return downloader.getRandomPhotoUrl(DownloaderConfiguration.getEmptyInstance());
//	}
	
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
	
//	@RequestMapping(value="test/list")
	@RequestMapping(value="test/list", produces={"application/json"})
	public 
	@ResponseBody Album 
	getImageList()  {
		
		AbstractRssDownloader downloader = new JPLDownloader();

		return downloader.getRandomAlbum();
	}
	
	
	

}