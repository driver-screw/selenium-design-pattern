package com.udemy.seleniumdesign.command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class HomePage {

    private final WebDriver driver;

    @FindBy(css = ".button-box .btn-info")
    private WebElement infoButton;

    @FindBy(css = ".button-box .btn-warning")
    private WebElement warningButton;

    @FindBy(css = ".button-box .btn-success")
    private WebElement successButton;

    @FindBy(css = ".button-box .btn-danger")
    private WebElement dangerButton;

    @FindBy(css = ".jq-icon-info")
    private WebElement infoAlert;

    @FindBy(css = ".jq-icon-warning")
    private WebElement warningAlert;

    @FindBy(css = ".jq-icon-success")
    private WebElement successAlert;

    @FindBy(css = ".jq-icon-error")
    private WebElement dangerAlert;

    @FindBy(css = ".card-body .row div:nth-child(2) .alert-info")
    private WebElement dismissalInfoAlert;

    @FindBy(css = ".card-body .row div:nth-child(2) .alert-success")
    private WebElement dismissalSuccessAlert;

    @FindBy(css = ".card-body .row div:nth-child(2) .alert-danger")
    private WebElement dismissalDangerAlert;

    @FindBy(css = ".card-body .row div:nth-child(2) .alert-warning")
    private WebElement dismissalWarningAlert;


    public HomePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://vins-udemy.s3.amazonaws.com/ds/admin-template/admin-template.html");
    }

    public List<ElementValidator> getElementValidators() {

        return Arrays.asList(
                new NotificationValidator(infoButton, infoAlert),
                new NotificationValidator(successButton, successAlert),
                new NotificationValidator(warningButton, warningAlert),
                new NotificationValidator(dangerButton, dangerAlert),

                new DismissalAlertValidator(dismissalInfoAlert),
                new DismissalAlertValidator(dismissalSuccessAlert),
                new DismissalAlertValidator(dismissalWarningAlert),
                new DismissalAlertValidator(dismissalDangerAlert)

        );
    }
}
