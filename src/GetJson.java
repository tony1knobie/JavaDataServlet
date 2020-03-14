// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.json.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

// Extend HttpServlet class
public class GetJson extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ReadXML rd = new ReadXML();
   private String message;

   public void init() {
   
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
		message = ReadXML.getContents();

      // Set response content type
      response.setContentType("text/html");

      // Actual logic goes here.
      PrintWriter out = response.getWriter();
      out.println(message);
   }
   
   public void doPost(HttpServletRequest request, HttpServletResponse response)
		   throws ServletException, IOException {

		   StringBuffer jb = new StringBuffer();
		   String line = null;
		   try {
		     BufferedReader reader = request.getReader();
		     while ((line = reader.readLine()) != null)
		       jb.append(line);
		   } catch (Exception e) { /*report an error*/ }

		   try {
			   System.out.println(jb.toString());
//		     JSONObject jsonObject =  HTTP.toJSONObject(jb.toString());
		     ReadXML.saveXMLFile(jb.toString().replaceAll(" ", ""));
		   } catch (JSONException e) {
		     // crash and burn
		     throw new IOException("Error parsing JSON request string");
		   }

		   // Work with the data using methods like...
		   // int someInt = jsonObject.getInt("intParamName");
		   // String someString = jsonObject.getString("stringParamName");
		   // JSONObject nestedObj = jsonObject.getJSONObject("nestedObjName");
		   // JSONArray arr = jsonObject.getJSONArray("arrayParamName");
		   // etc...
		 }

   public void destroy() {
      // do nothing.
   }
}