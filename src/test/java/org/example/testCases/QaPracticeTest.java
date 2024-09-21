package org.example.testCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.example.pageObjects.QApracticeApp.HomePg;
import org.example.pageObjects.QApracticeApp.ShoppingCartPage;
import org.example.testComponents.BaseTest;
import org.example.testComponents.ExtentReportsTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class QaPracticeTest extends BaseTest {
    WebDriver driver;
    ExtentReports extentObject;
    ExtentTest extentTest;
    HomePg hmPg;
    ShoppingCartPage shoppingCartPg;

    @BeforeTest
    public void reportConfig() {
        extentObject = ExtentReportsTest.getReportObject();
        extentTest = extentObject.createTest("Test case execution");
    }

    @BeforeMethod
    public void LaunchApp(){
        this.driver = initializeDriver();
        this.hmPg = new HomePg(this.driver);
        this.shoppingCartPg = new ShoppingCartPage(this.driver);
        launchApp();
    }

    @Test
    public void login_positive() {
        hmPg.loginToQaApp("admin@admin.com", "admin123", 10);
        Assert.assertEquals(this.shoppingCartPg.getLoggedInTitle(10), "SHOPPING CART");
        this.captureScreenshot("src/test/screenshots/loginPassed.png");
        extentTest.addScreenCaptureFromPath("src/test/screenshots/loginPassed.png");
        extentTest.log(Status.INFO, "Login success");
    }
    @Test
    public void login_negative() {
        hmPg.loginToQaApp("admin@admin.com", "wrongPassword", 10);
        Assert.assertEquals(this.hmPg.getMessageFromLoginPage(10),"Bad credentials! Please try again! Make sure that you've registered.");
        this.captureScreenshot("src/test/screenshots/loginFailed.png");
        extentTest.addScreenCaptureFromPath("src/test/screenshots/loginFailed.png");
        extentTest.log(Status.INFO, "Login failed");

    }

    @AfterMethod
    public void postTest() {

        driver.quit();

    }

    @AfterTest
    public void flush() {
        extentObject.flush();
    }
}
