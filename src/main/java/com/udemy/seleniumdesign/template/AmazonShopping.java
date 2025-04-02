package com.udemy.seleniumdesign.template;

import com.udemy.seleniumdesign.template.pages.AmazonProductDescriptionPage;
import com.udemy.seleniumdesign.template.pages.AmazonResultsPage;
import com.udemy.seleniumdesign.template.pages.AmazonSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AmazonShopping extends ShoppingTemplate {
    private WebDriver driver;
    private String product;

    private AmazonSearchPage amazonSearchPage;
    private AmazonResultsPage amazonResultsPage;
    private AmazonProductDescriptionPage amazonProductDescriptionPage;


    public AmazonShopping(final WebDriver driver, String product) {
        this.driver = driver;
        this.product = product;
        amazonSearchPage = PageFactory.initElements(driver, AmazonSearchPage.class);
        amazonResultsPage = PageFactory.initElements(driver, AmazonResultsPage.class);
        amazonProductDescriptionPage = PageFactory.initElements(driver, AmazonProductDescriptionPage.class);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void launchSite() {
        amazonSearchPage.goTo();
    }

    @Override
    public void searchForProduct() {
        amazonSearchPage.searchForProduct(product);
    }

    @Override
    public void selectProduct() {
        amazonResultsPage.selectProduct();
    }

    @Override
    public void buy() {
        amazonProductDescriptionPage.buy();
    }
}
