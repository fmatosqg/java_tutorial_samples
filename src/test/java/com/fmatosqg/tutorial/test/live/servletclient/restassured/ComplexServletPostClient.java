package com.fmatosqg.tutorial.test.live.servletclient.restassured;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.post;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.jayway.restassured.response.Response;

public class ComplexServletPostClient {

	public static void main(String []args) {

		ComplexServletPostClient client = new ComplexServletPostClient();
		
		System.out.println("Starting tests on " + client.getClass());
		client.testJson();
		client.testChecksum();
	}

	private void testJson() {
		Response response = post("/complex?json=true");
		System.out.println("Response  " + response.asString());
	}
	
	private void testChecksum() {
//		Object value = null;
//		Response response = post("/complex?checksum=true",value);
//		a= expect();
		
		// TODO fix path
		String filename = "C:\\fabio.dematos\\downloads\\nuke.jpg";
		Response response = given().
        multiPart("controlName",new File(filename)).
        multiPart("md5", "true").
        when().post("/goodbye");
//        when().post("/complex?checksum=true");
		
		
		
//		System.out.println("Response  " + response.asString());
		
/*		Map<String,String> map = new HashMap<String, String>();
		map.put("key1","value1");
		Response response = given().
		multiPart(new File(filename)).
        parameters("firstName", "Johnn", "lastName", "Doee","aa",new File(filename)).
        expect().
//        when().post("/complex?checksum=true");
        when().post("/goodbye");
		*/
		System.out.println("MD5 Response = " + response.asString());
		
		
		
	}
}
