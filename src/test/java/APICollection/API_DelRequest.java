package APICollection;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class API_DelRequest {
	
	@Test
	public void PutRequestTest() {
	
	given().
		queryParam("RequestTitle", "DeleteEmployee").
		queryParam("EID", "860").
	when().
		delete("https://almashossain.com/APP/VIEWS/API.php").	
	then().
		statusCode(200).
		log().all();
		
	}

}
