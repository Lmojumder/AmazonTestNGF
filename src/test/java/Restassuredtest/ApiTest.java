package Restassuredtest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ApiTest {
  @Test
  public void f() {
	  baseURI="https://reqres.in";
	  
	  Response TheResponseofTheApI = get(baseURI+"/api/users?page=2");
	 TheResponseofTheApI.prettyPeek();
	 int Statuscode= TheResponseofTheApI.getStatusCode();
	 System.out.println(Statuscode);
	
	 SoftAssert sftasrt = new SoftAssert();
	 sftasrt.assertEquals(Statuscode,200,"List Users API - Assert for Status Code:");
	// Assert.assertEquals(Statuscode, 201,"List Users API - Assert for Status Code");
	 
	 String bodyinString=TheResponseofTheApI.asString();
	 Assert.assertTrue(bodyinString.toLowerCase().contains("michael.laws@reqres.in"),"Email verfication in Response:");
	 
	 
	 
	 
	 sftasrt.assertAll();
  }
}
