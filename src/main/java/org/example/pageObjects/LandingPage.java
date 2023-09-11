package org.example.pageObjects;

import org.example.ReusableMethods.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponents {

    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//button[contains(@routerlink,'dashboard')])[1]")
    WebElement btnHome;

    @FindBy(xpath = "//error")
    WebElement btnForError;

    public void gotoHome() {

        try {
            waitForElementToAppear(this.btnHome);
            this.btnHome.click();
            waitForElementToAppear(this.btnForError);
//            this.btnForError.click();
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
