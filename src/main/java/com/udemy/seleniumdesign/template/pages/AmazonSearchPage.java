package com.udemy.seleniumdesign.template.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonSearchPage {

    private WebDriver driver;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchBtn;

    public AmazonSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.get("https://www.amazon.com");
    }

    public void searchForProduct(String product) {
        searchBox.sendKeys(product);
        searchBtn.click();
    }
}
