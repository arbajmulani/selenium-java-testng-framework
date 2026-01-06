package com.arbaj.automation.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	public static String captureScreenshot(WebDriver driver, String testName) 
	{
        try {
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String screenshotName = testName + "_" + timestamp + ".png";

            String path = System.getProperty("user.dir")
                    + "/test-output/screenshots/" + screenshotName;

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(path);
            FileUtils.copyFile(src, dest);

            return path;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
//	 public static void captureScreenshot(WebDriver driver)
//	 {
//	        try {
//	            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//	            FileUtils.copyFile(
//	                src,
//	                new File("test-output/screenshots/" + System.currentTimeMillis() + ".png")
//	            );
//	        } catch (Exception ignored) {}
//	  }
	
}
