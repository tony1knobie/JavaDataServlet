import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
public class ReadXML {
 
	 public static String path_string = "/home/brady/eclipse-workspace/ReadXML/WebContent/StudentGrades.xml";
	 public static String xml = "";
	 public static int PRETTY_PRINT_INDENT_FACTOR = 4;
     public static String jsonPrettyPrintString = "no contents loaded";

	 public static String getContents() throws IOException {
	        try {
	        	Path path = Paths.get(path_string);
	           List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);//   XmlMapper xmlMapper = new XmlMapper();
   				for (String s: lines) xml = xml+s;
	        	JSONObject xmlJSONObj = XML.toJSONObject(xml);
	            jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
	        } catch (JSONException je) {
	            System.out.println(je.toString());
	        }
	        return jsonPrettyPrintString;
	    }
}
