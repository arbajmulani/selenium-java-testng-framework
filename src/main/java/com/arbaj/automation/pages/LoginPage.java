package com.arbaj.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.arbaj.automation.models.LoginData;
import com.arbaj.automation.utils.ElementActions;
import com.arbaj.automation.utils.WaitUtils;

public class LoginPage {
	
	 private WebDriver driver;
	 private WaitUtils wait;
	 private ElementActions actions;
	 
	    // Constructor
	    public LoginPage(WebDriver driver) 
	    {
	        this.driver = driver;
	        this.wait = new WaitUtils(driver);
	        this.actions = new ElementActions(driver);
	        
	    }
	    
	 // Locators
	    private By searchBox = By.name("q");
        private By usernameField = By.id("username");
        private By passwordField = By.id("password");
        private By loginButton = By.cssSelector("button[type='submit']");
        private By txt_YouLoggedInSecureArea = By.id("flash");
        private By txt_WelcomeToSecureArea= By.xpath("//*[@id=\"content\"]/div/h4");
        private By btnLogout = By.xpath("//*[@id=\"content\"]/div/a");

	    // Actions
	    public void search(String text) 
	    {
	        driver.findElement(searchBox).sendKeys(text);
	    }
	    
	    public void login(String componentName, LoginData data )
	    {
	    	actions.enterText(componentName, usernameField, data.getUsername(), 30);
	    	actions.enterText(componentName, passwordField, data.getPassword(), 30);
            actions.clickWebElement(componentName, loginButton, 30);

	    }
	    
	    public void VerifyLuanchData(String componentName, LoginData data )
	    {
	    	actions.verifyText(componentName, txt_WelcomeToSecureArea, data.getExpectedMessage(), 30);
            actions.isElementPresent(componentName, btnLogout, 30);

	    }
	    
	    public boolean isLoginSuccessful(String expectedMessage) {
	        String actualMessage =driver.findElement(txt_YouLoggedInSecureArea).getText();
	        return actualMessage.contains(expectedMessage);
	    }

	    public String getPageTitle() 
	    {
	    	wait.waitForTitleContains("The Internet");
	        return driver.getTitle();
	    }

}
