import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.Payload;
import files.ReusableMehthods;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Validate if Add Place API is working as expected or not
		
		//Below are the method
		
		//Given :: All input details : Parameter,body,Header,Authorise
		//When :: SUBMIT THE API :: Resource and http method
		//Then :: Validate the response 
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		String response=given().log().all().queryParam("key","qaclick123").header("Content-type","application/json")
		.body(Payload.AddPlace())
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("server","Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		JsonPath js =new JsonPath(response); //Jsonpath will take string as a input and change into json :: For parsing json
		String place_id=js.getString("place_id");
		System.out.println("Place_id : "+place_id);
		
		
		
		// Update Place
		
		String newAddress="summer Walk, Africa";
		
		given().log().all().queryParam("place_id", place_id).queryParam("Key", "qaclick123").header("Content-Type","application/json").body("{\r\n"
				+ "\"place_id\":\""+place_id+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}").when().put("maps/api/place/update/json").then().log().all().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated"));
		
		//Get Place
		
		String expacted_Address=given().log().all().queryParam("place_id", place_id).queryParam("key", "qaclick123").when().get("maps/api/place/get/json").then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath as=ReusableMehthods.rawtoJson(expacted_Address);
		String actualAddress=as.get("address");
		System.out.println(actualAddress);
		//Junit,Testng
		Assert.assertEquals(actualAddress, newAddress);
		
		
		
		

		
		
		

	}

}
