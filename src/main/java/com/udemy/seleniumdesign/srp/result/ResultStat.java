package com.udemy.seleniumdesign.srp.result;

import com.udemy.seleniumdesign.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ResultStat extends AbstractComponent {
    @FindBy(id = "resultStat")
    private WebElement resultStat;


    public ResultStat(WebDriver driver) {
        super(driver);
    }

    public String getStat() {
        return resultStat.getText();
    }

    @Override
    public boolean isDisplayed() {
        return wait.until(_ -> resultStat.isDisplayed());
    }
}
