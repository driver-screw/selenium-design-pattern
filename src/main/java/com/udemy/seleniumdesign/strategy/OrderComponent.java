package com.udemy.seleniumdesign.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderComponent {

    @FindBy(id = "buy")
    private WebElement byuBtn;

    @FindBy(id = "ordernumber")
    private WebElement orderNumber;

    public OrderComponent(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String placeOrder() {
        byuBtn.click();
        return orderNumber.getText();
    }
}
