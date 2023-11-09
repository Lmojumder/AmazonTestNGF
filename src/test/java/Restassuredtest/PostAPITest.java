package Restassuredtest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.io.File;

public class PostAPITest {
  @Test
  public void f() {
	  File JesonFieObject = new File("C:\\EAL_ECLIPES_ALL_WORK\\AmazonTestNGF\\createbtn.json");
	
	  
	  baseURI = "https://reqres.in";
	  String createBtn_Endpoint= "/api/users";
	  Response create_Response=given().contentType(ContentType.JSON).body(JesonFieObject).post(baseURI+createBtn_Endpoint);
	  create_Response.prettyPeek();
	  System.out.println(create_Response.getStatusCode());
	  int create_Statuscode=create_Response.getStatusCode();
	  
	//  Assert.assertEquals(create_Statuscode,200, "createbtn_Status code validation:");
	  SoftAssert sftasrt = new SoftAssert();
	  sftasrt.assertEquals(create_Statuscode,200,"createbtn_Status code validation:" );
	  sftasrt.assertAll();
  }
}
