package com.fmatosqg.tutorial.webservice.simpleservice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class SimplePortTypeClient {

	public static void main(String[] args) {
		try {
			SimplePortTypeClient client = new SimplePortTypeClient();
			client.test();
			client.list();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Call method using SOAP
	 */
	 private void test() { 
		 try{
			 String endpoint = "http://localhost:8080/SimpleService";  
			 URL url = new URL(endpoint);

			 QName qname = new QName("http://webservice.tutorial.fmatosqg.com/SimpleService.wsdl","SimplePortTypeImplService");
			 Service service = Service.create(url, qname);

			 SimplePortType port = (SimplePortType) service.getPort(SimplePortType.class);
			 System.out.println(port.sayHello("Duuuuuuude"));

		 }catch(Exception e){
			 System.err.println(e.toString());
		 }

	 }

	 /** 
	  * List QNames under service
	  */
	 private void list() {
		 String endpoint = "http://localhost:8080/SimpleService";   
		 
		 try {
			 URL url = new URL(endpoint);

			 QName qname = new QName("http://webservice.tutorial.fmatosqg.com/SimpleService.wsdl","SimplePortTypeImplService");
			 Service service = Service.create(url, qname);

			 System.out.println("Service is " + service.getServiceName());

			 Iterator<QName> it = service.getPorts();
			 while ( it.hasNext() ) {
				 QName name = it.next();
				 System.out.println("List " + name.getLocalPart());

			 }
		 } catch (MalformedURLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
	 }

}

