package com.udemy.seleniumdesign.template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EbayShopping extends ShoppingTemplate {

    @FindBy(id = "gh-ac")
    private WebElement searchBox;

    @FindBy(id = "gh-search-btn")
    private WebElement searchBtn;

    @FindBy(css = ".su-card-container__content  .su-link .primary")
    private WebElement item;

    @FindBy(css = ".x-price-primary")
    private WebElement price;


    private WebDriver driver;
    private WebDriverWait wait;
    private String product;

    public EbayShopping(final WebDriver driver, String product) {
        this.driver = driver;
        this.product = product;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @Override
    public void launchSite() {
        driver.get("https://www.ebay.com");
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
