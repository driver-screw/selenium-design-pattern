package com.udemy.seleniumdesign.test.srp;

import com.udemy.seleniumdesign.srp.GoogleMainPage;
import com.udemy.seleniumdesign.srp.GoogleResultPage;
import com.udemy.seleniumdesign.test.BestTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class GoogleTest extends BestTest {

    private GoogleMainPage googleMainPage;
    private GoogleResultPage googleResultPage;

    @BeforeTest
    public void setupPages() {
        this.googleMainPage = new GoogleMainPage(driver);
        this.googleResultPage = new GoogleResultPage(driver);
    }

    @Test
    public void googleWorkflow() {
        String keyword = "selenuim webdriver";
        int index = 3;

        googleMainPage.goTo();
        assertTrue(googleMainPage.getSearchWidget().isDisplayed());

        googleMainPage.getSearchWidget().enter(keyword);
        assertTrue(googleMainPage.getSearchSuggestion().isDisplayed());

        googleMainPage.getSearchSuggestion().cliskSuggestionByIndex(index);
        assertTrue(googleResultPage.getNavigationBar().isDisplayed());


        googleResultPage.getSearchWidget().enter(keyword);
        assertTrue(googleResultPage.getSearchSuggestion().isDisplayed());

        googleResultPage.getSearchSuggestion().cliskSuggestionByIndex(index);
        assertTrue(googleResultPage.getNavigationBar().isDisplayed());

        googleResultPage.getNavigationBar().geTonews();
        System.out.println(googleResultPage.getResultStat().getStat());


    }
}
