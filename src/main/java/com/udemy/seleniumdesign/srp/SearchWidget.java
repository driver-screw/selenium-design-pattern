package com.udemy.seleniumdesign.srp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchWidget extends AbstractComponent{

    @FindBy(name="q")
    private WebElement searchBox;

    public SearchWidget(final WebDriver driver) {
        super(driver);

    }

    public void enter(String keyword) {
        searchBox.clear();
        searchBox.sendKeys(keyword);
    }


    @Override
    public boolean isDisplayed() {
        return wait.until(_ -> searchBox.isDisplayed());
    }
}
