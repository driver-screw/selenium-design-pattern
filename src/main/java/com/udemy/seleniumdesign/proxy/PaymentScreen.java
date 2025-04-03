package com.udemy.seleniumdesign.proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class PaymentScreen {

    private WebDriver driver;
    private UserInformationComponent userInformation;
    private OrderComponent orderComponent;
    private PaymentOption paymentOption;

    public PaymentScreen(final WebDriver driver) {
        this.driver = driver;
        userInformation = PageFactory.initElements(driver, UserInformationComponent.class);
        orderComponent = new OrderComponentProxy(driver);
    }

    public void goTo() {
        driver.get("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
    }

    public UserInformationComponent getUserInformation() {
        return userInformation;
    }

    public OrderComponent getOrder() {
        return orderComponent;
    }

    public void setPaymentOption(PaymentOption paymentOption) {
        this.paymentOption = paymentOption;
        PageFactory.initElements(driver, this.paymentOption);
    }

    public void pay(Map<String, String> paymentDetails) {
        paymentOption.enterPaymentInformation(paymentDetails);
    }
}
