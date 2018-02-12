package com.groupkt.testcase;

import org.testng.annotations.Test;

import com.groupkt.common.EndPoints;
import com.groupkt.constant.RestUtilities;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeMethod;

public class GetContry {
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	@BeforeMethod
	  public void beforeClass() {
		reqSpec=RestUtilities.getRequestSpecification();
		reqSpec.basePath("/country");
		resSpec=RestUtilities.getResponseSpecification();
		
	  }
	
  @Test
  public void allCountry() {
	given()
	     .log()
	     .all()
	     .spec(reqSpec)
	.when()
	    .get(EndPoints.PATH_ALL_COUNTRY)
	.then()
	    .log()
	    .all()
	    .rootPath("RestResponse.result[0]")
	    .body("name", equalTo("Afghanistan"),
	    		"alpha2_code",equalTo("AF"),
	    		"alpha3_code",equalTo("AFG"))
	    .spec(resSpec);
  }
  
  @Test(dependsOnMethods="allCountry")
  public void countryByTwoChar() {
	given()
	     .log()
	     .all()
	     .spec(RestUtilities.createPathParameter(reqSpec, "alpha2_code", "IN"))
	.when()
	    .get(EndPoints.PATH_2CHAR_ISO)
	.then()
	    .log()
	    .all()
	    .spec(resSpec);
  }
 @Test(dependsOnMethods="countryByTwoChar")
  public void countryByThreeChar() {
	given()
	     .log()
	     .all()
	     .spec(RestUtilities.createPathParameter(reqSpec, "alpha3_code", "AUS"))
	.when()
	    .get(EndPoints.PATH_3CHAR_ISO)
	.then()
	    .log()
	    .all()
	    .spec(resSpec);
  }
  
  @Test(dependsOnMethods="countryByThreeChar")
  public void countryByAnyChar() {
	given()
	     .log()
	     .all()
	     .spec(RestUtilities.createQueryParameter(reqSpec, "text", "pa"))
	.when()
	    .get(EndPoints.PATH_ANYCHAR_ISO)
	.then()
	    .log()
	    .all()
	    .spec(resSpec);
  }

}
