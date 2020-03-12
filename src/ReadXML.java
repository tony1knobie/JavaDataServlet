import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
public class ReadXML {
 public static String getContents() throws IOException {
	 String json = "no contents read";
  try {
	  json = "";
   //creating a constructor of file class and parsing an XML file
	String xml = "<class><student><id>101</id><firstname>Naman</firstname><lastname>Kumar</lastname><subject>Math</subject><marks>83</marks></student><student><id>102</id><firstname>Kapil</firstname><lastname>Kumar</lastname><subject>Chemistry</subject><marks>60</marks></student><student><id>103</id><firstname>Harsh</firstname><lastname>Singh</lastname><subject>English</subject><marks>70</marks></student><student><id>104</id><firstname>Jitesh</firstname><lastname>Singh</lastname><subject>Physics</subject><marks>76</marks></student></class> ";
	String path_string = "/home/brady/eclipse-workspace/ReadXML/WebContent/StudentGrades.xml";
	Path path = Paths.get(path_string);
//	File file = new File(path);
   List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);//   XmlMapper xmlMapper = new XmlMapper();
   for (String s: lines) json = json+s;
   
   //   Class c = xmlMapper.readValue(xml, Class.class);
//   
//   ObjectMapper mapper = new ObjectMapper();
//   json = mapper.writeValueAsString(c);
//   
//  
  		}
    catch (Exception e) {
   e.printStackTrace();
  }
//  finally() {System.out.println("alsdkfjasdlkf");}
  return json;
 
}

class Class {
	Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}

class Student {
	String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	String firstname;
	String lastname;
	String subject;
	String marks;	
}

}




