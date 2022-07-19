import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Validate if Add Place API is working as expected or not
		
		//Below are the method
		
		//Given :: All input details : Parameter,body,Header,Authorise
		//When :: SUBMIT THE API :: Resource and http method
		//Then :: Validate the response 
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		given().log().all().queryParam("key","qaclick123").header("Content-type","application/json")
		.body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}")
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200);
		
		
		

	}

}
