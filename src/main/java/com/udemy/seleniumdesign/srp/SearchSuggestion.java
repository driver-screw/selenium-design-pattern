package com.udemy.seleniumdesign.srp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchSuggestion extends AbstractComponent {

    private WebDriverWait wait;

    @FindBy(css = "li.sbct")
    private List<WebElement> suggestions;

    public SearchSuggestion(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void cliskSuggestionByIndex(int index) {
        suggestions.get(index - 1).click();
    }

    @Override
    public boolean isDisplayed() {
        return wait.until(_ -> suggestions.size() > 5);
    }
}
