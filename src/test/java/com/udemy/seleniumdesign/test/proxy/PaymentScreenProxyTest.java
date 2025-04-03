package com.udemy.seleniumdesign.test.proxy;


import com.udemy.seleniumdesign.proxy.PaymentObjectFactory;
import com.udemy.seleniumdesign.proxy.PaymentScreen;
import com.udemy.seleniumdesign.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.util.Map;

public class PaymentScreenProxyTest extends BaseTest {

    private PaymentScreen paymentScreen;

    @BeforeTest
    public void setPaymentScreen() {
//        System.setProperty("env", "QA");
        System.setProperty("env", "PROD");
        paymentScreen = new PaymentScreen(driver);
    }

    @Test(dataProvider = "getData")
    public void paymentTest(String paymentOption, Map<String, String> paymentDetails) {
        paymentScreen.goTo();
        paymentScreen.getUserInformation().enterDetails("vinoth", "selvaraj", "udemy@gamil.com");
        paymentScreen.setPaymentOption(PaymentObjectFactory.get(paymentOption));
        paymentScreen.pay(paymentDetails);
        String orderNumber = paymentScreen.getOrder().placeOrder();
        System.out.println("Order numver: " + orderNumber);
    }

    @DataProvider
    public Object[][] getData() {
        Map<String, String> cc = Maps.newHashMap();
        cc.put("cc", "12341234123");
        cc.put("year", "2023");
        cc.put("cvv", "123");

        Map<String, String> nb = Maps.newHashMap();
        nb.put("bank", "WELLS FARGO");
        nb.put("year", "myaccount123");
        nb.put("pin", "999");


        return new Object[][]{
                {"CC", cc},
                {"NB", nb}
        };
    }
}
