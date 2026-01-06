package com.arbaj.automation.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ElementActions {
	
	private WebDriver driver;
	private WaitUtils wait;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }
    
    /* ========================= Enter Text ========================= */

    public void enterText(String componentName, By locator, String text, int timeout) 
    {
        try {
            // 1️WAIT
            WebElement element = wait.waitForElementVisible(locator, timeout);
            // 2️SCROLL
            scrollIntoView(element);

            // 3️HIGHLIGHT (YELLOW)
            highlight(element, "yellow");

            element.clear();
            element.sendKeys(text);

            // 4️LOG SUCCESS
            TestLogger.logStep(
                    componentName,
                    "EnterText",
                    locator.toString(),
                    "PASS",
                    text,
                    "Text entered successfully"
            );
        } catch (Exception ex) {
            highlightOnFailure(locator);
            ScreenshotUtils.captureScreenshot(driver, componentName);

            TestLogger.logStep(
                    componentName,
                    "EnterText",
                    locator.toString(),
                    "FAIL",
                    text,
                    ex.getMessage()
            );

            throw ex; 
        }
    }
    
    /* ========================= Click ========================= */

    public void clickWebElement(String componentName, By locator, int timeout) 
    {
        try {

            WebElement element = wait.waitForElementClickable(locator, timeout);

            scrollIntoView(element);
            highlight(element, "yellow");

            element.click();

            TestLogger.logStep(
                    componentName,
                    "Click",
                    locator.toString(),
                    "PASS",
                    "",
                    "Element clicked successfully"
            );
        } catch (Exception ex) {
            highlightOnFailure(locator);
            ScreenshotUtils.captureScreenshot(driver, componentName);

            TestLogger.logStep(
                    componentName,
                    "Click",
                    locator.toString(),
                    "FAIL",
                    "",
                    ex.getMessage()
            );

            throw ex;
        }
    }

    /* ========================= Verify Text ========================= */

    public void verifyText(String componentName, By locator, String expectedText, int timeout) 
    {
        try {
            WebElement element = wait.waitForElementVisible(locator, timeout);

            scrollIntoView(element);
            highlight(element, "yellow");

            String actualText = element.getText().trim();

            if (!actualText.equals(expectedText.trim())) {
                highlight(element, "red");
                ScreenshotUtils.captureScreenshot(driver, componentName);

                TestLogger.logStep(
                        componentName,
                        "VerifyText",
                        locator.toString(),
                        "FAIL",                     
                        "Text mismatch",
                        "Expected: " + expectedText + " | Actual: " + actualText
                );

                Assert.fail("Text verification failed");
            }

            TestLogger.logStep(
                    componentName,
                    "VerifyText",
                    locator.toString(),
                    "PASS",
                    expectedText,
                    "Text verified successfully"
            );

        } catch (Exception ex) {
            throw ex;
        }
    }

    /* ========================= Verify Contains Text ========================= */

    public void verifyTextContains(String componentName, By locator, String expectedPartial, int timeout) {
        try {
        	WebElement element = wait.waitForElementVisible(locator, timeout);

            scrollIntoView(element);
            highlight(element, "yellow");

            String actualText = element.getText().trim();

            if (!actualText.contains(expectedPartial)) {
                highlight(element, "red");
                ScreenshotUtils.captureScreenshot(driver, componentName);

                Assert.fail(
                        "Expected text to contain [" + expectedPartial + "] but found [" + actualText + "]"
                );
            }

            TestLogger.logStep(
                    componentName,
                    "VerifyTextContains",
                    locator.toString(),
                    "PASS",
                    expectedPartial,
                    "Partial text verified successfully"
            );

        } catch (Exception ex) {
            throw ex;
        }
    }

    /* ========================= Is Element Present ========================= */

    public void isElementPresent(String componentName, By locator, int timeout) {
        try {
        	WebElement element = wait.waitForElementVisible(locator, timeout);

            scrollIntoView(element);
            highlight(element, "yellow");

            TestLogger.logStep(
                    componentName,
                    "IsElementPresent",
                    locator.toString(),
                    "PASS",
                    "N/A",
                    "Element is present"
            );
        } catch (Exception ex) {
            ScreenshotUtils.captureScreenshot(driver, componentName);

            TestLogger.logStep(
                    componentName,
                    "IsElementPresent",
                    locator.toString(),
                    "FAIL",
                    "N/A",
                    ex.getMessage()
            );

            throw ex;
        }
    }
    
    
    
    /* ========================= Helper Methods ========================= */



    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    private void highlight(WebElement element, String color) {
        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].style.border='3px solid " + color + "'",
                        element
                );
    }

    private void highlightOnFailure(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            highlight(element, "red");
        } catch (Exception ignored) {}
    }

}
