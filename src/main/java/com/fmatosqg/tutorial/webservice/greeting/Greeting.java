package com.fmatosqg.tutorial.webservice.greeting;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.WebServiceClient;


@WebService(name="Greeting")
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,use=SOAPBinding.Use.LITERAL)
@WebServiceClient(name = "Greeting_Service", targetNamespace = "http://greeting.webservice.tutorial.fmatosqg.com/Greeting.wsdl", wsdlLocation = "http://localhost:8080/Greeting?wsdl")
public interface Greeting {

	@WebMethod(operationName="say", action="urn:say")
	@WebResult(name="sayIt")
	public void sayIt(); 
	
	@WebMethod(operationName="greet", action="urn:greet")
//	@WebResult(name="greeting")
	public String createGreeting(@WebParam(name="person") Woohoo woo);
	
}
