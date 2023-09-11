package org.example;

import org.example.pageObjects.LandingPage;
import org.example.pageObjects.LoginPg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSample1 {

    public static void main(String[] args) {
        WebDriver driver;
        driver = new ChromeDriver();
        LandingPage lpage = new LandingPage(driver);
        LoginPg loginpage = new LoginPg(driver);
        driver.get("https://rahulshettyacademy.com/client/");
        loginpage.loginToApp("absk.cts@gmail.com", "Automation@2023");
        lpage.gotoHome();
        System.out.println("Done");
    }

}
