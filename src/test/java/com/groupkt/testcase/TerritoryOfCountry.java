package com.groupkt.testcase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.groupkt.common.EndPoints;
import com.groupkt.constant.RestUtilities;
import static io.restassured.RestAssured.*;


import java.util.HashMap;
import java.util.Map;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class TerritoryOfCountry {
	
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	Map<String,String> paramMap;
	@BeforeMethod
	  public void beforeClass() {
		reqSpec=RestUtilities.getRequestSpecification();
		reqSpec.basePath("/state");
		resSpec=RestUtilities.getResponseSpecification();
		
	  }
	
 @Test
  public void allState() {
	  given()
	     .log()
	     .all()
	     .spec(RestUtilities.createPathParameter(reqSpec, "countryCode", "IND"))
	   .when()
	     .get(EndPoints.PATH_ALL_STATE)
	   .then()
	     .log()
	     .all()
	     .spec(resSpec);
	  
  }
  
 @Test
  public void searchStateByCountry() {
	 paramMap=new HashMap<String, String>();
	 paramMap.put("countryCode", "IND");
	 paramMap.put("stateCode", "UP");
	  given()
	     .log()
	     .all()
	     .spec(RestUtilities.createPathParameter(reqSpec, paramMap))
	   .when()
	     .get(EndPoints.PATH_STATE_COUNTRY)
	   .then()
	     .log()
	     .all()
	     .spec(resSpec);
	  
  }
  
  @Test
  public void searchStateByText() {
	//  http://services.groupkt.com/state/search/{countryCode}?text={text to search}
	  reqSpec.pathParam("countryCode", "IND");
	  given()
	     .log()
	     .all()
	     .spec(RestUtilities.createQueryParameter(reqSpec, "text", "chal"))
	   .when()
	     .get(EndPoints.PATH_STATE_SEARCH_TEXT)
	   .then()
	     .log()
	     .all()
	     .spec(resSpec);
	  
  }
}
