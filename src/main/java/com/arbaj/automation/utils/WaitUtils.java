package com.arbaj.automation.utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	private WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    // ✅ Default timeout (10 sec)
    public WebElement waitForElementVisible(By locator) {
        return waitForElementVisible(locator, 10);
    }

    // ✅ Custom timeout
    public WebElement waitForElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementClickable(By locator) {
        return waitForElementClickable(locator, 10);
    }

    public WebElement waitForElementClickable(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForTitleContains(String title) {
        waitForTitleContains(title, 10);
    }

    public void waitForTitleContains(String title, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.titleContains(title));
    }

}
