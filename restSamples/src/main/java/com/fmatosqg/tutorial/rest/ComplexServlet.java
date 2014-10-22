package com.fmatosqg.tutorial.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

public class ComplexServlet extends HttpServlet {

	private static final String TRUE = "true";
	private static final String FALSE = "false";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);

		generateIndex(request,response);
		generateJSon(request,response);
		generateHtml(request,response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);

		response.getWriter().println("<p>********This is a post");
		generateIndex(request,response);
		generateJSon(request,response);
		generateHtml(request,response);
		calculateChecksum(request,response);

	}

	private void generateIndex(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		if (  checkBooleanParameter(request, "index") ) {
			response.getWriter().println("<h1>Hello Complex Servlet</h1>");			
			response.getWriter().println("Choose what you want to see: <p>");
			response.getWriter().println("<a href=complex?html=true>html</a><br/>");
			response.getWriter().println("<a href=complex?json=true>json</a><br/>");

		} 


	}

	private boolean checkBooleanParameter(HttpServletRequest request, String key) {

		Map map = request.getParameterMap();

		String []value = (String[]) map.get(key);
		if ( value != null && value.length > 0 && TRUE.equals(value[0])) {
			return true; 
		} else {
			return false;
		}
	}

	private void generateHtml(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		if ( checkBooleanParameter(request, "html") ) {
			response.getWriter().print("You're going to see plain html.");
		} 


	}

	private void generateJSon(HttpServletRequest request, HttpServletResponse response) throws IOException {


		if ( checkBooleanParameter(request, "json") ) {
			//			response.getWriter().print("{hello:hello}");


			Map<String, Object> map = new HashMap<String, Object>();
			map.put("A", 10L);
			map.put("B", 20L);
			map.put("C", 30L);

            List<String> list = new ArrayList<String>();
            list.add("Sunday");
            list.add("Monday");
            list.add("Tuesday");
            
            map.put("weekdays",list);
			JSONObject json = new JSONObject();
			json.putAll(map);
//			System.out.println("Json is " + json.toJSONString());
			response.getWriter().print(json.toJSONString());

		}
	}
	
	private void calculateChecksum(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		if ( checkBooleanParameter(request, "checksum") ) {
			response.getWriter().print("your checksum is");

	        Map map = request.getParameterMap();
	        Iterator entries = map.entrySet().iterator();

	        while ( entries.hasNext() ) {
	        	Entry entry = (Entry) entries.next();
	        	String []values = (String[]) entry.getValue();
	        	System.out.println("<br/>POST " + "parameter " + entry.getKey() + " -> " + Arrays.toString(values));
	        	
	        }
	        
		} 


	}
}

