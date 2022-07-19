package files;

import io.restassured.path.json.JsonPath;

public class ReusableMehthods {
	
	public static JsonPath rawtoJson(String response) {
		
		JsonPath js1= new JsonPath(response);
		return js1;
		
	}

}
