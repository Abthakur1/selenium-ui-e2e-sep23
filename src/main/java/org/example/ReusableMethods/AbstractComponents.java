package org.example.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AbstractComponents {

    WebDriver driver;

    public AbstractComponents(WebDriver driver) {
        this.driver = driver;

    }

    public void waitForElementToAppear(WebElement element, int waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void selectValueFromDropDown(WebElement ele, String option, int waitTime) {
        this.waitForElementToAppear(ele, waitTime);
        Select sel = new Select(ele);
        sel.selectByVisibleText(option);
    }

    public void enterStringValueInEditBox(WebElement ele, String text, int waitTime) {
        this.waitForElementToAppear(ele, waitTime);
        ele.sendKeys(text);
    }

    public void clickOnButton(WebElement ele, int waitTime) {
        this.waitForElementToAppear(ele, waitTime);
        ele.click();
    }

    public String getTextFromTextField(WebElement ele, int waitTime) {
        this.waitForElementToAppear(ele, waitTime);
        return  ele.getText();
    }

    public int returnTotalElements(List<WebElement> elements, int waitTime) {
        try {
            this.waitForElementToAppear(elements.get(0), waitTime);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return elements.size();
    }

    public void scrollDownOnPage () {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,1000)");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
}
