package org.example.pageObjects;

import org.example.ReusableMethods.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserStackHomePg extends AbstractComponents {

    WebDriver driver;

    public BrowserStackHomePg(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@value='Apple']")
    WebElement appleOptionChkBox;

    @FindBy(xpath = "(//div[text()='Add to cart'])[1]")
    WebElement addToCartBtn;

    @FindBy(xpath= "//div[@class='sort']//select") WebElement orderByFilterDropdown;

    public void selectAppleOption() {
        this.appleOptionChkBox.click();
    }

    public void addToCart(){
        this.addToCartBtn.click();
    }

    public void selectOrderFilter(String option){
        selectValueFromDropDown(this.orderByFilterDropdown,option);
    }

}
