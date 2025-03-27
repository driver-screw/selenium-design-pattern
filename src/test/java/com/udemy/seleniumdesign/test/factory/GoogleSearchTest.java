package com.udemy.seleniumdesign.test.factory;

import com.udemy.seleniumdesign.factory.GoogleFactory;
import com.udemy.seleniumdesign.factory.GooglePage;
import com.udemy.seleniumdesign.test.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

    private GooglePage googlePage;

    @Test(dataProvider = "getData")
    public void searchTest(String language, String keyword) {

        googlePage = GoogleFactory.get(language, driver);
        googlePage.launchSite();
        googlePage.search(keyword);
        int resultCount = googlePage.getResultCount();

        System.out.println("Result count : " + resultCount);
    }


    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"ENG", "selenium"},
                {"FR", "selenium"},
                {"SA", "selenium"}
        };
    }

}
