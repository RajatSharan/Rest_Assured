import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
	
	public static void main(String []args) {

	JsonPath js1=new JsonPath(Payload.coursePrice());
	
	//1. Print No of courses returned by API
	
	int count=js1.getInt("courses.size()");
	System.out.println(count);
	
	//2.Print Purchase Amount
	
	int purchaseAmount= js1.getInt("dashboard.purchaseAmount");
	System.out.println(purchaseAmount);
	
	//3.Print Title of the first course
	
	String Title= js1.getString("courses[0].title");
	System.out.println(Title);
	
	
	//4. Print All course titles and their respective Prices
	
	for(int i=0;i<count;i++) {
		
		String courseTitle=js1.get("courses["+i+"].title");
		 System.out.println(js1.get("courses["+i+"].price").toString());
		System.out.println(courseTitle);	
		
	}
	
	System.out.println("Print number of copies sold by RPA Courses");
	
	for(int i=0;i<count;i++) {
		
		String courseTitle=js1.get("courses["+i+"].title");
		 if(courseTitle.equalsIgnoreCase("Appium")) {
			 
			 int copies=js1.get("courses["+i+"].copies");
			 System.out.println(copies);
			 break;
			 
		 }
		
	}
}
}