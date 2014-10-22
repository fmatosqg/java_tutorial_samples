package com.fmatosqg.tutorial.webservice.hello;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceRef;

import com.fmatosqg.tutorial.webservice.greeting.Greeting;
import com.fmatosqg.tutorial.webservice.simpleservice.SimpleService;

public class HelloServiceClient {

	private static final String endpoint = "http://localhost:8080/HelloService";
	private static final QName qname = new QName("http://hello.webservice.tutorial.fmatosqg.com/","HelloServiceImplService");

	public static void main(String []args) {

		list();
		
		URL url;
		try {
			url = new URL(endpoint);
			Service service = Service.create(url, qname);
			HelloService port = service.getPort(HelloService.class);
			
			System.out.println("Webservice says '" + port.say() + "'");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	 /** 
	  * List QNames under service
	  */
	 private static void list() {
		 
		 try {
			 URL url = new URL(endpoint);


			 Service service = Service.create(url, qname);

			 System.out.println("Service is " + service.getServiceName());

			 Iterator<QName> it = service.getPorts();
			 while ( it.hasNext() ) {
				 QName name = it.next();
				 System.out.println("List " + name.getLocalPart());

			 }
		 } catch (MalformedURLException e) {
			 e.printStackTrace();
		 }
	 }

}