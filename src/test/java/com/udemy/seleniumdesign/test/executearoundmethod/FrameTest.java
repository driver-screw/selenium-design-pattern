package com.udemy.seleniumdesign.test.executearoundmethod;

import com.udemy.seleniumdesign.executearoundmethod.MainPage;
import com.udemy.seleniumdesign.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    private MainPage mainPage;

    @BeforeTest
    public void setMainPage() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void frameTest() {
        mainPage.goTo();
        mainPage.onFrameA(frameA -> frameA.setFirstName("fn1"));
        mainPage.onFrameB(frameB -> frameB.setFirstName("fn2"));
        mainPage.onFrameC(frameC -> frameC.setLastName("LAST NAME 3"));
    }
}
