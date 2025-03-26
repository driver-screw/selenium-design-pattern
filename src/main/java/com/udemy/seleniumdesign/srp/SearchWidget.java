package com.udemy.seleniumdesign.srp;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SearchWidget extends AbstractComponent{

    @FindBy(name="q")
    private WebElement searchBox;

    public SearchWidget(final WebDriver driver) {
        super(driver);

    }

    public void enter(String keyword) {
        searchBox.clear();
        for (char c : keyword.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MILLISECONDS);
            searchBox.sendKeys(Character.toString(c));

        }
    }


    @Override
    public boolean isDisplayed() {
        return wait.until(_ -> searchBox.isDisplayed());
    }
}
