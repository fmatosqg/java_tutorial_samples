package com.fmatosqg.tutorial.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public class HelloGreetingImpl implements HelloGreeting{

	@Override
	@WebMethod//(operationName = "say", action = "urn:say")
	@WebResult//(name = "sayIt")
	public void sayIt() {
		System.out.println("Say Hello!!!");
	}

	@Override
	@WebMethod//(operationName = "greet", action = "urn:greet")
	@WebResult//(name = "greeting")
	public
	String createGreeting(@WebParam(name = "person") Woohoo woo) {

		return "Hello"  + woo.getGreeting() + " did you say " + woo.getAbc();
	}

}
