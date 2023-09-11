package org.example.pageObjects;

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

    @FindBy(id = "userEmail")
    WebElement edtUserEmail;
    @FindBy(id = "userPassword")
    WebElement edtPassword;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement btnLogin;

    public void loginToApp(String email, String pswd) {
        waitForElementToAppear(this.edtUserEmail);
        this.edtUserEmail.sendKeys(email);
        this.edtPassword.sendKeys(pswd);
        this.btnLogin.click();
    }
}
