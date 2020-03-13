// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class GetJson extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ReadXML rd = new ReadXML();
   private String message;

   public void init() {
      // Do required initialization
      try {
		message = ReadXML.getContents();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}// "Hello Bitches!";
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      // Set response content type
      response.setContentType("text/html");

      // Actual logic goes here.
      PrintWriter out = response.getWriter();
      out.println(message);
   }

   public void destroy() {
      // do nothing.
   }
}