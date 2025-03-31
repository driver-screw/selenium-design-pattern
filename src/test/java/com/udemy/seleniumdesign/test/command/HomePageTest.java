package com.udemy.seleniumdesign.test.command;

import com.udemy.seleniumdesign.command.ElementValidator;
import com.udemy.seleniumdesign.command.HomePage;
import com.udemy.seleniumdesign.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeTest
    public void setHomePage() {
        homePage = new HomePage(driver);
    }


    @Test(dataProvider = "getData")
    public void homePageTest(ElementValidator validator) {
        homePage.goTo();
        assertTrue(validator.validate())
        ;
    }

    @DataProvider
    public Object[] getData() {
        return homePage.getElementValidators().toArray();
    }
}
