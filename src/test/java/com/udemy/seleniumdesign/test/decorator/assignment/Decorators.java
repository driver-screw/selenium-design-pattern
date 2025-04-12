package com.udemy.seleniumdesign.test.decorator.assignment;

import com.udemy.seleniumdesign.decorator.assignment.MacBuyPage;

import java.util.function.Consumer;

import static org.testng.Assert.assertEquals;

public class Decorators {

    private static final Consumer<MacBuyPage> enterFreePromocode =
            page -> page.applyCoupon("FREEUDEMY");
    private static final Consumer<MacBuyPage> enterDiscountPromocode =
            page -> page.applyCoupon("PARTIALUDEMY");


    private static final Consumer<MacBuyPage> enterValidCC =
            page -> page.enterCcInfo("4111111111111111", "2023", "123");

    private static final Consumer<MacBuyPage> enterInValidCC =
            page -> page.enterCcInfo("4111111111111119", "2021", "125");

    private static final Consumer<MacBuyPage> buy = MacBuyPage::buy;

    private static final Consumer<MacBuyPage> statusPass =
            page -> assertEquals(page.getStatus(), "PASS");

    private static final Consumer<MacBuyPage> statusFail =
            page -> assertEquals(page.getStatus(), "FAIL");


    public static final Consumer<MacBuyPage> successValidCC = enterValidCC.andThen(buy).andThen(statusPass);
    public static final Consumer<MacBuyPage> successDiscountValidCC = enterDiscountPromocode
            .andThen(enterValidCC)
            .andThen(buy)
            .andThen(statusPass);

    public static final Consumer<MacBuyPage> successFreePromo = enterFreePromocode
            .andThen(buy)
            .andThen(statusPass);

    public static final Consumer<MacBuyPage> failDiscountInvalidCC = enterDiscountPromocode
            .andThen(enterInValidCC)
            .andThen(buy)
            .andThen(statusFail);

    public static final Consumer<MacBuyPage> failInvalidCC = enterInValidCC
            .andThen(buy)
            .andThen(statusFail);

    public static final Consumer<MacBuyPage> failNoPay = buy.andThen(statusFail);
}
