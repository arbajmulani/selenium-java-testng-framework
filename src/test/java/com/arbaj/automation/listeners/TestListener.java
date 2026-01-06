package com.arbaj.automation.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.arbaj.automation.base.BaseTest;
import com.arbaj.automation.utils.ExtentManager;
import com.arbaj.automation.utils.ExtentTestManager;
import com.arbaj.automation.utils.ScreenshotUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestListener implements ITestListener {

	 private static ExtentReports extent = ExtentManager.getExtentReport();

	    @Override
	    public void onTestStart(ITestResult result) {
	        ExtentTest test =
	            extent.createTest(result.getMethod().getMethodName());

	        ExtentTestManager.setTest(test);
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        ExtentTestManager.getTest().pass("Test Passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        Object testClass = result.getInstance();

	        if (testClass instanceof BaseTest) {
	            BaseTest baseTest = (BaseTest) testClass;

	            String screenshotPath =
	                ScreenshotUtils.captureScreenshot(
	                    baseTest.getDriver(),
	                    result.getName()
	                );

	            ExtentTestManager.getTest()
	                .fail(result.getThrowable())
	                .addScreenCaptureFromPath(screenshotPath);
	        }
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        ExtentTestManager.getTest().skip("Test Skipped");
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }
	
}
