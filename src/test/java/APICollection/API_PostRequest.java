package APICollection;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.apache.commons.lang3.*;
import org.json.simple.JSONObject;
import org.testng.annotations.*;

import io.restassured.http.ContentType;

public class API_PostRequest {
	JSONObject request = new JSONObject();
	
	String Name = RandomStringUtils.randomAlphabetic(12);
	String Image = RandomStringUtils.randomAlphabetic(24);
	String Age = RandomStringUtils.randomNumeric(2);
	String DateofBirth = "1990-01-01";
	String Mobile = "011" + RandomStringUtils.randomNumeric(9);
	String Email = RandomStringUtils.randomAlphabetic(12)+ "@email.com";
	String Password = RandomStringUtils.randomAlphanumeric(6, 12);
	
	@Test
	public void PostRequestTest() {
	request.put("Name", Name);
	request.put("Image", Image);
	request.put("Age", Age);
	request.put("DateofBirth", DateofBirth);
	request.put("Mobile", Mobile);
	request.put("Email", Email);
	request.put("Password", Password);
	given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toString()).
	when().
		post("https://almashossain.com/APP/VIEWS/API.php?RequestTitle=EmployeeRegistration").
	then().
		statusCode(200).
		log().all();
		
	}

}
