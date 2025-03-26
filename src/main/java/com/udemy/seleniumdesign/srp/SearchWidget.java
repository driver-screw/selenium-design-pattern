package com.udemy.seleniumdesign.srp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class SearchWidget extends AbstractComponent{

    private WebDriverWait wait;
    
    @FindBy(name="q")
    private WebElement searchBox;

    public SearchWidget(final WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.of(30, ChronoUnit.SECONDS));
        PageFactory.initElements(driver, this);

    }

    public void enter(String keyword) {
        searchBox.clear();
        searchBox.sendKeys(keyword);
    }


    @Override
    public boolean isDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        return searchBox.isDisplayed();
    }
}
