package com.fmatosqg.tutorial.rest;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
 
public class GoodbyeServlet extends HttpServlet
{
	private static final String FORM_GET = "<p><form name=\"input\" action=\"goodbye\" method=\"get\">" +
			"This form performs GET <br/>" +			
			"First name: <input type=\"text\" name=\"firstname\"><br/>" +
			"Last name: <input type=\"text\" name=\"lastname\"><br/>" +
			"<input type=\"submit\" value=\"Submit\">" +
			"</form>";

	private static final String FORM_POST_PLAIN = 
			"<p><form name=\"input\" action=\"goodbye\" method=\"post\">\n" +
			"This form performs POST <br/>\n" + 
			"First name: <input type=\"text\" name=\"post_firstname\"><br/>\n" +
			"Last name: <input type=\"text\" name=\"post_lastname\"><br/>\n" +
			"<input type=\"file\" name=\"fileField\"><br />\n" +
			"<input type=\"submit\" value=\"Submit\">\n" +
			"</form>";
	
	private static final String FORM_POST_MULTIPART = 
			"<p><form name=\"input\" action=\"goodbye\" method=\"post\" enctype=\"multipart/form-data\">\n" +
			"This form performs POST using multipart <br/>\n" + 
			"First name: <input type=\"text\" name=\"post_firstname\"><br/>\n" +
			"Last name: <input type=\"text\" name=\"post_lastname\"><br/>\n" +
			"<input type=\"hidden\" name=\"md5\"  value=\"truue\">\n" +
			"<input type=\"file\" name=\"fileField\"><br />\n" +
			"<input type=\"submit\" value=\"Submit\">\n" +
			"</form>";
		
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
        writeBuffer("<h1>Goodbye Servlet</h1>");
        writeBuffer("Character encoding = " + request.getCharacterEncoding() + "<br/>\n");
        writeBuffer("Content type = " + request.getContentType()  + "<br/>\n");
        writeBuffer("Method = " + request.getMethod()  + "<br/>\n");
        writeBuffer("session=" + request.getSession(true).getId() + "<br/>\n<p>");
        
        /*Enumeration a = request.getAttributeNames();
        
        while (a.hasMoreElements()) {
        	Object el = a.nextElement();
        	response.getWriter().println("<br/>" + "attribute=" + el);
        }*/
        
        

        
        handlePlainText(request,response);
        Integer MD5value = handleMultiPart(request,response);
        
        writeBuffer(FORM_GET);
        writeBuffer(FORM_POST_PLAIN);
        writeBuffer(FORM_POST_MULTIPART);
        
        if ( MD5value != null ) {
        	buffer = new StringBuffer();
        	buffer.append(MD5value);
        }
        
        flushBuffer(response);

    }
    


	/**
     * Handling forms that are multipart, using the apache fileupload package.
     * More info on http://commons.apache.org/proper/commons-fileupload/using.html
     * @param request
     * @param response
	 * @return 
     * @throws IOException 
     */
    private Integer handleMultiPart(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
    	
    	Integer MD5value = null;
    	String content = request.getContentType();
    	
    	if ( content == null ||  !content.contains("multipart/form-data") ) {
    		return MD5value;
    	}
    	
    	FileItemFactory factory = new DiskFileItemFactory();  
    	
    	// ServletFileUpload handles the file uploads in the request:    	
    	ServletFileUpload upload = new ServletFileUpload(factory);  
    	  
  
    	try {
        	// the parseRequest() method puts all the request parameters into a List
			List items = upload.parseRequest(request);
			
//			String isCalculateMD5 = (String) request.getAttribute("md5");
//			if ( isCalculateMD5 != null ) {
//				System.out.println("isCalculateMD5 = " + isCalculateMD5.toString());
//			}
			
			// Process the uploaded items
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
			    FileItem item = iter.next();

			    if (item.isFormField()) {
			        String name = item.getFieldName();
			        String value = item.getString();
			        
//			        response.getWriter().println("Multipart " + name + "->"  + value + "<br/>");

			    } else {
			    	String fieldName = item.getFieldName();
			        String fileName = item.getName();
			        String contentType = item.getContentType();
			        boolean isInMemory = item.isInMemory();
			        long sizeInBytes = item.getSize();
			        
			        writeBuffer(fieldName + " => " + sizeInBytes + " bytes<br/>");
			        System.out.println(fieldName + " => " + sizeInBytes + " bytes");
			        MD5value = 1;
			        //TODO add random filename with timestamp
			        File uploadedFile = new File("here.file");
			        item.write(uploadedFile);


			    }
			}
			
			
		} catch (FileUploadException e) {
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
    	return MD5value;
	}

    /**
     * Handling forms that are not multipart
     * @param request
     * @param response
     * @throws IOException 
     */
	private void handlePlainText(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

        
        Map map = request.getParameterMap();
        Iterator entries = map.entrySet().iterator();

        while ( entries.hasNext() ) {

        	Entry entry = (Entry) entries.next();
        	String []values = (String[]) entry.getValue();
        	writeBuffer("<br/>" + "parameter " + entry.getKey() + " -> " + Arrays.toString(values));
        	
        }
		
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	
    	doGet(request,response);
    }
	
	private StringBuffer buffer = new StringBuffer();
	private void writeBuffer(String buffer) {
		this.buffer.append(buffer);
	}

    private void flushBuffer(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(buffer);
		
	}
} 
