package com.udemy.seleniumdesign.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentObjectFactory {

    private static final Supplier<PaymentOption> CC = CreditCardPaymentOption::new;
    private static final Supplier<PaymentOption> NB = NetBankingPaymentOption::new;

    private static final Map<String, Supplier<PaymentOption>> MAP = new HashMap<>();

    static {
        MAP.put("CC", CC);
        MAP.put("NB", NB);
    }

    public static PaymentOption get(String option) {
        return MAP.get(option).get();
    }
}
