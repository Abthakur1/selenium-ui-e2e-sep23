package org.example.testComponents;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
     static String url;

    public WebDriver initializeDriver() {

        Properties prop = new Properties();
        FileInputStream file;
        try {
            file = new FileInputStream("src/main/java/org/example/globalProperties/config.properties");
            prop.load(file);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String browserName = prop.getProperty("browser");
            url = prop.getProperty("url");
        if (browserName.equals("chrome"))
            driver = new ChromeDriver();
        else if (browserName.equals("edge"))
            driver = new EdgeDriver();
        else if(browserName.equals("headless")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
        return driver;

    }

    public void launchApp() {
        driver.get(this.url);
    }

    public void captureScreenshot(String localPathOfScreenshot){
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(localPathOfScreenshot);
        try {
            FileUtils.copyFile(source,destination);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
