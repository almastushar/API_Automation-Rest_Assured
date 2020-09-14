package APICollection;

import static io.restassured.RestAssured.given;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class API_PutRequest {
	
	JSONObject request = new JSONObject();
	
	String Name = RandomStringUtils.randomAlphabetic(12);
	String Image = RandomStringUtils.randomAlphabetic(24);
	String Age = RandomStringUtils.randomNumeric(2);
	String DateofBirth = "1990-01-01";
	String Mobile = "011" + RandomStringUtils.randomNumeric(9);
	String Email = RandomStringUtils.randomAlphabetic(12)+ "@email.com";
	String Password = RandomStringUtils.randomAlphanumeric(6, 12);
	
	@Test
	public void PutRequestTest() {
	request.put("Name", Name);
	request.put("Image", Image);
	request.put("Age", Age);
	request.put("DateofBirth", DateofBirth);
	request.put("Mobile", Mobile);
	
	given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toString()).
		queryParam("RequestTitle", "UpdateEmployeeDetails").
		queryParam("EID", "860").
	when().
		put("https://almashossain.com/APP/VIEWS/API.php").	
	then().
		statusCode(200).
		log().all();
		
	}

}
