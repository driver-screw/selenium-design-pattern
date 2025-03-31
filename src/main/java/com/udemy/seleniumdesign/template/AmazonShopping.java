package com.udemy.seleniumdesign.template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonShopping extends ShoppingTemplate {

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(css = ".nav-input")
    private WebElement searchBtn;

    @FindBy(css = ".a-size-medium")
    private WebElement item;

    @FindBy(id = "priceblock_ourprice")
    private WebElement price;


    private WebDriver driver;
    private WebDriverWait wait;
    private String product;

    public AmazonShopping(final WebDriver driver, String product) {
        this.driver = driver;
        this.product = product;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @Override
    public void launchSite() {
        driver.get("https://www.amazon.com");
    }

    @Override
    public void searchForProduct() {
        searchBox.sendKeys(product);
        searchBtn.click();
    }

    @Override
    public void selectProduct() {
        wait.until(_ -> item.isDisplayed());
        item.click();
    }

    @Override
    public void buy() {
        wait.until(_ -> price.isDisplayed());
        System.out.println(price.getText());
    }
}
