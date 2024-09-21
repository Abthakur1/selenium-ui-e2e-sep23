package org.example.pageObjects.QApracticeApp;

import org.example.ReusableMethods.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePg extends AbstractComponents {
    WebDriver driver;

    public HomePg(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//input[@id = 'email']")
    WebElement usernameEdt;
    @FindBy(xpath = "//input[@id = 'password']")
    WebElement passwordEdt;
    @FindBy(id = "auth-shop")
    WebElement authOptionBtn;
    @FindBy(id = "submitLoginBtn")
    WebElement loginSubmitBtn;
    @FindBy(xpath = "//div[@id='loginSection']//div[@id='message']")
    WebElement messageLoginPage;

    public void loginToQaApp(String username, String password, int waitTime) {
        this.clickOnButton(authOptionBtn, waitTime);
        this.enterStringValueInEditBox(usernameEdt, username, waitTime);
        this.enterStringValueInEditBox(passwordEdt, password, waitTime);
        this.clickOnButton(loginSubmitBtn, waitTime);
    }

    public String getMessageFromLoginPage(int waitTime ) {
        return this.getTextFromTextField(this.messageLoginPage, waitTime);
    }
}
