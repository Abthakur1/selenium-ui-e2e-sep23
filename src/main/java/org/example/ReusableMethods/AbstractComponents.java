package org.example.ReusableMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class AbstractComponents {

    WebDriver driver;

    public AbstractComponents(WebDriver driver) {
        this.driver = driver;

    }

    public void waitForElementToAppear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        return true;

    }

    public void selectValueFromDropDown(WebElement ele, String option) {
        this.waitForElementToAppear(ele);
        Select sel = new Select(ele);
        sel.selectByVisibleText(option);
    }

    public void enterStringValueInEditBox(WebElement ele, String text) {
        this.waitForElementToAppear(ele);
        ele.sendKeys(text);
    }

    public void clickOnButton(WebElement ele) {
        this.waitForElementToAppear(ele);
        ele.click();
    }

    public String getTextFromTextField(WebElement ele) {
        this.waitForElementToAppear(ele);
        return  ele.getText();
    }

    public int returnTotalElements(List<WebElement> elements) {
        try {
            this.waitForElementToAppear(elements.get(0));
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
