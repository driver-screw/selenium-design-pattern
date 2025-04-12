package com.udemy.seleniumdesign.test.decorator.assignment;

import com.udemy.seleniumdesign.decorator.assignment.MacBuyPage;
import com.udemy.seleniumdesign.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.function.Consumer;

public class AssignmentDecoratorMacBuyPageTest extends BaseTest {

    private MacBuyPage macBuyPage;

    @BeforeTest
    public void setup() {
        macBuyPage = new MacBuyPage(driver);
    }

    @Test(dataProvider = "getData")
    public void roleTest(Consumer<MacBuyPage> scenario) {
        macBuyPage.goTo();
        scenario.accept(macBuyPage);

    }

    @DataProvider
    public Object[] getData() {
        return new Object[]{
                Decorators.successValidCC,
                Decorators.successDiscountValidCC,
                Decorators.successFreePromo,
                Decorators.failInvalidCC,
                Decorators.failDiscountInvalidCC,
                Decorators.failNoPay
        };
    }
}
