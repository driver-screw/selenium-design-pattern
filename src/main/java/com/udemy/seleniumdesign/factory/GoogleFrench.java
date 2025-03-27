package com.udemy.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleFrench extends GoogleEnglish {

    @FindBy(css = "div#gws-output-pages-elements-homepage_additional_languages_als a")
    private WebElement language;

    public GoogleFrench(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        driver.get("https://www.google.fr");
        language.click();
    }

}
