package com.fmatosqg.tutorial.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name="HelloGreeting")
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,use=SOAPBinding.Use.LITERAL)
public interface HelloGreeting {

	@WebMethod(operationName="say", action="urn:say")
	@WebResult(name="sayIt")
	public void sayIt(); 
	
	@WebMethod(operationName="greet", action="urn:greet")
	@WebResult(name="greeting")
	public String createGreeting(@WebParam(name="person") Woohoo woo);
	
}
