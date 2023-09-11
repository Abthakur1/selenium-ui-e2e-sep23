package org.example.pageObjects.OrangeHRM;

import org.example.ReusableMethods.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPg extends AbstractComponents {
    WebDriver driver;

    public DashboardPg(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[@class='orangehrm-attendance-card-profile-record']/p")
    WebElement attendanceRecordEle;
    @FindBy(css = ".oxd-pie-chart")
    List<WebElement> pieChartsEle;

    public String attendanceRecord() {
        return getTextFromTextField(this.attendanceRecordEle);
    }

    public int totalPieChartsAvailable() {
        scrollDownOnPage();
        return returnTotalElements(pieChartsEle);
    }
}
