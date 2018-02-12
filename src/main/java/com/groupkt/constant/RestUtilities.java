package com.groupkt.constant;

import com.groupkt.common.Path;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.TimeUnit;
public class RestUtilities {
	
     static RequestSpecBuilder REQ_BUILd;
     static RequestSpecification REQ_SPEC;
     static ResponseSpecBuilder RES_BUILD;
     static ResponseSpecification RES_SPEC;
     
     
     /**
      * This function is all about bulid the request and return its request Specification
      * */
     
     public static RequestSpecification getRequestSpecification(){
    	 REQ_BUILd=new RequestSpecBuilder();
    	 REQ_BUILd.setBaseUri(Path.BASE_URI);
    	 return REQ_SPEC=REQ_BUILd.build();
     }
        
     /**
      *this function is all about bulid the response and retunr its response specification 
      * 
      */
        
     public static ResponseSpecification getResponseSpecification(){
    	 RES_BUILD=new ResponseSpecBuilder();
    	 RES_BUILD.expectStatusCode(200);
    	 RES_BUILD.expectResponseTime(lessThan(4L),TimeUnit.SECONDS);
    	 return RES_SPEC=RES_BUILD.build();
     }
     
     
    /**
     * this function is to create query param with single value
     * 
     * */
     
     public static RequestSpecification createQueryParameter(RequestSpecification reqSpec,String param,String value){
    	 return reqSpec.queryParam(param, value);
     }
     
     /**
      * this function is to create query param with multiple value
      * 
      * */
     
     public static RequestSpecification createQueryParameter(RequestSpecification reqSpec,Map<String,String> queryParam){
    	 return reqSpec.queryParams(queryParam);
     }
     
     /**
      * This function is to create path param with single value
      * */
     
     public static RequestSpecification createPathParameter(RequestSpecification reqSpec,String param,String value){
    	 return reqSpec.pathParam(param, value);
     }
        
   /**
    * This function is to create path param with multiple value
    * */  
     
     public static RequestSpecification createPathParameter(RequestSpecification reqSpec,Map<String,String> queryParam){
    	 return reqSpec.pathParams(queryParam);
     }
     
     /**
      * this function is to return the json path
      * 
      * */
     
     public static JsonPath getJsonPath(Response res){
    	   String resPath=res.asString();
    	   
    	   JsonPath jPath=new JsonPath(resPath);
    	   return jPath;
     }
     
     /**
      * this function is to return the xml path
      * 
      * */
     
     public static XmlPath getXmlPAth(Response res){
    	   String resPath=res.asString();
    	   
    	   XmlPath XPath=new XmlPath(resPath);
    	   return XPath;
     }

     /**
 	 * This function is to convert the json file to string
 	 * 
 	 * */
 
 	 public static String generateStringFromResource(String path) throws IOException {

 		    return new String(Files.readAllBytes(Paths.get(path)));
 		}
}
