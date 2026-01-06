package com.arbaj.automation.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.arbaj.automation.base.BaseTest;
import com.arbaj.automation.dataproviders.ExcelDataProvider;
import com.arbaj.automation.dataproviders.JsonDataProvider;
import com.arbaj.automation.models.LoginData;
import com.arbaj.automation.pages.LoginPage;


public class LoginTest extends BaseTest{
	
	@Test
    public void verifyHomePageTitle() {
		LoginPage loginPage = new LoginPage(driver);

        String actualTitle = loginPage.getPageTitle();
        System.out.println("Page title is: " + actualTitle);

        Assert.assertEquals(actualTitle, "The Internet",
                "Home page title does not match!");
    }
	
	//Excel Testcase
	
	@Test(dataProvider = "loginData", dataProviderClass = ExcelDataProvider.class)
	public void loginTestWithExcel(LoginData data) 
	{
	    LoginPage loginPage = new LoginPage(driver);
	    String componentName = new Object() {}.getClass().getEnclosingMethod().getName();
	    loginPage.login(componentName,data);
//	    loginPage.VerifyLuanchData(componentName,data);

	}
	
	
    // Json Testcase
	
	@Test(dataProvider = "loginJsonData",dataProviderClass = JsonDataProvider.class)
	public void loginTestWithJson(LoginData loginData) 
	{

	    LoginPage loginPage = new LoginPage(driver);
	    String componentName = new Object() {}.getClass().getEnclosingMethod().getName();
	    loginPage.login(componentName,loginData);
	    loginPage.VerifyLuanchData(componentName,loginData);

	}

}
