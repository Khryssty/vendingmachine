package com.techelevator.utility;

import java.math.BigDecimal;

public class AccountBalance {
    private BigDecimal accountBalance = BigDecimal.valueOf(0.00);
    private BigDecimal change;

    public AccountBalance() {
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public BigDecimal getChange() {
        return change;
    }

    public void addToCurrentBalance(BigDecimal money) {
        accountBalance.add(money);
    }
}
