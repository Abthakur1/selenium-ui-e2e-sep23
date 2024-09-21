package org.example.pageObjects.QApracticeApp;

import org.example.ReusableMethods.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends AbstractComponents {
    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//h2[@class='section-header']")
    WebElement shoppingCartTitle;

    public String getLoggedInTitle(int waitTime) {
        String successLoginText = this.getTextFromTextField(this.shoppingCartTitle, waitTime);
        return successLoginText;
    }
}
