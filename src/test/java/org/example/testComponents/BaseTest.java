package org.example.testComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

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

        String browserName = System.getProperty("browser")!=null?  System.getProperty("browser"): prop.getProperty("browser");
        String env= System.getProperty("env")!=null? System.getProperty("env"): "qa";
        if(env.equals("dev"))
            url = prop.getProperty("devUrl");
        else if(env.equals("qa"))
            url = prop.getProperty("qaUrl");
        else if(env.equals("uat"))
            url = prop.getProperty("uatUrl");
        else
            url = prop.getProperty("url");
        //ChromeOptions options = new ChromeOptions();
       // options.addArguments("headless");
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
        driver.manage().window().maximize();
        return driver;

    }

    public void launchApp() {
//        driver = initializeDriver();
        driver.get(this.url);
    }
}
