package com.udemy.seleniumdesign.test.decorator;

import com.udemy.seleniumdesign.decorator.DashboardPage;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Consumer;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Decorators {

    public static void shouldDisplay(List<WebElement> elements) {
        elements.forEach(element -> assertTrue(element.isDisplayed()));
    }

    public static void shouldNotDisplay(List<WebElement> elements) {
        elements.forEach(element -> assertFalse(element.isDisplayed()));
    }

    //ingredients

    private static final Consumer<DashboardPage> adminComponentPresent =
            dashPage -> shouldDisplay(dashPage.getAdminComponents());

    private static final Consumer<DashboardPage> adminComponentNotPresent =
            dashPage -> shouldNotDisplay(dashPage.getAdminComponents());


    private static final Consumer<DashboardPage> superUserComponentPresent =
            dashPage -> shouldDisplay(dashPage.getSuperUserComponents());

    private static final Consumer<DashboardPage> superUserComponentNotPresent =
            dashPage -> shouldNotDisplay(dashPage.getSuperUserComponents());


    private static final Consumer<DashboardPage> guestComponentPresent =
            dashPage -> shouldDisplay(dashPage.getGuestComponents());

    private static final Consumer<DashboardPage> guestComponentNotPresent =
            dashPage -> shouldNotDisplay(dashPage.getGuestComponents());


    //role selection
    private static final Consumer<DashboardPage> adminSelection =
            dashPage -> dashPage.selectRole("admin");
    private static final Consumer<DashboardPage> superUserSelection =
            dashPage -> dashPage.selectRole("superuser");
    private static final Consumer<DashboardPage> guestSelection =
            dashPage -> dashPage.selectRole("guest");


    // user role pages

    public static final Consumer<DashboardPage> guestPage = guestSelection.andThen(guestComponentPresent)
            .andThen(adminComponentNotPresent)
            .andThen(superUserComponentNotPresent);

    public static final Consumer<DashboardPage> superUserPage = superUserSelection.andThen(guestComponentPresent)
            .andThen(superUserComponentPresent)
            .andThen(adminComponentNotPresent);

    public static final Consumer<DashboardPage> adminPage = adminSelection.andThen(guestComponentPresent)
            .andThen(superUserComponentPresent)
            .andThen(adminComponentPresent);

}
