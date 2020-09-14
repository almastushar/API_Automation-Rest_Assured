package Utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import All_Utils.ExcelUtil;
import All_Utils.ExcelUtils;

public class ExcelUtilsTest {
	
	String path = System.getProperty("user.dir");
	String excelPath = path + "./API_Data/TestData.xlsx";
	String sheetName = "Data1";
	
	ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

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
