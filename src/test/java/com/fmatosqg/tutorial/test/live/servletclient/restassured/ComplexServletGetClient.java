package com.fmatosqg.tutorial.test.live.servletclient.restassured;

import static com.jayway.restassured.RestAssured.get;
import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import org.junit.Test;

public class ComplexServletGetClient {

	public static void main(String []args) {

		ComplexServletGetClient client = new ComplexServletGetClient();
		
		System.out.println("Starting tests on " + client.getClass());
		client.testHTML();
		client.testJson();
		client.testXml();

	}

	public void testXml() {
		String url = "/complex?xml=true";
		String xml = get(url).asString();		
//		System.out.println("get html from " + url  + " and recovered xml as " + xml);

		assertEquals("",xml);
	}

	public void testHTML() {

		String url = "/complex?html=true";
		String html = get(url).asString();		
//		System.out.println("get html from " + url  + " and recovered json as " + html);

		assertEquals("You're going to see plain html.",html);
	}

	public void testJson() {

		String url = "/complex?json=true";
		String json = get(url).asString();		
//		System.out.println("get json from " + url  + " and recovered json as " + json);

		String expected = "{\"A\":10,\"B\":20,\"C\":30,\"weekdays\":[\"Sunday\",\"Monday\",\"Tuesday\"]}";
		assertEquals(expected,json);
	}

	/*private static void updateCustomer() {//(Customer customer) { 

		URL url;
		try {
			System.out.println("Start");
			url = new URL("http://www.example.com/customers");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
			connection.setDoOutput(true); 
			connection.setInstanceFollowRedirects(false); 
			connection.setRequestMethod("PUT"); 
			connection.setRequestProperty("Content-Type", "application/xml"); 

			OutputStream os = connection.getOutputStream(); 
			//	        jaxbContext.createMarshaller().marshal(customer, os); 
			os.flush(); 

			System.out.println("Response " + connection.getResponseCode()); 
			connection.disconnect(); 
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 



	} */

	/*	private static void test1() {
		// Example with JsonPath
		String json = get("/lotto").asString();
		List<String> winnderIds = from(json).get("lotto.winners.winnerId");

		// Example with XmlPath
		String xml = post("/shopping").andReturn().body().asString();
		Node category = from(xml).get("shopping.category[0]");
	}*/


	/*
	private void test2(){	
		// Make a GET request to "/lotto"
		String json = get("/lotto").asString();
		// Parse the JSON response
		List<String> winnderIds = with(json).get("lotto.winners.winnerId");

		// Make a POST request to "/shopping"
		String xml = post("/shopping").andReturn().body().asString()
				// Parse the XML
				Node category = with(xml).get("shopping.category[0]");
	}*/

	/*	private test() {
	    clientConfig = new DefaultClientConfig();
	    client = Client.create(clientConfig);

	    resource = client.resource("http://localhost:8080");
	    // lets get the XML as a String
	    String text = resource("foo").accept("application/xml").get(String.class);
	}
	 */
}
