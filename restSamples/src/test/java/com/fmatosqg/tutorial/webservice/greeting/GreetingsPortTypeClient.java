package com.fmatosqg.tutorial.webservice.greeting;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;


public class GreetingsPortTypeClient {

	private static final String endpoint = "http://localhost:8080/Greeting";
	private static final QName qname = new QName("http://greeting.webservice.tutorial.fmatosqg.com/","GreetingImplService");
	
	public static void main(String[] args) {
		try {
			GreetingsPortTypeClient client = new GreetingsPortTypeClient();
			
			client.list();
			client.test();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Call method using SOAP
	 */
	 private void test() { 
		 try{
			    
			 URL url = new URL(endpoint);
			 Service service = Service.create(url, qname);
			 Greeting port = service.getPort(Greeting.class);
			 
			 port.sayIt();
			 Woohoo woo = new Woohoo();
			 woo.setAbc("abcd");
			 System.out.println(port.createGreeting(woo));
			 
			 

		 }catch(Exception e){
			 System.err.println(e.toString());
			 e.printStackTrace();
		 }

	 }

	 /** 
	  * List QNames under service
	  */
	 private void list() {
		 
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

