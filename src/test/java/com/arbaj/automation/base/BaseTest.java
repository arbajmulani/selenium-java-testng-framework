package com.arbaj.automation.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.arbaj.automation.driver.DriverFactory;
import com.arbaj.automation.utils.ConfigReader;

public class BaseTest {

	public WebDriver driver;
	
	 // Create GETTER for for TestListener Class
    public WebDriver getDriver() 
    {
        return driver;
    }

	@BeforeMethod
	public void setUp() {
	    System.out.println(">>> BeforeMethod started");

	    driver = DriverFactory.initDriver();
	    System.out.println(">>> Driver initialized: " + driver);

	    String url = ConfigReader.getBaseUrl();
	    System.out.println(">>> Base URL: " + url);

	    driver.get(url);
	}	

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
	
}
