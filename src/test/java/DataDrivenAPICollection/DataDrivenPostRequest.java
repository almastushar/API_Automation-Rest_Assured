package DataDrivenAPICollection;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.*;

import All_Utils.ExcelUtil;
import io.restassured.http.ContentType;

public class DataDrivenPostRequest {
	
	JSONObject request = new JSONObject();
	
	@Test(dataProvider="empdataprovider")
	public void PostRequestTest(String Name, String Image, String Age, String DateofBirth, String Mobile, String Email, String Password) {
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
	
	@DataProvider(name="empdataprovider")
	String [][] getEmpdata() throws IOException{
		String excelPath = "./API_Data/TestData.xlsx";
		String sheetName = "Data1";
		
		ExcelUtil excel = new ExcelUtil();
		
		int rownum = excel.getRowCount(excelPath, sheetName);
		int colcount = excel.getCellCount(excelPath, sheetName,1);
		
		String empdata[][] = new String[rownum][colcount]; 
		
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				empdata[i-1][j] = excel.getCellData(excelPath, sheetName, i, j);
				
			}
			
		}
		
		return(empdata);
	}
}
