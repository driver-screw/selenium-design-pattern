package com.udemy.seleniumdesign.strategy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class NetBankingPaymentOption implements PaymentOption {

    @FindBy(id = "bank")
    private WebElement bank;

    @FindBy(id = "acc_number")
    private WebElement accountNumber;

    @FindBy(id = "pin")
    private WebElement pin;

    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) {
        Select bankDropdown = new Select(bank);
        bankDropdown.selectByValue(paymentDetails.get("bank"));
        accountNumber.sendKeys(paymentDetails.get("year"));
        pin.sendKeys(paymentDetails.get("cvv"));
    }
}
