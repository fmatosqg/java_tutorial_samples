package com.fmatosqg.tutorial.test.endpoint;

import javax.xml.ws.Endpoint;

import com.fmatosqg.tutorial.webservice.hello.HelloService;
import com.fmatosqg.tutorial.webservice.hello.HelloServiceImpl;

/**
 * This class publishes the {@link HelloService} endpoint
 * @author fabio.dematos
 *
 */
public class PublishEnpoint {

	public static void main(String []args) {
		
		final String url = "http://localhost:8080/WS/Hello";
		System.out.println("Publishing endpoint in " + url);
		Endpoint.publish(url,new HelloServiceImpl());
	}
}
