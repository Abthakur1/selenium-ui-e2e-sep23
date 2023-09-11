package org.example.testComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    ExtentReports extentObject; // declare extentObject to give the knowledge to listener class
    ExtentTest extentTest; // extentTest to create Test
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started:"+ result.getName());
        extentObject = ExtentReportsTest.getReportObject(); // assign the extentReport object with the
        // object created in ExtentReport class
        extentTest = extentObject.createTest(result.getName()); // create the test

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed:"+ result.getName());
        extentTest.log(Status.PASS, "Test is passed:"+ result.getName());


    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed:"+ result.getName());


    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        extentObject.flush();

    }
}
