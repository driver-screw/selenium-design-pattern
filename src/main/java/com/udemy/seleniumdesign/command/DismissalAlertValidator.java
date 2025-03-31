package com.udemy.seleniumdesign.command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DismissalAlertValidator extends ElementValidator {
    private final WebElement dismissalAlert;

    public DismissalAlertValidator(WebElement dismissalAlert) {
        this.dismissalAlert = dismissalAlert;
    }

    @Override
    public boolean validate() {
        boolean appearResult = dismissalAlert.isDisplayed();
        dismissalAlert.findElement(By.cssSelector("button.close")).click();
        boolean disappearResult = dismissalAlert.isDisplayed();
        return appearResult && !(disappearResult);
    }
}
