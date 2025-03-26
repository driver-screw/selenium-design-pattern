package com.udemy.seleniumdesign.srp.result;

import com.udemy.seleniumdesign.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends AbstractComponent {

    @FindBy(className = "crJ18e")
    private WebElement bar;

    @FindBy(linkText = "Images")
    private WebElement images;

    @FindBy(linkText = "News")
    private WebElement news;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public void geToImages() {
        images.click();
    }

    public void geTonews() {
        news.click();
    }

    @Override
    public boolean isDisplayed() {
        return wait.until(_ -> bar.isDisplayed());
    }
}
