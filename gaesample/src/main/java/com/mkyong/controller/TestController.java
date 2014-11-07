package com.mkyong.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fmatosqg.gatherimages.downloader.ImageDownloader;
import com.fmatosqg.gatherimages.downloader.nasa.NasaPictureOfTheDayDownloader;
import com.fmatosqg.gatherimages.downloader.pinterest.PinterestFeed;
import com.fmatosqg.gatherimages.downloader.utils.DownloaderException;
  
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
  
	@RequestMapping(value="test/image")
	public @ResponseBody
    String getImage() throws DownloaderException {
		
		ImageDownloader downloader = new NasaPictureOfTheDayDownloader();
//		return downloader.getRandomPhotoUrl(null);
		return downloader.getDownloaderName();
			
	}
	
	@RequestMapping(value="test/pinterest")
	public @ResponseBody
    String getImagePinterest() throws DownloaderException {
		
		ImageDownloader downloader = new PinterestFeed();
		return downloader.getRandomPhotoUrl(null);
	}
}