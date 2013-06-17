package com.fmatosqg.tutorial.webservice;

import javax.jws.WebService;
import javax.jws.WebMethod;

// need 2 manual steps
// 1- wsgen -cp target\classes com.fmatosqg.tutorial.webservice.HelloService
// 2- copy generated classes into target/class folder

/**
 * Simple Web Service
 * @author fabio.dematos
 *
 */
@WebService
public class HelloService {
    private String message = new String("Hello, ");

    public HelloService() {
    }

    @WebMethod
	public void say() {
		System.out.println("Hello service");
		
	}

}