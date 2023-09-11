package org.example.pageObjects.OrangeHRM;

import org.example.ReusableMethods.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPg extends AbstractComponents {
    WebDriver driver;

    public LoginPg(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement usernameEdt;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordEdt;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;
    @FindBy(xpath = "//div[@class='orangehrm-login-error']//p[contains(@class,'oxd-alert-content-text')]")
    WebElement errorMsg;

    public void loginToOrangeHRMApp(String username, String password) {
        enterStringValueInEditBox(this.usernameEdt, username);
        enterStringValueInEditBox(this.passwordEdt, password);
        clickOnButton(this.loginBtn);
    }

    public String invalidLoginAlert () {
        return getTextFromTextField(this.errorMsg);
    }
}
