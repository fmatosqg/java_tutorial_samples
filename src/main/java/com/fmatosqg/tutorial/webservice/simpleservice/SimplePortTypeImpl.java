package com.fmatosqg.tutorial.webservice.simpleservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "Simple_PortType", targetNamespace = "http://webservice.tutorial.fmatosqg.com/SimpleService.wsdl")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class SimplePortTypeImpl implements SimplePortType {

	@Override
	@WebMethod(action = "sayHello")
	@WebResult(name = "greeting", partName = "greeting")
	public String sayHello(
			@WebParam(name = "firstName", partName = "firstName") String firstName) {
		return "Hey " + firstName;
	}

	
}
