package org.example.testCases;

import org.example.pageObjects.BrowserStackHomePg;
import org.example.testComponents.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBrowserStack extends BaseTest {
    BrowserStackHomePg hmPage;
    WebDriver driver;

    public TestBrowserStack(){
//        driver = initializeDriver();
//        hmPage = new BrowserStackHomePg(driver);

    }

    @Test(enabled = false)
    public void browserStackCoreFeatures(){
      System.out.println("Test 1 run");
        driver = initializeDriver();
        hmPage = new BrowserStackHomePg(driver);
        hmPage = new BrowserStackHomePg(driver);
        launchApp();

        hmPage.addToCart();
    }
    @AfterMethod
    public void closeApp(){
        driver.close();
    }

    /*@Test
    public void browserStackOrderSelectionTest(){
        System.out.println("Test 2 run");
        hmPage.selectOrderFilter("Highest to lowest");
    }

    @BeforeMethod
    public void initAndLaunch(){
        driver.get("https://www.bstackdemo.com/");
//        launchApp();
        System.out.println("url launched");
    }

    @AfterMethod
    public void closeApp(){
        driver.close();
    }
*/
}
