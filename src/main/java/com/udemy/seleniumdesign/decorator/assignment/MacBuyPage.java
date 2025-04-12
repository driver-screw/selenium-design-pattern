package com.udemy.seleniumdesign.decorator.assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MacBuyPage {

    private WebDriver driver;

    @FindBy(id = "coupon")
    private WebElement couponField;

    @FindBy(id = "couponbtn")
    private WebElement applyCouponBtn;

    @FindBy(id = "cc")
    private WebElement creditCardNumber;

    @FindBy(id = "year")
    private WebElement cardYear;

    @FindBy(id = "cvv")
    private WebElement cardCvv;

    @FindBy(id = "price")
    private WebElement price;

    @FindBy(id = "status")
    private WebElement status;

    @FindBy(id = "buy")
    private WebElement buyBtn;

    public MacBuyPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void goTo() {
        driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-payment-screen.html");
    }

    public void applyCoupon(String couponCode) {
        couponField.sendKeys(couponCode);
        applyCouponBtn.click();
    }

    public void buy() {
        buyBtn.click();
    }

    public String getStatus() {
        return status.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public void enterCcInfo(String cardNumber, String year, String cvv) {
        creditCardNumber.sendKeys(cardNumber);
        cardYear.sendKeys(year);
        cardCvv.sendKeys(cvv);
    }
}
