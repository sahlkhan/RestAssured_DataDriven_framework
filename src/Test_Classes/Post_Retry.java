package Test_Classes;

import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.Assert;
import Common_Api_methods.Api_Post_Methods;
import RequestRepositry.Post_Req_Repositry;
import io.restassured.path.json.JsonPath;

public class Post_Retry {
	public static void Extractor() throws IOException {
		for(int i=0; i<5; i++)
		{
			int statuscode=Api_Post_Methods.ResponseStatusCode(Post_Req_Repositry.BaseURI(),Post_Req_Repositry.Post_Req_Resource(),Post_Req_Repositry.RequestBody());
			System.out.println(statuscode);
			if(statuscode==201)
			{
				String  ResponseBody =Api_Post_Methods.ResponseBody(Post_Req_Repositry.BaseURI(), Post_Req_Repositry.Post_Req_Resource(),Post_Req_Repositry.RequestBody());
				System.out.println(ResponseBody);
				
			//Validator RequestBody and ResponseBody
			  String RequestBody=Post_Req_Repositry.RequestBody();
			  Validator(RequestBody,ResponseBody);
			  break;
			}
			else
			{
				System.out.println("status code incorrect");
			}
		}
	}
	public static void Validator(String RequestBody,String ResponseBody) {
		JsonPath JspRequest= new JsonPath(RequestBody);
		String req_name=JspRequest.getString("name");
		String req_job=JspRequest.getString("job");
		JsonPath JspResponse = new JsonPath(ResponseBody);
		String res_name=JspResponse.getString("name");
		String res_job=JspResponse.getString("job");
		String res_createdAt=JspResponse.getString("createdAt");
		res_createdAt=res_createdAt.substring(0,10);
		//validate the responseBody parameters
		Assert.assertEquals(res_name,req_name);
		Assert.assertEquals(res_job,req_job);
		}
	}
			 