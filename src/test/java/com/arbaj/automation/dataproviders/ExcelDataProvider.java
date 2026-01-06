package com.arbaj.automation.dataproviders;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

	@DataProvider(name = "loginData")
	public static Object[][] loginData() 
	{
	    return ExcelMapper.mapToLoginData(
	        "src/test/resources/testdata/LoginData.xlsx",
	        "Sheet1"
	    );
	}
	
}
