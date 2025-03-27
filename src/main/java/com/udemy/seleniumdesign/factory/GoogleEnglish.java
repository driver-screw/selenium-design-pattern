package com.udemy.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

class GoogleEnglish extends GooglePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(name = "q")
    protected WebElement searchBox;

    @FindBy(name = "btnk")
    protected WebElement searchBtn;

    @FindBy(css = "div.rc")
    protected List<WebElement> results;

    public GoogleEnglish(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @Override
    public void launchSite() {
        driver.get("https://www.google.com");
    }

    @Override
    public void search(String keyword) {
        searchBox.sendKeys(keyword);
        wait.until(_ -> searchBtn.isDisplayed());
        searchBtn.click();
    }

    @Override
    public int getResultCount() {
        wait.until(_ -> results.size() > 1);
        return results.size();
    }
}
