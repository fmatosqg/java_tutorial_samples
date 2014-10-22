package com.fmatosqg.tutorial.webservice.hello;

import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 * Simple Web Service
 * @author fabio.dematos
 *
 */
@WebService
public interface HelloService {

    @WebMethod
	public String say();

}