package com.arbaj.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports getExtentReport() {
        if (extent == null) {

            String reportPath =
                System.getProperty("user.dir") + "/test-output/ExtentReport.html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

            spark.config().setReportName("Automation Test Report");
            spark.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Project", "Selenium Java TestNG Framework");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        }
        return extent;
    }

}
