package com.udemy.seleniumdesign.test.decorator;

import com.udemy.seleniumdesign.decorator.DashboardPage;
import com.udemy.seleniumdesign.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.function.Consumer;

public class DashboardTest extends BaseTest {

    private DashboardPage dashboardPage;

    @BeforeTest
    public void setup() {
        dashboardPage = new DashboardPage(driver);
    }

    @Test(dataProvider = "getData")
    public void roleTest(Consumer<DashboardPage> role) {
        dashboardPage.goTo();
        role.accept(dashboardPage);

    }

    @DataProvider
    public Object[] getData() {
        return new Object[]{
                Decorators.guestPage,
                Decorators.superUserPage,
                Decorators.adminPage
        };
    }
}
