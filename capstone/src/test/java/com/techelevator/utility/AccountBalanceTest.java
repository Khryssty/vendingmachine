package com.techelevator.utility;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountBalanceTest {

    @Test
    void getChangeMethod() {
        AccountBalance accountBalance = new AccountBalance();
        accountBalance.setAccountBalance(new BigDecimal(3.00));
        BigDecimal totalCost = new BigDecimal(1.25);

        BigDecimal actual = accountBalance.getChangeMethod(totalCost);
        BigDecimal expected = new BigDecimal(1.75);

        assertEquals(expected,actual);



    }
}