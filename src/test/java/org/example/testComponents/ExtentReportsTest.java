package org.example.testComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsTest {

    public static ExtentReports getReportObject(){
        String reportPath = System.getProperty("user.dir")+"/htmlReports/index.html";
        ExtentSparkReporter reportConfig = new ExtentSparkReporter(reportPath);
        reportConfig.config().setReportName("E2E Selenium Automation Framework 2023");
        reportConfig.config().setDocumentTitle("Automation Report HTML - June 2023");
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(reportConfig);
        return extentReports;
    }
}
