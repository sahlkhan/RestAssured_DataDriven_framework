package RequestRepositry;

import java.io.IOException;
import java.util.ArrayList;

import Common_Api_methods.Common_Utility_Method;

public class Post_Req_Repositry {
	public static String BaseURI() {
		String BaseURI = "https://reqres.in/";
		return BaseURI;
	}
	public static String Post_Req_Resource() {
		String Post_Req_Resource="api/users";
		return Post_Req_Resource;
	}
	public static String RequestBody() throws IOException {
		ArrayList<String>Req_Data=Common_Utility_Method.ReadDataExcel("Post","TC2");
		String Req_Name=Req_Data.get(1);
		String Req_job=Req_Data.get(2);
		String RequestBody="{\r\n"
				+ "    \"name\": \""+Req_Name+"\",\r\n"
				+ "    \"job\": \""+Req_job+"\"\r\n"
				+ "}";
		return RequestBody;
	}

}
