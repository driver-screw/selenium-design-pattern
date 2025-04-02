package com.udemy.seleniumdesign.template.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonResultsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public AmazonResultsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @FindBy(css = ".s-result-item .puisg-row .a-link-normal")
    private WebElement item;

    public void selectProduct() {
        wait.until(_ -> item.isDisplayed());
        item.click();
    }
}
