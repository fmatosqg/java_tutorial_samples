package com.fmatosqg.tutorial.webservice.hello;

import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 * Simple Web Service
 * @author fabio.dematos
 *
 */
@WebService(name="HelloService")
public class HelloServiceImpl implements HelloService {

    public HelloServiceImpl() {
    }

	@Override
	@WebMethod
	public String say() {
		return "Hello service";
	}

}