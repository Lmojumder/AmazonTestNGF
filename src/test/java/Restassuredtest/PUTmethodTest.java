package Restassuredtest;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PUTmethodTest {
  @Test
  public void f() {
	  File PutmethodBody = new File("C:\\EAL_ECLIPES_ALL_WORK\\AmazonTestNGF\\putbtn.json");
	  String createBtn_Endpoint= "/api/users";
	  Response PutEndPointFullResponse=given().contentType(ContentType.JSON).body(PutmethodBody).put("https://reqres.in/api/users/2");
	 // PutEndPointFullResponse.prettyPeek();
	  
	  int StatuscodeOFPutMethodUpdate = PutEndPointFullResponse.getStatusCode();
	  System.out.println(StatuscodeOFPutMethodUpdate);
	  
	  SoftAssert sftasrt = new SoftAssert();
	  sftasrt.assertEquals(StatuscodeOFPutMethodUpdate, 200);
	  
	//  Assert.assertEquals(StatuscodeOFPutMethodUpdate, 200);
	  sftasrt.assertAll();
  }
}
