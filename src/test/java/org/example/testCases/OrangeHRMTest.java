package org.example.testCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.example.pageObjects.OrangeHRM.DashboardPg;
import org.example.pageObjects.OrangeHRM.LoginPg;
import org.example.testComponents.BaseTest;
import org.example.testComponents.ExtentReportsTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class OrangeHRMTest extends BaseTest {
    WebDriver driver;
    ExtentReports extentObject;
    ExtentTest extentTest;
    LoginPg loginPagObj;
    DashboardPg dashboardpg;

    @BeforeTest
    public void reportConfig() {
        extentObject = ExtentReportsTest.getReportObject();
        extentTest = extentObject.createTest("Test case execution");
    }

    @BeforeMethod
    public void LaunchApp(){
        this.driver = initializeDriver();
        this.loginPagObj = new LoginPg(this.driver);
        this.dashboardpg = new DashboardPg(this.driver);
        launchApp();
    }

    @Test
    public void regression_login() {
        loginPagObj.loginToOrangeHRMApp("Admin","admin123");
        extentTest.log(Status.INFO, "Enter username Admin and password admin123");

    }

    @Test
    public void regression_login_invalid(){
        loginPagObj.loginToOrangeHRMApp("absk","test123");
        String actualMsg = loginPagObj.invalidLoginAlert();
        Assert.assertEquals(actualMsg,"Invalid credentials");
        extentTest.log(Status.INFO, "Invalid credentials validation with username absk");

    }

    @Test
    public void regression_dashboardValidate() {
        loginPagObj.loginToOrangeHRMApp("Admin","admin123");
        String attendanceRecordMessage = dashboardpg.attendanceRecord();
        Assert.assertEquals(attendanceRecordMessage, "Punched In");
        int totalPieCharts = dashboardpg.totalPieChartsAvailable();
        Assert.assertEquals(totalPieCharts,2);

    }

    @AfterMethod
    public void postTest() {
        this.driver.close();
    }

    @AfterTest
    public void flush() {
        extentObject.flush();
    }
}
