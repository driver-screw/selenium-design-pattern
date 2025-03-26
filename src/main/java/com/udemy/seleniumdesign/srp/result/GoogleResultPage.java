package com.udemy.seleniumdesign.srp.result;

import com.udemy.seleniumdesign.srp.common.SearchSuggestion;
import com.udemy.seleniumdesign.srp.common.SearchWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultPage {
    private WebDriver driver;

    private SearchSuggestion searchSuggestion;
    private SearchWidget searchWidget;
    private NavigationBar navigationBar;
    private ResultStat resultStat;

    public GoogleResultPage(final WebDriver driver) {
        this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.navigationBar = PageFactory.initElements(driver, NavigationBar.class);
        this.resultStat = PageFactory.initElements(driver, ResultStat.class);
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    public ResultStat getResultStat() {
        return resultStat;
    }
}
