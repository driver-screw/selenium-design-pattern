package com.udemy.seleniumdesign.template.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonProductDescriptionPage {

    @FindBy(id = "priceblock_ourprice")
    private WebElement price;

    private WebDriver driver;
    private WebDriverWait wait;

    public AmazonProductDescriptionPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    public void buy() {
        wait.until(_ -> price.isDisplayed());
        System.out.println(price.getText());
    }
}
