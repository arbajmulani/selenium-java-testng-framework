package com.arbaj.automation.dataproviders;

import org.testng.annotations.DataProvider;

public class JsonDataProvider {
	
	 @DataProvider(name = "loginJsonData")
	    public static Object[][] getLoginJsonData() 
	 {

	        String filePath =
	            "src/test/resources/testdata/loginData.json";

	        return JsonMapper.mapToLoginData(filePath);
	    }

}
