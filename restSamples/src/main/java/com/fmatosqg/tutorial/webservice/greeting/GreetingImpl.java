package com.fmatosqg.tutorial.webservice.greeting;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;


@WebService(name="Greeting")
public class GreetingImpl implements Greeting{

	@Override
	@WebMethod(operationName = "say", action = "urn:say")
	@WebResult(name = "sayIt")
	public void sayIt() {
		System.out.println("Say Hello!!!"); // this goes out in the server's console
		
	}

	@Override
	@WebMethod(operationName = "greet", action = "urn:greet")
//	@WebResult(name = "greeting")
	public String createGreeting(@WebParam(name = "person") Woohoo woo) {
		// TODO Auto-generated method stub
		return "Hello "  + woo.getGreeting() + " did you say " + woo.getAbc();
	}

}
