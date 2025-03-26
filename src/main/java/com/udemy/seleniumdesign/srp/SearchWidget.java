package com.udemy.seleniumdesign.srp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchWidget extends AbstractComponent{

    private WebDriverWait wait;
    
    @FindBy(name="q")
    private WebElement searchBox;

    public SearchWidget(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }
}
