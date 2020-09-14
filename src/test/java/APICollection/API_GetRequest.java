package APICollection;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.core.IsEqual;
import org.testng.annotations.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class API_GetRequest {
	
	@Test
	public void GetRequestTest() {
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			get("https://almashossain.com/APP/VIEWS/API.php?RequestTitle=SingleEmployeeDetails&&EID=860").
		then().
			statusCode(200).
			//log().all().
			body("EID[0]",equalTo("861")).
			body("Name",hasItems("783n18", "Mrs. Darrick Mohr", "Dr. Eldridge Wilkinson")).
			log().all();
		
	}
	
	//@Test
	public void GetRequestTest_SetVariable() {
		String var = given().
							header("Content-Type","application/json").
							contentType(ContentType.JSON).
							accept(ContentType.JSON).
							get("https://almashossain.com/APP/VIEWS/API.php?RequestTitle=ViewAllEmployees").
						then().
							statusCode(200).
							assertThat().
							extract().
							path("Email[0]");
		System.out.println(var);
		
	}
}
